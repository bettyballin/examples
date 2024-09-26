import java.security.Security;

public class Temp631 {

    public static void main(String[] args) {
        // Example usage
        System.out.println(getCurrentUsername());
    }

    public static String getCurrentUsername() {
        String jwtToken = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        JwtHelper jwtHelper = new JwtHelper();
        Jwt jwt = jwtHelper.parseJwt(jwtToken);
        return jwt.getClaimAsString("preferred_username");
    }
}

// Dummy classes to make the code executable

class SecurityContextHolder {
    public static SecurityContext getContext() {
        return new SecurityContext();
    }
}

class SecurityContext {
    public Authentication getAuthentication() {
        return new Authentication();
    }
}

class Authentication {
    public Object getPrincipal() {
        return "dummy_jwt_token";
    }
}

class JwtHelper {
    public Jwt parseJwt(String token) {
        return new Jwt();
    }
}

class Jwt {
    public String getClaimAsString(String claim) {
        return "dummy_username";
    }
}