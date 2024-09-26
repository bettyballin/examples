public class CustomAuthorizationStrategy implements IAuthorizationStrategy {
    @Override
    public <T> boolean isInstantiationAuthorized(Class<T> componentClass) {
        // Check here whether current user can access pages of type T

        return true;  // or false if not allowed
    }

    @Override
    public boolean isActionAuthorized(Component component, Action action) {
        // Implement your logic to check whether the action is authorized
        return true;  // or false if not allowed
    }

    @Override
    public <T> void authorizeInstantiation(Class<T> componentClass) throws AuthorizationException {
        if (!isInstantiationAuthorized(componentClass)) {
            throw new AuthorizationException("Instantiation not authorized for class: " + componentClass.getName());
        }
    }
}

interface IAuthorizationStrategy {
    <T> boolean isInstantiationAuthorized(Class<T> componentClass);

    boolean isActionAuthorized(Component component, Action action);

    <T> void authorizeInstantiation(Class<T> componentClass) throws AuthorizationException;
}

class Component {
    // Dummy placeholder for actual component class
}

class Action {
    // Dummy placeholder for actual action class
}

class AuthorizationException extends Exception {
    public AuthorizationException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        CustomAuthorizationStrategy strategy = new CustomAuthorizationStrategy();
        try {
            strategy.authorizeInstantiation(Main.class);
            System.out.println("Instantiation authorized");
        } catch (AuthorizationException e) {
            System.out.println(e.getMessage());
        }
    }
}