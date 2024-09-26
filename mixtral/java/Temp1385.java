import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Main.class.getClassLoader();
            Class<?> clazz = Class.forName("com.example.Untrusted", true, classLoader);
            Constructor<?> constructor = clazz.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            Object instance = constructor.newInstance();
            System.out.println("Instance created: " + instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


Note: Ensure that the class `com.example.Untrusted` exists in your classpath for this code to work correctly.