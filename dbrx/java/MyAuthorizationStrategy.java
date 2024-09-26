import org.apache.wicket.Component;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;

public class MyAuthorizationStrategy implements IAuthorizationStrategy {
    @Override
    public boolean isInstantiationAuthorized(Class<?> componentClass) {
        // Check permissions here and return true/false accordingly
        return true; // example return
    }

    @Override
    public boolean isActionAuthorized(Component component, Action action) {
        // Check permission for the given action on this specific component instance.
        // Return false if you want to prevent any interaction with it (e.g clicking a button).
        return true; // example return
    }
    
    public static void main(String[] args) {
        MyAuthorizationStrategy strategy = new MyAuthorizationStrategy();
        // Example usage:
        System.out.println(strategy.isInstantiationAuthorized(SomeComponent.class));
        System.out.println(strategy.isActionAuthorized(new SomeComponent("someComponent"), Action.valueOf("ENABLE")));
    }
}

// Mock classes for demonstration purposes
class SomeComponent extends Component {
    public SomeComponent(String id) {
        super(id);
    }
}