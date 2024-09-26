// In MyClass.java
package com.example;

public class MyClass {
  // Package private method
  void restrictedFunction() {
    System.out.println("Restricted function called!");
  }
}

// In SomeOtherClass.java
package com.example;

class SomeOtherClass {
   public static void main(String[] args) {
      MyClass obj = new MyClass();

     // Access the package-private function
     obj.restrictedFunction();
  }
}


sh
# Compile the Java files
javac -d . MyClass.java SomeOtherClass.java

# Run the main class
java com.example.SomeOtherClass