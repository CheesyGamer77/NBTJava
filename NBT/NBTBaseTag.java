package NBT;

public class NBTBaseTag {
    String name = null;
    Object value = null;

    NBTBaseTag(String tagName, Object tagValue) {
        name = tagName;
        value = tagValue;
    }

    public String toString() {
        return "NBT Base Tag '" + name + "' with value of '" + value + "'";
    }
}
