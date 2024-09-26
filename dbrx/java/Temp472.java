import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Temp472 {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Test
    @WithUserDetails("testuser")
    public void seleniumTest() {
        // Define the password as a variable
        String password = "password"; // replace with the actual password

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                "testuser", password, AuthorityUtils.createAuthorityList("ROLE_USER"));
        SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(token));
    }
}