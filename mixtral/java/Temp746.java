import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class Temp746 {
    private String username;
    private String password;

    public static void main(String[] args) {
        // This main method is just a placeholder. In a real application, the JSF framework will handle the lifecycle.
    }

    public String doLogin() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

            // Perform the login
            request.login(username, password);

            return "/secure/home?faces-redirect=true";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Login failed.");
            context.addMessage(null, msg);

            // Clear the username and password fields
            setUsername("");
            setPassword("");

            return null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}