public class Temp358 {
    public static void main(String[] args) {
        String userRole = "supervisor"; // This should be dynamically checked against the user's roles

        if ("supervisor".equals(userRole)) {
            System.out.println("This content will only be visible to users who have the \"supervisor\" authority in their list of GrantedAuthoritys.");
        } else {
            System.out.println("You do not have the required permissions to view this content.");
        }
    }
}