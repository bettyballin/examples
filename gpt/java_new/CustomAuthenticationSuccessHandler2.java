import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler2 implements AuthenticationSuccessHandler {

    private UserLoginService userLoginService;

    public CustomAuthenticationSuccessHandler2(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String username = authentication.getName();
        userLoginService.updateLastLogin(username);
        response.sendRedirect("/homepage");
    }
}