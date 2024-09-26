import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.UserStore;
import org.eclipse.jetty.util.security.Password;

public class LoginServiceSetup {

    public static void main(String[] args) {
        HashLoginService loginService = new HashLoginService("MyRealm");

        UserStore userStore = new UserStore();
        String userName = "username"; // Replace with the actual user name
        userStore.addUser(userName, new Password("password"), new String[]{"users"});

        loginService.setUserStore(userStore);
        
        // Now the loginService can be associated with a server, for instance:
        // server.addBean(loginService);
    }
}