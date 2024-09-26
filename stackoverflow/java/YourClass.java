import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import your.package.Ban;
import your.package.BanService;
import your.package.User;

public class YourClass {

    private BanService banService;

    public YourClass(BanService banService) {
        this.banService = banService;
    }

    public void checkAndBanUser(User user) {
        try {
            SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken("privileged user here", null)
            );    
            Ban userBan = banService.getBanForUser(user);
            // Assuming you do something with the userBan object here
        } finally {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }
}