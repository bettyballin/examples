import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if ("application/json".equals(request.getHeader("Content-Type"))) {
            try {
                UserInfo authRequest = objectMapper.readValue(request.getInputStream(), UserInfo.class);
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(), authRequest.getPassword());
                setDetails(request, token);
                return this.getAuthenticationManager().authenticate(token);
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to parse authentication request body", e);
            }
        } else {
            return super.attemptAuthentication(request, response);
        }
    }

    private static class UserInfo {
        private String username;
        private String password;

        // getters and setters omitted for brevity
    }
}