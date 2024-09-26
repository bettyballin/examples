import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class YourTestClass1 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "OWNER")
    public void testControllerMethod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/your-endpoint"))
                .andExpect(status().isOk());
        // ... perform assertions
    }
}