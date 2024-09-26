public class MyCustomSecurityManager extends SecurityManager {
    @Override
    public void checkExit(int status) throws SecurityException {
        throw new ExitNotAllowedException("System exit is not allowed");
    }
}

class ExitNotAllowedException extends RuntimeException {
    public ExitNotAllowedException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        System.setSecurityManager(new MyCustomSecurityManager());
        try {
            System.exit(0);
        } catch (ExitNotAllowedException e) {
            System.out.println(e.getMessage());
        }
    }
}