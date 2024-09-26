import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
public class MainLoginController {

    @Autowired
    private DinosaurAuthenticationProvider authProvider;

    @RequestMapping("/manuallogin")
    public ResponseEntity<?> interceptLoginRequest(HttpServletRequest request) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Authentication authReq = new UsernamePasswordAuthenticationToken(username, password);

        // Perform authentication using your custom provider
        Authentication result = this.authProvider.authenticate(authReq);

        SecurityContextHolder.getContext().setAuthentication(result);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("/handshakeWithDinosaur"))
                .build();
    }

}