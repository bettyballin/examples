import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler8 implements AuthenticationSuccessHandler {

    private InterviewService interviewService;
    private JobSeekerService jobSeekerService;

    public CustomAuthenticationSuccessHandler8(InterviewService interviewService, JobSeekerService jobSeekerService) {
        this.interviewService = interviewService;
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException, ServletException {

        HttpSession session = httpServletRequest.getSession();

        session.setAttribute("countTodayInterviews", interviewService.countTodayInterviews());
        session.setAttribute("countNewCandidates", jobSeekerService.countNewCandidates());

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/dashboard");
    }
}