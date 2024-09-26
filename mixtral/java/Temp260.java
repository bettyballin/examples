import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpLiotSubClass {
    private String sampleField = "Sample Value";

    public Object get(Field field) {
        try {
            // Make the private/protected fields accessible
            field.setAccessible(true);

            return field.get(this);

        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(ExpLiotSubClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void main(String[] args) {
        try {
            ExpLiotSubClass instance = new ExpLiotSubClass();
            Field field = ExpLiotSubClass.class.getDeclaredField("sampleField");
            Object value = instance.get(field);
            System.out.println("Field value: " + value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}