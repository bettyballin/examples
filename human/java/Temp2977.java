public class Temp2977 {
    public static void main(String[] args) {
        AuthResult authResult = new AuthResult(); // Placeholder for the actual AuthResult object
        String role = null;
        
        if (authResult != null && authResult.getAuthorities() != null) {
            role = authResult.getAuthorities().toString();
        }
        
        if (role != null && role.contains("ROLE_ADMIN")) {
            System.out.println("User has admin role");
        } else {
            System.out.println("User does not have admin role");
        }
    }
}

// Placeholder class for AuthResult, replace with actual implementation
class AuthResult {
    public java.util.List<String> getAuthorities() {
        // Placeholder for actual authorities
        return java.util.Arrays.asList("ROLE_USER", "ROLE_ADMIN");
    }
}