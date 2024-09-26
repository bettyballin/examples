import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
public class MyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithAnonymousUser
    public void testAnonymousUserAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/some-endpoint"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }
}