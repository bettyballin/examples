interface MyService {
    void doSomething();
}

public class Foo implements MyService {
    private String verySecretString;

    public Foo(String secret) {
        this.verySecretString = secret;
    }

    public void doSomething() {
        System.out.println("Doing something with " + verySecretString);
    }

    public static void main(String[] args) {
        Foo foo = new Foo("superSecret");
        foo.doSomething();
    }
}