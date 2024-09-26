public enum Outer {
    INSTANCE;

    // your methods here
}

class Inner {
   private final static Inner instance = new Inner();

   private Inner() {
       // private constructor to prevent instantiation
   }

   public static Inner getInstance() {
      return instance;
   }
}

// usage
public class Main {
    public static void main(String[] args) {
        Outer outer1 = Outer.INSTANCE;
        Inner inner1 = Inner.getInstance();
    }
}