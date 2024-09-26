import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

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