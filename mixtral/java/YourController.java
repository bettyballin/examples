import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YourController {

    @Autowired
    private BoardPermissionService boardPermissionService;

    @RequestMapping(value = "/boards/{id}")
    @PreAuthorize("@boardPermissionService.hasAccessToBoard(authentication.principal.username, #id)")
    public String viewBoard(@PathVariable(value = "id") String id) {
        // Your implementation here
        return "Board ID: " + id;
    }
}

// BoardPermissionService.java
public interface BoardPermissionService {
    boolean hasAccessToBoard(String username, String boardId);
}

// BoardPermissionServiceImpl.java
import org.springframework.stereotype.Service;

@Service
public class BoardPermissionServiceImpl implements BoardPermissionService {

    @Override
    public boolean hasAccessToBoard(String username, String boardId) {
        // Your permission logic here
        return true; // For example purposes
    }
}

// SecurityConfig.java
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    // Your security configuration here
}

// Application.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}