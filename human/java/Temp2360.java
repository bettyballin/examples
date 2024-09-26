import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.RedirectView;

public class Temp2360 {

    public static void main(String[] args) {
        HttpServletRequest request = null;  // Placeholder for the actual HttpServletRequest object
        HttpServletResponse response = null; // Placeholder for the actual HttpServletResponse object
        try {
            getRedirectStrategy().sendRedirect(request, response, "/home/welcome?notactive");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static RedirectStrategy getRedirectStrategy() {
        return new DefaultRedirectStrategy();
    }

    interface RedirectStrategy {
        void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws Exception;
    }

    static class DefaultRedirectStrategy implements RedirectStrategy {
        public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws Exception {
            if (response != null) {
                response.sendRedirect(url);
            } else {
                System.out.println("Redirect URL: " + url);
            }
        }
    }
}