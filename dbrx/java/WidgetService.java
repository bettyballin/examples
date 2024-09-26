import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

    @Autowired
    private WidgetRepository widgetRepository;

    @PreAuthorize("hasPermission(#widgetId, 'com.example.Widget', 'read')")
    public Widget findWidgetById(Long widgetId) {
        return widgetRepository.findById(widgetId).orElseThrow(() -> new WidgetNotFoundException(widgetId));
    }
}

// Assuming WidgetRepository and Widget are defined as follows:
import org.springframework.data.jpa.repository.JpaRepository;

public interface WidgetRepository extends JpaRepository<Widget, Long> {
}

// Assuming Widget is a simple entity class
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Widget {
    @Id
    private Long id;
    private String name;

    // getters and setters
}

// Custom exception for Widget not found
public class WidgetNotFoundException extends RuntimeException {
    public WidgetNotFoundException(Long widgetId) {
        super("Widget not found with id: " + widgetId);
    }
}

// Application class
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WidgetApplication {

    public static void main(String[] args) {
        SpringApplication.run(WidgetApplication.class, args);
    }
}

// Security configuration (if needed)
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    // your security configuration here
}