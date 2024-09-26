import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClass1 {
    public Object get(Field field) {
        boolean isAccessible = field.canAccess(this);
        try {
            field.setAccessible(true); // Enable access to the private field
            return field.get(this);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(MyClass1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            field.setAccessible(isAccessible); // Restore original accessibility
        }
        return null;
    }
}