import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;

import javax.servlet.annotation.WebServlet;

@Route("")
@PWA(name = "My App", shortName = "App")
public class MyView extends VerticalLayout {

    public MyView() {
        Span text = new Span("Hello, this is a Vaadin application!");
        add(text);
    }

    @WebServlet(urlPatterns = "/*", name = "MyViewServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyViewServlet extends VaadinServlet {
    }

    public static class MyUI extends UI {
        @Override
        protected void init(VaadinRequest vaadinRequest) {
            MyView myView = new MyView();
            setContent(myView);
        }
    }

    public static void main(String[] args) {
        // Not needed for Vaadin applications
    }
}