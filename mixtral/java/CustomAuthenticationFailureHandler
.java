import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private AuditService auditService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        // Save failed login action to the database
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof User) {
            User user = (User) principal;
            Audit audit = new Audit("LOGIN", "Failed Login for: " + user.getName());
            this.auditService.save(audit);
        }
    }
}

class Audit {
    private String action;
    private String description;

    public Audit(String action, String description) {
        this.action = action;
        this.description = description;
    }

    // getters and setters
}

class User {
    private String name;

    public String getName() {
        return name;
    }

    // other properties, getters, and setters
}

interface AuditService {
    void save(Audit audit);
}