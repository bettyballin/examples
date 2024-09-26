import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Temp580 {
    public static void main(String[] args) {

        String username = "testuser";
        List<String> roles = Arrays.asList("ROLE_OWNER");
        UsernamePasswordAuthenticationToken auth =
            new UsernamePasswordAuthenticationToken(username, "",
                roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList()));

        SecurityContextHolder.getContext().setAuthentication(auth);

        MockHttpServletRequest request = MockMvcRequestBuilders.get("/your-url")
            .buildRequest(new MockServletContext());

        request.setUserPrincipal(auth);

        // Output or further processing of the request can be done here
        System.out.println("Principal: " + request.getUserPrincipal());
        System.out.println("Request URL: " + request.getRequestURL());
    }
}