package NBTJava;

public class TagIntArray {
    private final int id = 11;
    private int[] value;
    private String name;

    public TagIntArray(String tagName, int[] tagValue) {
        name = tagName;
        value = tagValue;
    }
}
