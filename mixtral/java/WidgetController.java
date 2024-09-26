import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WidgetController {

    @GetMapping("/api/v1/widgets/{id}")
    @PreAuthorize("@widgetService.hasPermissionOnWidgetId(#id, #authentication)")
    public ResponseEntity<String> get(@PathVariable Long id, @AuthenticationPrincipal Authentication authentication) {
        return ResponseEntity.ok(authentication.getName() + " has access to widget: " + id);
    }
}

@Service
class WidgetService {

    public boolean hasPermissionOnWidgetId(Long id, Authentication authentication) {
        // Implement your custom permission logic here
        return true; // For simplicity, returning true for all cases
    }
}