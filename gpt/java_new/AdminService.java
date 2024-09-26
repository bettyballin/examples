import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;

@Service
public class AdminService {

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public boolean methodController(){
        // Your logic here
        return true;
    }
}