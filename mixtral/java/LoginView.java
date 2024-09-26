import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

@Route("login")
public class LoginView extends VerticalLayout {
    public LoginView() {
        // Configure the login form
        final LoginForm login = new LoginForm();

        // Set action for successful authentication
        login.setForgotPasswordButtonVisible(false);

        addClassName("login-view");

        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);

        setAlignItems(Alignment.CENTER);

        getElement().getThemeList().add("mytheme");

        // Add the login form to this view
        add(login);
    }
}