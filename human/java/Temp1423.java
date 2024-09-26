public class PermissionChecker {

    public static void main(String[] args) {
        // Example usage
        System.out.println(hasPermission("#targetDomainObject", "permission")); // method1
        System.out.println(hasPermission("targetId", "targetType", "permission")); // method2
    }

    public static boolean hasPermission(String targetDomainObject, String permission) {
        // Implement the logic for method1 here
        // This is just a placeholder implementation
        return "#targetDomainObject".equals(targetDomainObject) && "permission".equals(permission);
    }

    public static boolean hasPermission(String targetId, String targetType, String permission) {
        // Implement the logic for method2 here
        // This is just a placeholder implementation
        return "targetId".equals(targetId) && "targetType".equals(targetType) && "permission".equals(permission);
    }
}