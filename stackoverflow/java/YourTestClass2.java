import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class YourTestClass2 {

    private MockMvc mockMvc;

    @Before
    public void setup(WebApplicationContext context) {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/your-endpoint")
            .principal(new UsernamePasswordAuthenticationToken(new CustomUser(), null))
            // ... add more configurations if needed
        );
        // ... add your test assertions here
    }

    private class CustomUser {
        // Your CustomUser details
    }
}