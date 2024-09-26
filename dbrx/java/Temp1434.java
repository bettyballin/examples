import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Temp1434 {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithUserDetails(value = "username")
    public void testAuthentication() throws Exception {
        mvc.perform(get("/pdps/authentication")
                .with(httpBasic("username", "password"))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    public static void main(String[] args) {
        System.out.println("Run the tests using a test runner");
    }
}