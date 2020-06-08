package NBTJava;

import java.util.Hashtable;

public class TagCompound {
    private final int id = 9;
    private Hashtable<String, Object> value;
    private String name;

    public TagCompound(String tagName, Hashtable<String, Object> tagValue) {
        name = tagName;
        value = tagValue;
    }
}
