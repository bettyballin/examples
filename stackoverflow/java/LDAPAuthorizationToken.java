public class LDAPAuthorizationToken extends AuthenticationToken {
    private String token;

    public LDAPAuthorizationToken(String token) {
        super(null);
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}