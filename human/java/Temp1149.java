import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

public class Temp1149 {
    public static void main(String[] args) {
        // Create a sample container with some components
        Container container = new JPanel();
        container.add(new JButton("Button 1"));
        container.add(new JLabel("Label 1"));
        
        final Container c = container;
        final AtomicReference<Object[]> result = new AtomicReference<>();
        
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    result.set(c.getComponents());
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
        Object[] components = result.get();
        Vector<Component> componentVector = convertArrayToVector(components);
        
        // Print components in vector
        for (Component comp : componentVector) {
            System.out.println(comp);
        }
    }
    
    public static Vector<Component> convertArrayToVector(Object[] array) {
        Vector<Component> vector = new Vector<>();
        for (Object obj : array) {
            if (obj instanceof Component) {
                vector.add((Component) obj);
            }
        }
        return vector;
    }
}