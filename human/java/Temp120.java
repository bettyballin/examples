import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp120 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("myFile.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
        // Main method is not typically used in servlet classes
        // You would deploy this servlet in a servlet container like Tomcat
    }
}