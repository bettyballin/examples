import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@Controller
public class MainLoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DinosaurServer dinosaurServer;

    @RequestMapping("/manuallogin")
    public ResponseEntity<Object> interceptLoginRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        DefaultSavedRequest springSecuritySavedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        String queryString = springSecuritySavedRequest.getQueryString();
        request.getSession().setAttribute("queryString", queryString);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(dinosaurServer.getLoginUrl()))
                .build();
    }

    @RequestMapping("/handshakeWithDinosaur")
    public ResponseEntity<Object> handshakeWithDinosaur(@RequestParam("dinosaursToken") String dinosaursToken, HttpServletRequest request) {

        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dinosaurServer.getUser(), dinosaurServer.getPass()
                )
        );
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authentication);
        request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", sc);

        String queryString = String.valueOf(request.getSession().getAttribute("queryString"));

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(String.format("%s?%s", "SPRING_AUTH_ENDPOINT", queryString)))
                .build();
    }
}

// Dummy DinosaurServer class for completeness
class DinosaurServer {
    public String getLoginUrl() {
        return "http://example.com/dinosaurLogin";
    }

    public String getUser() {
        return "user";
    }

    public String getPass() {
        return "pass";
    }
}