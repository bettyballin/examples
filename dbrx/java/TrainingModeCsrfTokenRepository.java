import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.mock.web.MockHttpServletRequest; // Add this import

public class TrainingModeCsrfTokenRepository implements CsrfTokenRepository {
    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", UUID.randomUUID().toString());
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {}

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        return generateToken(request);
    }

    public static void main(String[] args) {
        // Example usage of the TrainingModeCsrfTokenRepository
        TrainingModeCsrfTokenRepository repository = new TrainingModeCsrfTokenRepository();
        HttpServletRequest request = new MockHttpServletRequest(); // Create a mock HttpServletRequest instance
        CsrfToken token = repository.generateToken(request);
        System.out.println("Generated CSRF Token: " + token.getToken());
    }
}