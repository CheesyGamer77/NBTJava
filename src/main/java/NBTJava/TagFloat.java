package NBTJava;

public class TagFloat {
    private final int id = 5;
    private float value;
    private String name;

    public TagFloat(String tagName, float tagValue) {
        name = tagName;
        value = tagValue;
    }
}
