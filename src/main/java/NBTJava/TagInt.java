package NBTJava;

public class TagInt {
    private final int id = 3;
    private int value;
    private String name;

    public TagInt(String tagName, int tagValue) {
        name = tagName;
        value = tagValue;
    }
}
