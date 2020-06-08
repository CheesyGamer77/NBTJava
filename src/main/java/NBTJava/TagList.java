package NBTJava;

import java.util.ArrayList;

public class TagList {
    private final int id = 9;
    private ArrayList value;
    private String name;

    public TagList(String tagName, ArrayList tagValue) {
        name = tagName;
        value = tagValue;
    }
}
