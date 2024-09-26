import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("com.hexgen.api.facade.HexgenWebAPI");
            Constructor<?> constructor = cls.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object obj = constructor.newInstance();

            Method createRequisitionMethod = cls.getDeclaredMethod(
                "createRequisition", CreateRequisitionRO[].class, boolean.class);
            createRequisitionMethod.setAccessible(true);

            CreateRequisitionRO[] request = new CreateRequisitionRO[10];
            boolean validateOnly = true;

            // Call the method with your parameters
            createRequisitionMethod.invoke(obj, (Object) request, validateOnly);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Assuming this is the definition of CreateRequisitionRO
class CreateRequisitionRO {
    // Add fields and methods as per the actual class definition
}