import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.util.security.Password;
import org.eclipse.jetty.security.UserStore;

public class Temp2194 {
    public static void main(String[] args) {
        HashLoginService loginService = new HashLoginService("MyRealm");

        UserStore userStore = new UserStore();
        String userName = "user"; // define userName variable
        userStore.addUser(userName, new Password("password"), new String[] { "users" });

        loginService.setUserStore(userStore);
        
        System.out.println("User " + userName + " added successfully.");
    }
}