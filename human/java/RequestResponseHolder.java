import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestResponseHolder {

    private static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();

    public static void setRequestResponse(HttpServletRequest request, HttpServletResponse response) {
        requestHolder.set(request);
        responseHolder.set(response);
    }

    public static HttpServletRequest getServletRequest(){
         return requestHolder.get();
    }

    public static HttpServletResponse getServletResponse()  {
        return responseHolder.get();
    }

    public static void clear() {
        requestHolder.remove();
        responseHolder.remove();
    }
}