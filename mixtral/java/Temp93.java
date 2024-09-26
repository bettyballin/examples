import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Temp93 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String targetUrl = determineTargetUrl(request, response);
        return new ModelAndView("redirect:" + targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        String hashValue = request.getParameter("hashURL");

        if (StringUtils.hasText(hashValue)) {
            return "/home/" + hashValue;
        } else {
            // Return default target URL
            return "/defaultTarget"; // Replace this with your default URL
        }
    }

    public static void main(String[] args) {
        // Spring application context would typically handle this
    }
}