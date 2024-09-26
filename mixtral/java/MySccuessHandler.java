import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private RequestCache requestCache;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        SavedRequest savedRequest = requestCache.getRequest(httpServletRequest, httpServletResponse);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            httpServletResponse.sendRedirect(targetUrl);
        } else {
            // Default redirect URL
            httpServletResponse.sendRedirect("/default-redirect");
        }
    }
}