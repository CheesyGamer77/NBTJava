package NBTJava;

public class TagLongArray {
    private final int id = 12;
    private long[] value;
    private String name;

    public TagLongArray(String tagName, long[] tagValue) {
        name = tagName;
        value = tagValue;
    }
}
