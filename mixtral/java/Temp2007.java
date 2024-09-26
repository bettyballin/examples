import java.util.ArrayList;
import java.util.List;

class AuthResult {
    private List<String> authorities;

    public AuthResult(List<String> authorities) {
        this.authorities = authorities;
    }

    public List<String> getAuthorities() {
        return authorities;
    }
}

public class Temp2007 {
    public static void main(String[] args) {
        List<String> authList = new ArrayList<>();
        authList.add("ROLE_USER");
        authList.add("ROLE_ADMIN");

        AuthResult authResult = new AuthResult(authList);

        String role = authResult.getAuthorities().toString();
        System.out.println(role);
    }
}