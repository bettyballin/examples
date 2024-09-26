import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        // Assuming e.a.x.d is an inner class of some class, replace OuterClass with the actual enclosing class name
        // If e.a.x.d is a top-level class, remove the OuterClass reference
        try {
            Class<?> outerClass = Class.forName("e.a.x.d");
            Object instance = outerClass.getDeclaredConstructor().newInstance();

            Field aField = outerClass.getDeclaredField("a");
            aField.setAccessible(true);
            Object aValue = aField.get(instance);

            // Assuming e.a.x.e has a constructor that accepts an Object, replace with correct parameters if needed
            Class<?> eClass = Class.forName("e.a.x.e");
            Object eInstance = eClass.getDeclaredConstructor(Object.class).newInstance(aValue);

            System.out.println("Attribute value: " + eInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}