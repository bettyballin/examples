import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

@Component
public class CustomAuthenticationFailureHandler6 implements AuthenticationFailureHandler {

    @Autowired
    private MembersDao membersDao;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String email = request.getParameter("username");
        Members member = membersDao.findByEmail(email);

        if (member != null) {
            int attempts = member.getAttempts();
            member.setAttempts(attempts + 1);
            membersDao.save(member);
        }

        response.sendRedirect("/login?error");
    }
}