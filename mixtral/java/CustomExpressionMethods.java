public class CustomExpressionMethods {
    public static boolean hasScopeOrUserRole(String scope, String role) {
        // Simulate the logic to check scope and role
        boolean hasScope = checkScope(scope);
        boolean hasRole = checkRole(role);
        boolean isOAuth = isOAuth();

        return hasScope || (!isOAuth && hasRole);
    }

    private static boolean checkScope(String scope) {
        // Placeholder for actual scope checking logic
        // For demonstration, assume all scopes are valid
        return true;
    }

    private static boolean checkRole(String role) {
        // Placeholder for actual role checking logic
        // For demonstration, assume all roles are valid
        return true;
    }

    private static boolean isOAuth() {
        // Placeholder for actual OAuth checking logic
        // For demonstration, assume it's always OAuth
        return true;
    }

    public static void main(String[] args) {
        String scope = "read";
        String role = "USER";

        boolean result = hasScopeOrUserRole(scope, role);
        System.out.println("Result: " + result);
    }
}