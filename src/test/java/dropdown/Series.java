package dropdown;

public enum Series {

    N1("n1"),
    N2("n2"),
    E2("e2"),
    N2D("n2d");

    private String name;

    Series (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static String get (String name) {
        return name;
    }
}