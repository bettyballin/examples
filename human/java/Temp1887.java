import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Temp1887 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthHelper authHelper;

    public void testCatsEndpoint() throws Exception {
        var accessToken = authHelper.addBearerToken("TEST_USER", "TEST_ROLE");
        mockMvc.perform(get("/cats").with(SecurityMockMvcRequestPostProcessors.jwt().jwt(accessToken)))
            .andExpect(status().isOk());
    }

    public static void main(String[] args) throws Exception {
        Temp1887 temp1887 = new Temp1887();
        temp1887.testCatsEndpoint();
    }
}