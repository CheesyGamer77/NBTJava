package NBTJava;

import java.nio.charset.StandardCharsets;

public final class TagByte {
    private static final int ID = 1;
    private final String name;
    private final byte value;

    public TagByte(String tagName, byte tagValue) {
        /*
         * Creates a new TagByte object from a name and value (for creating new tags)
         */

        name = tagName;
        value = tagValue;
    }

    public TagByte(byte[] bytes) {
        /*
         * Creates a new TagByte object based on a byte array.
         *
         * The first byte must be the tag's id
         */

        int nameLength = ((bytes[1] & 0xff) << 8 | (bytes[2] & 0xff));

        // set the name of the tag
        String tempName = "";
        for(int i = 3; i < nameLength + 3; i++) {
            // cant convert a single byte to a string, have to convert to a byte array
            byte[] tempArray = {bytes[i]};
            tempName = tempName.concat(new String(tempArray, StandardCharsets.UTF_8));
        }
        name = tempName;

        // set the value of the tag
        value = bytes[3 + nameLength];
    }

    public String toString() {
        /*
         * Returns the string representation of this byte tag
         */

        return String.format("%s:%sb", name, value);
    }

    public byte[] getBytes() {
        /*
         * Returns the raw byte array representation of this NBT tag
         */

        int nameLength = name.toCharArray().length; // length of the tag name for the second and third bytes
        byte[] bytes = new byte[4 + nameLength];

        // set the id and name length bytes
        bytes[0] = ID;
        bytes[1] = (byte) (nameLength >> 8);
        bytes[2] = (byte) (nameLength);

        // set the name bytes (encoded in UTF-8)
        byte[] nameBytes = name.getBytes(StandardCharsets.UTF_8);
        for(int i = 3; i < nameBytes.length + 3; i++) {
            bytes[i] = nameBytes[(i-3)];
        }

        bytes[bytes.length-1] = value; // last index is always the value of the byte tag

        return bytes;
    }
}
