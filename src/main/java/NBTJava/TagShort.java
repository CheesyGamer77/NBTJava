package NBTJava;

public class TagShort {
    private final int id = 2;
    private short value;
    private String name;

    public TagShort(String tagName, short tagValue) {
        name = tagName;
        value = tagValue;
    }
}
