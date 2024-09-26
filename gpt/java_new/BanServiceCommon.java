import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@Component
public class BanServiceCommon {
    // Assume Ban and User classes are defined elsewhere
    public Ban getBanForUserUnsafe(User user) {
        // ... actual code to return the Ban for the User
        return null; // Placeholder for compilation
    }
}

@Service
public class BanService {
    private final BanServiceCommon banServiceCommon;

    @Autowired
    public BanService(BanServiceCommon banServiceCommon) {
        this.banServiceCommon = banServiceCommon;
    }

    @PreAuthorize("isAuthenticated()")
    public Ban getBanForUser(User user) {
        return banServiceCommon.getBanForUserUnsafe(user);
    }
}