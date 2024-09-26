class MyClass {
    // Example field
    private int value;

    // Constructor
    public MyClass(int value) {
        this.value = value;
    }

    // Copy constructor (not allowed, hence private)
    private MyClass(MyClass other) {
        this.value = other.value;
    }

    // Copy assignment method (not allowed, hence private)
    private void copyFrom(MyClass other) {
        this.value = other.value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        MyClass m = new MyClass(10);

        // MyClass m2 = new MyClass(m); // Copy construction isn't allowed
        // MyClass m3;
        // m3 = m; // Assignment also not allowed

        System.out.println(m.getValue());
    }
}