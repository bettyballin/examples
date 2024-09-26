import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import java.lang.annotation.Annotation;

public class YourController3 {

    @ExceptionHandler(value = AccessDeniedException.class)
    public ModelAndView accessDenied(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex, HandlerMethod handlerMethod) {
        if (handlerMethod != null) {
            AllowedForSystemUsers allowedAnnotation = handlerMethod.getMethodAnnotation(AllowedForSystemUsers.class);
            if (allowedAnnotation != null) {
                // Handle case for @AllowedForSystemUsers
            }
        }

        return new ModelAndView("redirect:/error");
    }

    // Define your AllowedForSystemUsers annotation somewhere in your codebase
    public @interface AllowedForSystemUsers {
    }
}