import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String targetUrl = super.determineTargetUrl(request, response);

        if (StringUtils.hasText(targetUrl)) {
            // Preserve original query parameters
            Map<String, String[]> params = request.getParameterMap();

            StringBuilder redirectUrl = new StringBuilder()
                    .append(targetUrl)
                    .append("?");

            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                for (String value : entry.getValue()) {
                    redirectUrl.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                            .append("=")
                            .append(URLEncoder.encode(value, StandardCharsets.UTF_8))
                            .append("&");
                }
            }

            // Remove the last '&' character
            if (redirectUrl.length() > 0) {
                redirectUrl.setLength(redirectUrl.length() - 1);
            }

            // Redirect to the target URL with preserved query parameters
            response.sendRedirect(response.encodeRedirectURL(redirectUrl.toString()));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}