import java.lang.reflect.Field;

public class Temp1813 {
    static {
        try {
            Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
            field.setAccessible(true);
            field.set(null, java.lang.Boolean.FALSE);
        } catch (Exception ex) {
            // Report the exception
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Your main logic here
        System.out.println("Static block executed");
    }
}