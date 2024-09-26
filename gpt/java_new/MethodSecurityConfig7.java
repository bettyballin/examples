import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfig7uration;
import org.springframework.security.access.prepost.PreAuthorize;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig7 extends GlobalMethodSecurityConfig7uration {
    // ...
}

class ItemService {

    @PreAuthorize("hasPermission(#storeId, 'Store', 'write')")
    public ItemDTO deleteItem(String sessionId, Long storeId, ItemDTO itemDto) {
        // Your existing logic
        return new ItemDTO(); // Placeholder for existing logic
    }
}

class ItemDTO {
    // Placeholder for the ItemDTO implementation
}