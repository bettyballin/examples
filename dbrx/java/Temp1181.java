import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Temp1181 {

    private MockMvc mockMvc;

    // This is a placeholder. Replace with actual setup for MockMvc and WebApplicationContext
    private void setup(WebApplicationContext context) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public static void main(String[] args) throws Exception {
        Temp1181 temp = new Temp1181();

        // Setup your WebApplicationContext here
        // WebApplicationContext context = ...;
        // temp.setup(context);

        // Mock the response for demonstration purposes
        String idToken = "{\"id_token\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJub25jZSI6InJhbmRvbV9zdHJpbmcifQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c\"}";

        // Use the following lines in actual test instead of the mock above
        // String idToken = temp.mockMvc.perform(MockMvcRequestBuilders.post("/authorize"))
        //     .andExpect(MockMvcResultMatchers.jsonPath("$.id_token", notNullValue()))
        //     .andReturn()
        //     .getResponse()
        //     .getContentAsString();

        idToken = idToken.replace("{\"id_token\":\"", "").replace("\"}", "");
        JWT jwt = JWTParser.parse(idToken);
        JWTClaimsSet claims = jwt.getJWTClaimsSet();
        String nonce = claims.getStringClaim("nonce");
        assertThat(nonce, equalTo("random_string"));
    }
}