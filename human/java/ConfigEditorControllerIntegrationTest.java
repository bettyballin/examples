import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest
public class ConfigEditorControllerIntegrationTest {

    @Autowired
    private MockMvc mockedMvc;

    @ParameterizedTest
    @MethodSource
    public void nonAdminsCannotAccessRuntimeConfig(String role) throws Exception {
        mockedMvc.perform(MockMvcRequestBuilders.get("/my/custom/api")
                .with(org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user("someUser").roles(role)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    static List<String> nonAdminsCannotAccessRuntimeConfig() {
        return Roles.exclude("admin");
    }
}

class Roles {
    public static List<String> exclude(String role) {
        // Replace with your logic to exclude "admin" and return the list of roles
        return List.of("user", "manager", "viewer");
    }
}