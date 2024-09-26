public class Temp3264 {
    public static void main(String[] args) {
        System.out.println(hasAnyRole("MY_USER", "MY_ADMIN"));
    }

    public static boolean hasAnyRole(String... roles) {
        // Sample roles for demonstration purposes
        String[] userRoles = {"MY_USER", "MY_VIEWER"};

        for (String role : roles) {
            for (String userRole : userRoles) {
                if (role.equals(userRole)) {
                    return true;
                }
            }
        }
        return false;
    }
}