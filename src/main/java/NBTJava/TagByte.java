package NBTJava;

import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.nio.charset.StandardCharsets;

public final class TagByte {
    private final int ID = 1;
    private final byte value;
    private final String name;

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
        return String.format("%bb", value);
    }
}
