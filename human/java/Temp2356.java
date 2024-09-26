import java.util.Collection;

public class Temp2356 {
    public static void main(String[] args) {
        boolean hasAuthorityAdmin = false;

        // Simulate SecurityContextHolder and AuthoritiesConstants
        SecurityContextHolder contextHolder = new SecurityContextHolder();
        AuthoritiesConstants.ADMIN = "ROLE_ADMIN";

        hasAuthorityAdmin = contextHolder.getContext().getAuthentication().getAuthorities().contains(AuthoritiesConstants.ADMIN);
        if (hasAuthorityAdmin) {
            System.out.println("redirect:/admin/");
        } else {
            System.out.println("redirect:/user/");
        }
    }
}

// Simulated classes for the example to work
class SecurityContextHolder {
    private static SecurityContext context = new SecurityContext();

    public SecurityContext getContext() {
        return context;
    }
}

class SecurityContext {
    private Authentication authentication = new Authentication();

    public Authentication getAuthentication() {
        return authentication;
    }
}

class Authentication {
    private Collection<String> authorities = java.util.Arrays.asList("ROLE_USER", "ROLE_ADMIN");

    public Collection<String> getAuthorities() {
        return authorities;
    }
}

class AuthoritiesConstants {
    public static String ADMIN;
}