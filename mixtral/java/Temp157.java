import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp157 {
    public static void main(String[] args) {
        // The main method is left empty because the functionality is in another method
    }

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Object authentication) // Changed to Object for this example
            throws IOException, ServletException {

        // Set the attribute as a request attribute
        String ticket = "dummyVAL";
        request.setAttribute("TICKET", ticket);
    }
}