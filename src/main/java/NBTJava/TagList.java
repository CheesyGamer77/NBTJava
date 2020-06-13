package NBTJava;

import java.util.ArrayList;

public final class TagList {
    private static final int id = 9;
    private String name;
    private ArrayList value;

    public TagList(String tagName, ArrayList tagValue) {
        name = tagName;
        value = tagValue;
    }
}
