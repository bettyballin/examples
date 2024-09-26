import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootApplication
public class Temp2846 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2846.class, args);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return mock(JwtDecoder.class);
    }

    @Bean
    public MockMvc mockMvc(WebApplicationContext context, JwtDecoder jwtDecoder) {
        Jwt jwt = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("scope", "message:read")
                .build();
        when(jwtDecoder.decode(anyString())).thenReturn(jwt);

        return MockMvcBuilders.webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @PostConstruct
    public void performTest(MockMvc mockMvc) throws Exception {
        Jwt jwt = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("scope", "message:read")
                .build();

        mockMvc.perform(post("/message")
                .content("Hello message")
                .header("Authorization", "Bearer " + jwt.getTokenValue()))
                .andExpect(status().isOk())
                .andExpect(content().string(is("Message was created. Content: Hello message")));
    }

    @RestController
    @RequestMapping("/message")
    public static class MessageController {
        @PostMapping
        public String createMessage(@RequestBody String content) {
            return "Message was created. Content: " + content;
        }
    }
}