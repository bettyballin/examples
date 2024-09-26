import org.springframework.security.core.GrantedAuthority;

public final class AwsCognitoRole implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    private String role;

    public AwsCognitoRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + this.role;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static void main(String[] args) {
        AwsCognitoRole cognitoRole = new AwsCognitoRole("USER");
        System.out.println(cognitoRole.getAuthority());
    }
}