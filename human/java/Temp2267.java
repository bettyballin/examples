public class Temp2267 {
    public static void main(String[] args) {
        // Mock SecurityContextHolder and CurrentUser for demonstration purposes
        SecurityContextHolder.setContext(new SecurityContext(new Authentication(new CurrentUser("username"))));
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Current user: " + user.getUsername());
    }
}

class SecurityContextHolder {
    private static SecurityContext context;

    public static SecurityContext getContext() {
        return context;
    }

    public static void setContext(SecurityContext context) {
        SecurityContextHolder.context = context;
    }
}

class SecurityContext {
    private Authentication authentication;

    public SecurityContext(Authentication authentication) {
        this.authentication = authentication;
    }

    public Authentication getAuthentication() {
        return authentication;
    }
}

class Authentication {
    private CurrentUser principal;

    public Authentication(CurrentUser principal) {
        this.principal = principal;
    }

    public CurrentUser getPrincipal() {
        return principal;
    }
}

class CurrentUser {
    private String username;

    public CurrentUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}