import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ConfigEditorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String[] NON_ADMIN_ROLES = {"user", "manager", "guest"};

    @Test
    @WithMockUser(roles = {"USER", "MANAGER", "GUEST"})
    public void nonAdminsCannotAccessRuntimeConfig() throws Exception {
        for (String role : NON_ADMIN_ROLES) {
            mockMvc.perform(get("/my/custom/api"))
                    .andExpect(status().isForbidden());
        }
    }
}