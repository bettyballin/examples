import java.util.Date;

class Foo {
    private final Date date;

    Foo() { this.date = new Date(); }

    Date getDate() { return date; }

    public static void main(String[] args) {
        Foo foo = new Foo();
        System.out.println("Date: " + foo.getDate());
    }
}