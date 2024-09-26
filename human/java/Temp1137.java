public class Temp1137 {
    public static void main(String[] args) {
        LDAPAuthorizationToken token = new LDAPAuthorizationToken("example_token");
        System.out.println("Credentials: " + token.getCredentials());
        System.out.println("Principal: " + token.getPrincipal());
    }
}

class LDAPAuthorizationToken {
    private String token;

    public LDAPAuthorizationToken(String token) {
        this.token = token;
    }

    public Object getCredentials() {
        return token;
    }

    public Object getPrincipal() {
        return null;
    }
}