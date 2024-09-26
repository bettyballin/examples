import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class Temp610 {
    public static void main(String[] args) {
        // Dummy HttpServletRequest and HttpServletResponse for demonstration purposes
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        try {
            buildRedirectUrlToLoginPage(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request != null) {
            String loginPageUrl = "/login";
            String encodedLoginPageUrl = URLEncoder.encode(loginPageUrl, "UTF-8");
            response.sendRedirect(encodedLoginPageUrl);
        } else {
            System.out.println("HttpServletRequest is null");
        }
    }
}