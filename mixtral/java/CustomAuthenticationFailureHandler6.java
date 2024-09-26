import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private static final int MAX_ATTEMPTS = 3;

    @Autowired
    private MembersDao membersDao;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String email = request.getParameter("email");

        if (membersDao.findByEmail(email) != null) {
            Members members = membersDao.findByEmail(email);

            int attempts = members.getAttempts();

            // Increment the number of failed login attempts
            members.setAttempts(++attempts);

            if (members.isAccountNonLocked()) {
                if (attempts >= MAX_ATTEMPTS) {
                    members.setEnabled(false);

                    // Send a response to the client
                    APIResponseBuilder.build(true, "Your Username is Blocked");
                } else {
                    // Send a response to the client
                    APIResponseBuilder.build(true, "Invalid username and password. Attempts: " + attempts);
                }
            }

            membersDao.save(members);
        }
    }
}