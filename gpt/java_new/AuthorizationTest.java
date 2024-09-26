import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Base64;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AuthorizationTest {

    private MockMvc mockMvc;

    public String encodeEmailAndPassword(String email, String password) {
        return Base64.getEncoder().encodeToString((email + ":" + password).getBytes());
    }

    @Test
    public void testAuthorization() throws Exception {
        // ... setup mockMvc ...

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/authorize")
                .header(HttpHeaders.AUTHORIZATION, "Basic " + encodeEmailAndPassword("test1@app.com", "1111"))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        
        // ... additional test code ...
    }
}