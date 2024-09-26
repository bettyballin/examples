import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController7 {

    @GetMapping("/userinfo")
    public String getUserInfo(@AuthenticationPrincipal Jwt jwtToken) {
        String subject = jwtToken.getSubject();
        String customClaim = jwtToken.getClaimAsString("customClaim");

        return "User Info: Subject = " + subject + ", Custom Claim = " + customClaim;
    }
}