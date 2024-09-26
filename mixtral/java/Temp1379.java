import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp1379 {
    @Autowired
    private SavedRequestAwareAuthenticationSuccessHandler successHandler;

    public static void main(String[] args) {
        Temp1379 temp = new Temp1379();
        temp.execute();
    }

    public void execute() {
        HttpServletRequest request = null; // Mock request, should be provided in actual use
        HttpServletResponse response = null; // Mock response, should be provided in actual use
        Object auth = null; // Mock auth, should be provided in actual use

        try {
            successHandler.onLogoutSuccess(request, response, (org.springframework.security.core.Authentication) auth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}