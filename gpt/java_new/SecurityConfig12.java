import org.springframework.context.annotation.Bean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityConfig12 {

    @Bean
    public AuthenticationEntryPoint loginUrlAuthenticationEntryPoint() {
        return new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException authException) throws IOException {
                response.sendRedirect("http://host/ear1contextPath/login");
            }
        };
    }

    // Assuming the rest of the configure method should be implemented here
    protected void configure() {
        // configuration code goes here
    }
}