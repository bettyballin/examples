public class Temp1227 {

    public static void main(String[] args) {
        Auth auth = new Auth();
        auth.authenticationEventPublisher(defaultAuthenticationEventPublisher());
    }

    public static AuthenticationEventPublisher defaultAuthenticationEventPublisher() {
        return new AuthenticationEventPublisher();
    }
}

class Auth {
    public void authenticationEventPublisher(AuthenticationEventPublisher publisher) {
        System.out.println("AuthenticationEventPublisher assigned: " + publisher);
    }
}

class AuthenticationEventPublisher {
    @Override
    public String toString() {
        return "Default Authentication Event Publisher";
    }
}