import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class CustomWrapper extends HttpServletRequestWrapper {
    public CustomWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public boolean isSecure() {
        return true;
    }

    @Override
    public String getScheme() {
        return "https";
    }
}

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomWrapper wrappedRequest = new CustomWrapper(request);
        response.getWriter().println("Is Secure: " + wrappedRequest.isSecure());
        response.getWriter().println("Scheme: " + wrappedRequest.getScheme());
    }
}