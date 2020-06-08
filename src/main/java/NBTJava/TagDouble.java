package NBTJava;

public class TagDouble {
    private final int id = 6;
    private double value;
    private String name;

    public TagDouble(String tagName, double tagValue) {
        name = tagName;
        value = tagValue;
    }
}
