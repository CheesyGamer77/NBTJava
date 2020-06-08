package NBTJava;

public class TagByte {
    private final int id = 1;
    private byte value;
    private String name;

    public TagByte(String tagName, byte tagValue) {
        name = tagName;
        value = tagValue;
    }
}
