import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class Temp556 implements AuthenticationSuccessHandler {

    private InterviewService interviewService; // Assuming these services are injected or initialized
    private JobSeekerService jobSeekerService;

    public Temp556(InterviewService interviewService, JobSeekerService jobSeekerService) {
        this.interviewService = interviewService;
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication auth) 
            throws IOException, ServletException {

        HttpSession session = httpServletRequest.getSession();

        session.setAttribute("countTodayInterviews", interviewService.countTodayInterviews());
        session.setAttribute("countNewCandidates", jobSeekerService.countNewCandidates());

        // Add this line to redirect the user after setting session attributes
        httpServletResponse.sendRedirect("/dashboard");
    }

    public static void main(String[] args) {
        // Main method is not typically used for web applications, but if needed for testing...
        System.out.println("This is a placeholder for the web application.");
    }
}

// Assuming the existence of these service interfaces
interface InterviewService {
    int countTodayInterviews();
}

interface JobSeekerService {
    int countNewCandidates();
}