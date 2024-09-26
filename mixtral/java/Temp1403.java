import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Assuming MyEntity and MyUserDetails are defined elsewhere

@ComponentScan
public class MainApplication {
    public static void main(String[] args) {
        // Your application entry point
    }
}

interface MyRepository {
    List<MyEntity> findAllByClientId(String clientId);
}

interface MyEntity {
    // Define your entity properties and methods here
}

interface MyUserDetails {
    String getClientId();
}

interface CustomJpaRepository extends JpaRepository<MyEntity, Long>, MyRepository {
}

@Component
class CustomUserDetailsRepo implements MyRepository {

    @Autowired
    private CustomJpaRepository repository;

    public List<MyEntity> findAllByClientId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
            return repository.findAllByClientId(userDetails.getClientId());
        }

        throw new IllegalStateException("No authenticated principal found");
    }

    @Override
    public List<MyEntity> findAllByClientId(String clientId) {
        return repository.findAllByClientId(clientId);
    }
}