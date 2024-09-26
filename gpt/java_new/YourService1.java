import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class YourService1 {

    @Autowired
    private YourRepository yourRepository;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    public Long countUserEntities() {
        Authentication authentication = authenticationFacade.getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return yourRepository.countByUserId(userDetails.getUsername()); // Assuming the repository method uses username as a reference
        }
        return 0L; // Corrected to return Long type
    }
}

// Assuming the following is defined elsewhere
interface YourRepository {
    Long countByUserId(String userId); // Assuming the userID is of type String
}

interface AuthenticationFacade {
    Authentication getAuthentication();
}