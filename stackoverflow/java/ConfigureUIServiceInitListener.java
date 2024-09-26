import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.springframework.stereotype.Component;

@Component
@CssImport("./styles/shared-styles.css")
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addUIInitListener(uiEvent -> {
            final UI ui = uiEvent.getUI();
            ui.addBeforeEnterListener(this::authenticateNavigation);
        });
    }

    private void authenticateNavigation(BeforeEnterEvent event) {
        if (!LoginView.class.equals(event.getNavigationTarget()) && !SecurityUtils.isUserLoggedIn()) {
            String targetName = event.getNavigationTarget().getName();
            if (targetName != null && (targetName.endsWith("FormClient") || targetName.endsWith("FormClientCertified"))) {
                System.out.println("Retorna porque es " + targetName);
                return;
            }
            System.out.println("redirecciona [" + targetName + "]");
            event.rerouteTo(LoginView.class);
        }
    }
}