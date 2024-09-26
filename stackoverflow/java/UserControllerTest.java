import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserControllerTest {

    private MockMvc mvc;

    public void testCreateUser() throws Exception {
        JsonNode jsonNode = new ObjectMapper().createObjectNode(); // Dummy JsonNode for the example
        // Assuming jsonNode is initialized and is a valid JsonNode object

        mvc.perform(post("/admin/createUser").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonNode.toString()))
                .andExpect(status().isOk());
    }
}