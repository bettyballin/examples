import java.util.Date;

class Foo {
  private final Date date;

  Foo() { this.date = new Date(); }

  Date getDate() { return (Date) date.clone(); }
}