import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Temp2002 extends HttpServlet {
    public static void main(String[] args) {
        // This method is not required for a servlet and can be left empty or removed
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            req.login(username, password);
            PrintWriter out = resp.getWriter();
            out.println("<h2>Welcome</h2>");
        } catch (ServletException e) {
            PrintWriter out = resp.getWriter();
            out.println(e.getMessage());
        }
    }
}