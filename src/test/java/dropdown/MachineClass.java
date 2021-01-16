package dropdown;

public enum MachineClass {

    REGULAR("Regular"),
    PREEMPTIBLE("Preemptible");

    private String name;

    MachineClass(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static String get (String name) {
        return name;
    }
}
