import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Temp2606 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_Get_200() throws Exception {
        this.mockMvc
            .perform(get("/employee"))
            .andExpect(status().isOk());

        // Add more assertions if needed
    }
}