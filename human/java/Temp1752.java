public class Temp1752 {
    public static void main(String[] args) {
        // Assuming you have an Authentication object
        Authentication authentication = getAuthentication();

        // Assuming UserDetailsImplementation is a class that implements UserDetails
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImplementation) {
            UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();
            userDetails.getDesiredData();
        } else {
            System.out.println("Authentication or Principal not properly set.");
        }
    }

    // Mock method to get an Authentication object
    public static Authentication getAuthentication() {
        // Replace with actual authentication retrieval logic
        return new Authentication(new UserDetailsImplementation());
    }
}

class UserDetailsImplementation {
    public void getDesiredData() {
        System.out.println("Desired data retrieved.");
    }
}

class Authentication {
    private Object principal;

    public Authentication(Object principal) {
        this.principal = principal;
    }

    public Object getPrincipal() {
        return principal;
    }
}