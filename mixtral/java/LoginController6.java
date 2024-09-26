import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.web.savedrequest.HttpSessionSavedRequest;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private RequestCache requestCache;

    @GetMapping("/login")
    public String showLoginForm(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        SavedRequest savedRequest = new HttpSessionSavedRequest() {
            @Override
            public void setRedirectUrl(String url) {
                super.setRedirectUrl(httpServletRequest.getHeader("Referer"));
            }
        };

        requestCache.saveRequest(httpServletRequest, httpServletResponse);

        return "login";
    }
}