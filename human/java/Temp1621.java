import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootApplication
public class Temp1621Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp1621Application.class, args);
    }

}

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class Temp1621Tests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("usernameThatIsFoundByUserDetailsService")
    public void run() throws Exception {
        MvcResult result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();
    }
}