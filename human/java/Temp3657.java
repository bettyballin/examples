public class Temp3657 {
    public static void main(String[] args) {
        CustomTokenAuthenticationRequest customTokenAuthRequest = new CustomTokenAuthenticationRequest();
        customTokenAuthRequest.authenticate();
    }
}

interface Authentication {
    void authenticate();
}

class CustomTokenAuthenticationRequest implements Authentication {
    @Override
    public void authenticate() {
        System.out.println("Authentication successful!");
    }
}