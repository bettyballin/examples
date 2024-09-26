import javax.swing.*;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

public class Utils {
    // Assume there's a method signature here similar to this:
    public static Vector convertArrayToVector(Object[] components) {
        // Implementation of converting an array to a vector
        return new Vector(); // Placeholder for the actual implementation
    }

    public static void main(String[] args) {
        final Container container = new Container(); // Placeholder for the actual container
        final AtomicReference<Object[]> result = new AtomicReference<>();
        try {
            SwingUtilities.invokeAndWait(() -> result.set(container.getComponents()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        Object[] components = result.get();
        Vector componentVector = Utils.convertArrayToVector(components);
        // Now you have the vector of components
    }
}