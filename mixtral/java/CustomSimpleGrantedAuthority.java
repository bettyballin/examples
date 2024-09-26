import org.springframework.security.core.GrantedAuthority;

public class CustomSimpleGrantedAuthority implements GrantedAuthority {

    private final String permission;

    public CustomSimpleGrantedAuthority(String permission) {
        this.permission = permission;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + permission;
    }

    // Add a method to check if the authority matches with given route
    public boolean matchesRoute(String route) {
        return route.equalsIgnoreCase(this.permission);
    }

    public static void main(String[] args) {
        CustomSimpleGrantedAuthority authority = new CustomSimpleGrantedAuthority("ADMIN");
        System.out.println("Authority: " + authority.getAuthority());
        System.out.println("Matches 'ADMIN': " + authority.matchesRoute("ADMIN"));
        System.out.println("Matches 'USER': " + authority.matchesRoute("USER"));
    }
}