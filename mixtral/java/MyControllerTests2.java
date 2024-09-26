import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
public class MyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testExample() throws Exception {
        // Your test methods here
        mockMvc.perform(get("/example"))
                .andExpect(status().isOk());
    }
}