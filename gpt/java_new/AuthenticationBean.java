import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.faces.context.FacesContext;
import org.omnifaces.util.Messages;

public class AuthenticationBean {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationBean.class);

    public void login(String userName, String password) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (request.getRemoteUser() == null) {
            try {
                request.login(userName, password);
            } catch (Exception e) {
                log.info("login() failed with exception", e);
                Messages.addWarn(null, "Authentication Failed");
            }
        } else {
            log.debug("login() user is already authenticated");
        }
    }
}