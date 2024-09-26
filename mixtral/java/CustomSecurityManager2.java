import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomSecurityManager extends SecurityManager {
    private final Set<String> allowedPackages = new HashSet<>(Arrays.asList("com.example", "org.another"));

    @Override
    public void checkExit(int status) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        if (stackTraceElements != null && stackTraceElements.length > 1
                && allowedPackages.stream().anyMatch(pkg -> stackTraceElements[1].getClassName().startsWith(pkg))) {
            return;
        }

        throw new SecurityException("System exit not permitted");
    }

    public static void main(String[] args) {
        System.setSecurityManager(new CustomSecurityManager());

        try {
            System.exit(0);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}