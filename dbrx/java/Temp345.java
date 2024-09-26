import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp345 {
    public static void main(String[] args) {
        CustomUserDetails customUserDetails = new CustomUserDetails(1, "John Doe");
        Authentication authentication = new CustomAuthentication(customUserDetails);
        SecurityContext securityContext = new SecurityContext();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);

        authentication = SecurityContextHolder.getContext().getAuthentication();
        customUserDetails  = (CustomUserDetails)authentication.getPrincipal();

        int id = customUserDetails.getId(); // Get ID
        String name = customUserDetails.getName(); // Get Name
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

class CustomUserDetails {
    private int id;
    private String name;

    public CustomUserDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class SecurityContextHolder {
    private static final ThreadLocal<SecurityContext> contextHolder = new ThreadLocal<>();

    public static SecurityContext getContext() {
        SecurityContext context = contextHolder.get();
        if (context == null) {
            context = new SecurityContext();
            contextHolder.set(context);
        }
        return context;
    }

    public static void setContext(SecurityContext context) {
        contextHolder.set(context);
    }
}

class SecurityContext {
    private Authentication authentication;

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}

interface Authentication {
    Object getPrincipal();
}

class CustomAuthentication implements Authentication {
    private final CustomUserDetails customUserDetails;

    public CustomAuthentication(CustomUserDetails customUserDetails) {
        this.customUserDetails = customUserDetails;
    }

    @Override
    public Object getPrincipal() {
        return customUserDetails;
    }
}