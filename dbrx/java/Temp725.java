import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Temp725 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPageTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/processFile.html")))
                .andExpect(status().isOk());
    }

    public static void main(String[] args) {
        System.out.println("Run the tests using JUnit or another testing framework.");
    }
}