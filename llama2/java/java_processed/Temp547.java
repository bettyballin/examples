import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.authentication.TestingAuthenticationToken;

@SpringBootTest
@SpringJUnitConfig
public class Temp547 {
    @Test
    public void testControllerMethod() {
        UserDetails userDetails = User.builder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        Authentication auth = new TestingAuthenticationToken(userDetails, null);
        SecurityContextHolder.setContext(new SecurityContextImpl(auth));

        // Call your controller method and assert expected behavior
    }

    public static void main(String[] args) {
        org.junit.platform.launcher.LauncherFactory.create().execute(
                new String[] {"Temp547"});
    }
}