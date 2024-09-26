import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;

public class MyRememberMeProcessingFilter extends RememberMeAuthenticationFilter { 
    private MyService myService; // Assuming MyService is a defined class

    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    @Override 
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) { 
        // perform some custom logic when the user has been 'remembered' & authenticated - e.g. update a login count etc 
        this.myService.doSomeCustomBusinessLogic(authResult.getName()); 

        super.onSuccessfulAuthentication(request, response, authResult); 
    } 
}