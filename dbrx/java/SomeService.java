import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.access.AccessDeniedException;

@Service
public class SomeService {

    private final boolean authorize;

    // Removed @Autowired as it's not needed for no-arg constructor
    public SomeService() {
        this.authorize = true;
    }

    // Internal constructor without auth check
    protected SomeService(boolean authorize) {
        this.authorize = authorize;
    }

    public void findOne(Long id, Long userId) {
        if (authorize && !isAuthorized(userId)) {
            throw new AccessDeniedException("Access denied");
        }
        // ...
    }

    private boolean isAuthorized(Long userId) {
        // Authorization logic here
        return true; // Dummy implementation for illustration
    }

    public static void main(String[] args) {
        SomeService service = new SomeService();
        try {
            service.findOne(1L, 2L);
            System.out.println("Access granted");
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}