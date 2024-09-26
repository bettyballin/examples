import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

public class MyTestClass {

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testWithAuthenticatedUser() {
        // perform test with a mocked user
    }
}