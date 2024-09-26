// Dummy.java
package package1.b;

public class Dummy {
    public void safeMethod() {
        System.out.println("safeMethod() is called");
    }
}

// Test.java
package package1.b;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        try {
            Dummy dummy = new Dummy();
            Method method = Dummy.class.getDeclaredMethod("safeMethod");
            method.setAccessible(true);
            method.invoke(dummy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


To compile and run the code:

sh
javac package1/b/Dummy.java package1/b/Test.java
java package1.b.Test