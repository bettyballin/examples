import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private JobSeekerService jobSeekerService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException, ServletException {
        {
            // Add your custom logic here
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("countTodayInterviews", interviewService.countTodayInterviews());
            session.setAttribute("countNewCandidates", jobSeekerService.countNewCandidates());

            // Redirect to default target URL
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/home");
        }
    }
}