import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthHelper authHelper;

    private static final String TEST_USER = "user";
    private static final String TEST_ROLE = "role";

    @Test
    public void shouldGetCats() throws Exception {
        String accessToken = authHelper.addBearerToken(TEST_USER, TEST_ROLE);
        mockMvc.perform(get("/cats").with(SecurityMockMvcRequestPostProcessors.jwt().jwt(accessToken)))
               .andExpect(status().isOk());
    }
}