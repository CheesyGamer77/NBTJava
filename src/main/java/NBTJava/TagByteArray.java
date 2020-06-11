package NBTJava;

import java.nio.charset.StandardCharsets;

public final class TagByteArray {
    private final int ID = 7;
    private final String name;
    private final byte[] value;

    public TagByteArray(String tagName, byte[] tagValue) {
        name = tagName;
        value = tagValue;
    }

    public String toString() {
        String ret = "[B;";

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
        byte[] bytes = new byte[1 + 2 + nameLength + value.length];

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

        // set the size byte
        bytes[byteOffset] = (byte) value.length;

        // set the remaining payload bytes
        for(int i = byteOffset; i < bytes.length; i++) {
            bytes[i] = value[i - byteOffset];
        }

        return bytes;
    }
}
