public class Temp1633 {
    public static void main(String[] args) {
        Temp1633 temp = new Temp1633();
        AuthenticationManager authManager = temp.authenticationManagerBean();
        // Add code here to use the authManager if needed
    }

    public AuthenticationManager authenticationManagerBean() {
        // Assuming AuthenticationManager is a custom class or interface
        return new AuthenticationManager() {
            @Override
            public void authenticate() {
                System.out.println("Authentication in progress...");
            }
        };
    }
}

interface AuthenticationManager {
    void authenticate();
}