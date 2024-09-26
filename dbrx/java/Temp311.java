import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.Tomcat;

@WebServlet("/Temp311")
public class Temp311 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Clear authentication-related data
            session.removeAttribute("ID");
            session.removeAttribute("User");
            session.removeAttribute("isAuthenticated");

            // Invalidate the session
            session.invalidate();

            response.sendRedirect(request.getContextPath() + "/login.jsp");  // Redirect to login page after logout
        } else {
            // In case there is no session, redirect to login page directly
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.addWebapp("", ".");
        tomcat.start();
        tomcat.getServer().await();
    }
}