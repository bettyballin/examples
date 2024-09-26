// Assuming this is part of a method in a servlet, the return type must be void and the method must throw IOException
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public void checkSession(HttpServletResponse response) throws IOException {
    if(UserSession.isSessionValid()){
        System.out.println("ready to enter");
        // return true; // This line should be removed as the method cannot return a boolean value.
    } else {
        System.out.println("not logged in...redirecting to login");
        response.sendRedirect("/in_development_page");
        // return false; // This line should be removed as the method cannot return a boolean value.
    }
}