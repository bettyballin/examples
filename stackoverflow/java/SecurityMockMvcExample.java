import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityMockMvcExample {
    private MockMvc mvc;
    private UserDetails principal;
    private Authentication auth;

    public void exampleMethod() throws Exception {
        // use this if CustomUser (principal) implements UserDetails
        mvc.perform(get("/").with(user(principal)));

        // otherwise use this
        mvc.perform(get("/").with(authentication(auth)));
    }
}