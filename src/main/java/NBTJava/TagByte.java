package NBTJava;

import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.nio.charset.StandardCharsets;

public final class TagByte {
    private final int ID = 1;
    private final String name;
    private final byte value;

    public TagByte(String tagName, byte tagValue) {
        /*
         * Creates a new TagByte object from a name and value (for creating new tags)
         */

        name = tagName;
        value = tagValue;
    }

    public TagByte(GZIPInputStream inputStream, int byteOffset) throws IOException {
        /*
         * Creates a new TagByte object based off the data from a GZIPInputStream (for compressed NBT)
         *
         * The byte offset should be designated to the first byte of the tag (aka the tag type which should be
         * a TAG_Byte type anyways)
         */

        byte[] buffer = {};
        int offset = byteOffset + 1; // frankly we don't care about the tag type in our case, so skip that byte

        // read the next two bytes for the length of the name so we can setup the name buffer
        inputStream.read(buffer, offset, 2);
        offset += 2;

        // read a byte for the name
        inputStream.read(buffer, offset, 1);
        name = new String(buffer, StandardCharsets.UTF_8);
        offset += 1;

        // read the payload (1 byte) and set the value
        inputStream.read(buffer, offset, 1);
        value = buffer[0];
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

        bytes[0] = ID;

        // next two bits are the big endian unsigned integer for the name's length
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
