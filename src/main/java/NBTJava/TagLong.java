package NBTJava;

public class TagLong {
    private final int id = 4;
    private long value;
    private String name;

    public TagLong(String tagName, long tagValue) {
        name = tagName;
        value = tagValue;
    }
}
