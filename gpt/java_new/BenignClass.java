import java.util.ArrayList;
import java.util.List;

public class BenignClass implements Cloneable {
    private int sensitiveData;

    public BenignClass(int data) {
        this.sensitiveData = data;
    }

    @Override
    public BenignClass clone() {
        try {
            return (BenignClass) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    // ... other methods ...
}

class MaliciousSubclass extends BenignClass {
    private static List<MaliciousSubclass> instances = new ArrayList<>();

    public MaliciousSubclass(int data) {
        super(data);
        instances.add(this);
    }

    @Override
    public MaliciousSubclass clone() {
        MaliciousSubclass cloned = (MaliciousSubclass) super.clone();
        instances.add(cloned);
        return cloned;
    }
}