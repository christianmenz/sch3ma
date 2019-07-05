package ch.christianmenz.sch3ma.model;

/**
 * @author Christian Menz
 */
public enum Type {

    STRING("string"),
    OBJECT("object"),
    NUMBER("number"),
    ARRAY("array"),
    BOOLEAN("boolean");

    private String value;

    Type(String s) {
        value = s;
    }

    public String value() {
        return value;
    }
}
