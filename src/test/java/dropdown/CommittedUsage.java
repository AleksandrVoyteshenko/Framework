package dropdown;

public enum CommittedUsage {

    NONE("None"),
    ONE_YEAR("1 Year"),
    THREE_YEAR("3 Year");

    private String name;

    CommittedUsage(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static String get (String name) {
        return name;
    }
}
