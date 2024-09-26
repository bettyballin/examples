import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route("login")
@PageTitle("Login")
public class LoginView extends Div {

    public LoginView() {
        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(e -> {
            boolean isAuthenticated = authenticate(e.getUsername(), e.getPassword());
            if (isAuthenticated) {
                loginForm.getUI().ifPresent(ui -> ui.navigate("main"));
            } else {
                loginForm.setError(true);
            }
        });
        add(loginForm);
    }

    private boolean authenticate(String username, String password) {
        // Implement authentication logic
        return "user".equals(username) && "password".equals(password);
    }
}