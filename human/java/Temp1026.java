public class Temp1026 {
    private AuthenticationConfiguration authenticationConfiguration;

    public static void main(String[] args) {
        Temp1026 temp = new Temp1026();
        temp.authenticationConfiguration = new AuthenticationConfiguration();
        temp.authenticationConfiguration.getAuthenticationManager();
    }
}

class AuthenticationConfiguration {
    public void getAuthenticationManager() {
        System.out.println("Getting Authentication Manager");
    }
}