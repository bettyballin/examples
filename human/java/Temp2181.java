public class Temp2181 {
    public static void main(String[] args) {
        Request request = new Request();
        
        if (AuthUtils.isAuthenticated(request, "ROLE1", "ROLE2")) {
            System.out.println("User is authenticated with ROLE1 or ROLE2");
        } else {
            System.out.println("User is not authenticated with ROLE1 or ROLE2");
        }
    }
}

class Request {
    // Simulating a request class
}

class AuthUtils {
    public static boolean isAuthenticated(Request request, String... roles) {
        // Dummy authentication logic for demonstration purposes
        // In a real scenario, this method would check the request's authentication against the roles
        for (String role : roles) {
            if ("ROLE1".equals(role) || "ROLE2".equals(role)) {
                return true;
            }
        }
        return false;
    }
}