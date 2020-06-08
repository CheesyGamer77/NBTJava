package NBTJava;

public class TagString {
    private final int id = 8;
    private String value;
    private String name;

    public TagString(String tagName, String tagValue) {
        name = tagName;
        value = tagValue;
    }
}
