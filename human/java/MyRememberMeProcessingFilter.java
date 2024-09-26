import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.rememberme.RememberMeProcessingFilter;

public class MyRememberMeProcessingFilter extends RememberMeProcessingFilter { 
    private MyService myService; 
    
    public MyRememberMeProcessingFilter(MyService myService) {
        this.myService = myService;
    }

    @Override 
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) { 
        // perform some custom logic when the user has been 'remembered' & authenticated - e.g. update a login count etc 
        this.myService.doSomeCustomBusinessLogic(authResult.getName()); 

        super.onSuccessfulAuthentication(request, response, authResult); 
    } 
} 

class MyService {
    public void doSomeCustomBusinessLogic(String username) {
        // Custom business logic goes here
        System.out.println("Custom business logic executed for user: " + username);
    }
}