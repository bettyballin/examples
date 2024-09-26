import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class YourClass1 {
    public void yourMethod(HttpServletRequest request, HttpSession session) {
        if (request.getUserPrincipal() != null) {
            String userName = request.getUserPrincipal().getName().trim();
            session.setAttribute("userName", userName);
            // .....
            if (request.isUserInRole("ADMINS")) {
                //do actions here
            }
        }
    }
}