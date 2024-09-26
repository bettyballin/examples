import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import java.io.Serializable;

public class WidgetPermissionEvaluator implements PermissionEvaluator {
    
    private boolean userCanAccessWidget(Authentication authentication, Widget widget) {
        // Implement your access logic here
        return true; // Just an example, replace with actual logic
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (targetDomainObject instanceof Widget) {
            return userCanAccessWidget(authentication, (Widget) targetDomainObject);
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Assuming targetType is the class name of Widget
        if ("Widget".equals(targetType)) {
            // Fetch the widget by targetId and then check permission
            Widget widget = findWidgetById((Long) targetId);
            return userCanAccessWidget(authentication, widget);
        }
        return false;
    }
    
    private Widget findWidgetById(Long id) {
        // Implement the logic to find the widget by ID
        return new Widget(); // Just an example, replace with actual logic
    }
}

// Assuming there's a Widget class that you are using
class Widget {
    // Widget properties and methods here
}