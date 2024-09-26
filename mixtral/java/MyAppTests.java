import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MyAppTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAnonymous() throws Exception {
        mockMvc.perform(get("/api/user/account"))
               .andExpect(status().is3xxRedirection());
    }

    @WithUserDetails("test-user")
    @Test
    public void testUserAccessForAccount() throws Exception {
        mockMvc.perform(get("/api/user/account"))
               .andExpect(status().isOk());
    }
}