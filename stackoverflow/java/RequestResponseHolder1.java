import javax.servlet.http.HttpServletRequest;

// Assuming RequestResponseHolder1 is a custom class that holds the request.
// The class would look something like this:

public class RequestResponseHolder1 {
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();

    public static void setServletRequest(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static HttpServletRequest getServletRequest() {
        return requestHolder.get();
    }

    public static void clear() {
        requestHolder.remove();
    }
}