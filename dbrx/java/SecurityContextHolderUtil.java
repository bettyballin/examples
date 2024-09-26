// Define missing classes to make the code executable
class Authentication {
    private String name;

    public Authentication(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class SecurityContextHolder {
    public static void clearContext() {
        // Dummy implementation
        System.out.println("SecurityContextHolder: Context cleared.");
    }
}

// The original class
public final class SecurityContextHolderUtil {

    private static InheritableThreadLocal<Authentication> authenticationInheritableThreadLocal = new InheritableThreadLocal<>();

    public static void setAuthentication(Authentication authentication) {
        if (authentication == null) {
            clearContext();
        } else {
            authenticationInheritableThreadLocal.set(authentication);
        }
    }

    public static Authentication getAuthentication() {
        return authenticationInheritableThreadLocal.get();
    }

    private static void clearContext() {
        SecurityContextHolder.clearContext();
        authenticationInheritableThreadLocal.remove();
    }

    // Main method to test the class
    public static void main(String[] args) {
        Authentication auth = new Authentication("user123");
        setAuthentication(auth);
        System.out.println("Authentication set: " + getAuthentication().getName());

        setAuthentication(null);
        System.out.println("Authentication cleared: " + (getAuthentication() == null ? "null" : getAuthentication().getName()));
    }
}