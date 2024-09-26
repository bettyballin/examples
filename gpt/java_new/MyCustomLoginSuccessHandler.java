import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyCustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    private MyUserService myUserService;

    public MyCustomLoginSuccessHandler(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                         Authentication authentication) throws IOException {
        String username = authentication.getName();
        MyUser user = myUserService.getMyUser(username);

        request.getSession(true).setAttribute("myUser", user);
        response.sendRedirect(request.getContextPath() + "/");
    }
}