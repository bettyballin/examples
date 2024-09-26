import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Temp2408 {

    @Autowired
    private MockMvc mockedMvc;

    @Test
    @WithMockUser(username = "non-admin", password = "pass")
    public void nonAdminUsersCannotAccessRuntimeConfig() throws Exception {
        // Perform a GET request to the custom API and expect an unauthorized status
        this.mockedMvc.perform(get("/my/custom/api"))
                      .andExpect(status().isUnauthorized());
    }

    public static void main(String[] args) {
        System.out.println("Run tests with a JUnit runner.");
    }
}