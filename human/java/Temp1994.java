import javax.servlet.http.HttpServletResponse;

public class Temp1994 {
    public static void main(String[] args) {
        Temp1994 temp = new Temp1994();
        temp.handleUnauthorized(request -> {}, response -> {});
    }

    public void handleUnauthorized(RequestHandler request, ResponseHandler response) {
        try {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    interface RequestHandler {
        void handle() throws Exception;
    }

    interface ResponseHandler {
        void sendError(int sc) throws Exception;
    }
}