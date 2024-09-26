import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OriginalMutableObject implements Cloneable {
    // Assuming some fields and methods are present here

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class MaliciousSubClass extends OriginalMutableObject {
    private static List<MaliciousSubClass> instances = new ArrayList<>();

    @Override
    public Object clone() throws CloneNotSupportedException {
        // Add the cloned instance into our list
        instances.add((MaliciousSubClass) super.clone());
        return this;
    }

    /**
     * This method allows an attacker to access all recorded references
     */
    public static List<MaliciousSubClass> getInstances() {
        return Collections.unmodifiableList(instances);
    }

    public static void main(String[] args) {
        try {
            // Example usage
            MaliciousSubClass obj1 = new MaliciousSubClass();
            MaliciousSubClass obj2 = (MaliciousSubClass) obj1.clone();

            System.out.println("Instances: " + MaliciousSubClass.getInstances());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}