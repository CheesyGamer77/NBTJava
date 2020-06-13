package NBTJava;

import java.nio.charset.StandardCharsets;

public final class TagByteArray {
    private static final int ID = 7;
    private final String name;
    private final byte[] value;

    public TagByteArray(String tagName, byte[] tagValue) {
        name = tagName;
        value = tagValue;
    }

    public TagByteArray(byte[] bytes) {
        /*
         * Creates a new TagByteArray object based on a byte array
         *
         * The first bit must be the tag's id
         */

        int nameLength = ((bytes[1] & 0xff) | (bytes[2] & 0xff));

        // set the name of the tag
        String tempName = "";
        int byteOffset = 0;
        for(int i = 3; i < nameLength + 3; i++) {
            // cant convert a single byte to a string, have to convert from a byte array
            byte[] tempArray = {bytes[i]};
            tempName = tempName.concat(new String(tempArray, StandardCharsets.UTF_8));
            byteOffset = i + 1;
        }
        name = tempName;

        // get the length of the list
        int valLength = ((bytes[byteOffset] & 0xff) | (bytes[byteOffset + 1] & 0xff) | (bytes[byteOffset + 2] & 0xff) | (bytes[byteOffset + 3] & 0xff));

        // set the value of the tag
        value = new byte[valLength];
        byteOffset += 4;
        for(int i = byteOffset; i < byteOffset + valLength; i++) {
            value[i - byteOffset] = bytes[i];
        }
    }

    public String toString() {
        String ret = String.format("%s:[B;", name);

        for(int i = 0; i < value.length; i++) {
            if(i != value.length - 1) {
                ret = ret.concat(value[i] + ",");
            }
            else {
                ret = ret.concat(value[i] + "]");
            }
        }

        return ret;
    }

    public byte[] getBytes() {
        /*
         * Returns the raw byte array representation of this NBT tag
         */

        int nameLength = name.toCharArray().length;
        byte[] bytes = new byte[1 + 2 + nameLength + 4 + value.length];

        // set the id and name length bytes
        bytes[0] = ID;
        bytes[1] = (byte) (nameLength >> 8);
        bytes[2] = (byte) (nameLength);

        // set the name bytes (encoded in UTF-8)
        byte[] nameBytes = name.getBytes(StandardCharsets.UTF_8);
        int byteOffset = 0;
        for(int i = 3; i < nameBytes.length + 3; i++) {
            bytes[i] = nameBytes[(i-3)];
            byteOffset = i + 1;
        }

        // set the size bytes
        bytes[byteOffset] = (byte) (value.length >> 24);
        bytes[byteOffset + 1] = (byte) (value.length >> 16);
        bytes[byteOffset + 2] = (byte) (value.length >> 8);
        bytes[byteOffset + 3] = (byte) value.length;
        byteOffset += 4;

        // set the remaining payload bytes
        for(int i = byteOffset; i < bytes.length; i++) {
            bytes[i] = value[i - byteOffset];
        }

        return bytes;
    }
}
