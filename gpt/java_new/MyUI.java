import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.Route;

// Dummy implementation of SecurityUtils and Views
class SecurityUtils {
    static boolean isUserLoggedIn() {
        // Implementation of the user logged-in check
        return false;
    }
}

@Route("login")
class LoginView {
    // Login view implementation
}

@Route("formclient")
class FormClientView {
    // Form client view implementation
}

public class MyUI {
    private void authenticateNavigation(BeforeEnterEvent event) {
        if (!LoginView.class.equals(event.getNavigationTarget())
                && !FormClientView.class.equals(event.getNavigationTarget())
                && !SecurityUtils.isUserLoggedIn()) {
            event.rerouteTo(LoginView.class);
        }
    }
}