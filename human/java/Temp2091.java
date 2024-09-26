public class Temp2091 {
    public static void main(String[] args) {
        String interceptUrlPattern = "/admin";
        String accessRoles = "hasAnyRole('ROLE_USER')";
        
        System.out.println("Intercept URL pattern: " + interceptUrlPattern);
        System.out.println("Access roles: " + accessRoles);
    }
}