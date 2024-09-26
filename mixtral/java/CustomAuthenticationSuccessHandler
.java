import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private AuditService auditService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Save login action to the database
        User user = (User) authentication.getPrincipal();
        Audit audit = new Audit("LOGIN", "Successful Login for: " + user.getUsername());
        this.auditService.save(audit);
    }
}

// Assuming Audit is a simple POJO class with a constructor accepting two strings
class Audit {
    private String action;
    private String message;

    public Audit(String action, String message) {
        this.action = action;
        this.message = message;
    }

    // getters and setters
}

// Dummy AuditService class
interface AuditService {
    void save(Audit audit);
}

// Implementation of the AuditService
class AuditServiceImpl implements AuditService {
    @Override
    public void save(Audit audit) {
        // Save the audit to the database or perform some logging
        System.out.println("Audit saved: " + audit.action + " - " + audit.message);
    }
}