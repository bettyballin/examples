import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletService;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.lumo.Lumo;

import javax.servlet.annotation.WebServlet;

@Route("access-denied")
public class AccessDeniedView extends VerticalLayout {

    public AccessDeniedView() {
        add(new Text("Access denied"));
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    public static class MyUI extends com.vaadin.flow.component.UI {
    }

    @PWA(name = "My Application", shortName = "My App")
    public static class AppShell implements AppShellConfigurator {
    }

    public static void main(String[] args) {
        // empty, not needed
    }
}