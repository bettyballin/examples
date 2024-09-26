public class A {
    private final B b;

    public A(B b) {
        this.b = b;
    }

    public void print() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        B bInstance = new B();
        A aInstance = new A(bInstance);
        aInstance.print();
    }
}

class B {
}

public class A {
    private final B b;

    public A(B b) {
        this.b = b;
    }

    public void print() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        B bInstance = new B();
        A aInstance = new A(bInstance);
        aInstance.print();
    }

    public static class B {
    }
}