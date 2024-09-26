import java.util.ArrayList;
import java.util.List;

class Foo implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class MaliciousSubclass extends Foo {
    public static List<Foo> recordedInstances = new ArrayList<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Record the instance before returning it
        MaliciousSubclass clone = (MaliciousSubclass) super.clone();
        recordedInstances.add(clone);
        return clone;
    }

    public static void main(String[] args) {
        try {
            MaliciousSubclass original = new MaliciousSubclass();
            MaliciousSubclass cloned = (MaliciousSubclass) original.clone();
            
            System.out.println("Original instance: " + original);
            System.out.println("Cloned instance: " + cloned);
            System.out.println("Recorded instances: " + recordedInstances);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}