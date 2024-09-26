import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionManagement {

    private static final String IS_URL_VERIFIED = "isUrlVerified";
    private ApplicationUrlConfig applicationUrlConfig;
    private AuthenticationSuccessHandler successHandler;

    // Assume getters/setters for applicationUrlConfig and successHandler are available

    public void manageSession(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        HttpSession session = request.getSession(false);

        if (session != null && (System.currentTimeMillis() - session.getCreationTime()) > getMaxSessionTimeToLive()) {
            response.sendRedirect(applicationUrlConfig.getSpringLogoutUrl());
            return;
        } else if (session != null && session.getAttribute(IS_URL_VERIFIED) == null) {
            String targetURL = successHandler.onSuccess(authentication, request);

            if (!targetURL.equals(applicationUrlConfig.getEndUserIndexUrl()) &&
                !targetURL.equals(applicationUrlConfig.getAdminIndexUrl())) {
                response.sendRedirect(targetURL);
            }
        }
    }

    private long getMaxSessionTimeToLive() {
        // Your logic to determine the maximum session time to live
        return 0; // Replace 0 with the actual logic to get max session TTL
    }
}