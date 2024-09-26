import org.springframework.security.oauth2.jwt.Jwt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtDecoder;

public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtDecoder jwtDecoder;

    public void testMessageEndpoint() throws Exception {
        Jwt jwt = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("scope", "message:read")
                .build();
        when(jwtDecoder.decode(anyString())).thenReturn(jwt);
        
        mockMvc.perform(post("/message")
                .content("Hello message")
                .header("Authorization", "Bearer " + jwt.getTokenValue()))
                .andExpect(status().isOk())
                .andExpect(content().string(is("Message was created. Content: Hello message")));
    }
}