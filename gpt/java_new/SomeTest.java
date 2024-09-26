import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SomeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSomeEndpoint() throws Exception {
        mockMvc.perform(get("/some-endpoint"))
               .andExpect(status().isOk());
    }
}