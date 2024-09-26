import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class CronServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("true".equalsIgnoreCase(req.getHeader("X-Appengine-Cron"))) {
            // Perform the cron task
        } else {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}