package NBTJava;

import java.util.Hashtable;

public class TagCompound {
    private final int id = 10;
    private Hashtable<String, Object> value;
    private String name;

    public TagCompound(String tagName, Hashtable<String, Object> tagValue) {
        name = tagName;
        value = tagValue;
    }
}
