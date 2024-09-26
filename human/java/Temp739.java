import java.lang.reflect.Field;
import java.util.Arrays;

public class Temp739 {
    public static void main(String[] args) {
        // Since we're in a static context, 'this' is not applicable. 
        // Instead, we'll use Temp739.class to refer to the class object.
        Field[] fields = Temp739.class.getDeclaredFields();
        Field[] publicFields = Reflection.filterFields(fields, true);
        
        // For demonstration, let's print out the public fields
        Arrays.stream(publicFields).forEach(field -> System.out.println(field.getName()));
    }
}

class Reflection {
    public static Field[] filterFields(Field[] fields, boolean publicOnly) {
        return Arrays.stream(fields)
                .filter(field -> !publicOnly || java.lang.reflect.Modifier.isPublic(field.getModifiers()))
                .toArray(Field[]::new);
    }
}