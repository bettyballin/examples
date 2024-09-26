import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CreateRequisitionRO {
    // Assuming this class has some properties
}

public class Main {
    public static void main(String[] args) {
        Class<?> cls;
        CreateRequisitionRO[] request = new CreateRequisitionRO[10];
        try {
            // Load the HexgenWebAPI at runtime
            cls = Class.forName("com.hexgen.api.facade.HexgenWebAPI");

            Object obj = cls.getDeclaredConstructor().newInstance();

            Method method = cls.getMethod("createRequisition", CreateRequisitionRO[].class, boolean.class);

            // Invoke the createRequisition() with request and true as parameters
            method.invoke(obj, (Object) request, true);

        } catch (ClassNotFoundException | NoSuchMethodException
                | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException ex) {

            // Handle exceptions properly
            System.err.println("Error occurred: " + ex);
        }
    }
}