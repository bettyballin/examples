import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;

public class ConfigEditorControllerIntegrationTest {

    private MockMvc mockedMvc;

    @ParameterizedTest
    @MethodSource("nonAdminsRoles")
    public void nonAdminsCannotAccessRuntimeConfig(String role) throws Exception {
        mockedMvc.perform(get("/my/custom/api")
                 .with(user("someUser").roles(role)))
                 .andExpect(status().isUnauthorized());
    }

    static List<String> nonAdminsRoles() {
        return Roles.exclude("admin");
    }
}