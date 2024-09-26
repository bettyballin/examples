import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({BadRequestException.class, MethodArgumentNotValidException.class})
    public ModelAndView badRequestHandler(HttpServletRequest request, Exception exception) {
        logger.error("400 Bad Request", exception);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("/error_400");
        return modelAndView;
    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView notFoundHandler(HttpServletRequest request, Exception exception) {
        logger.error("404 Not Found", exception);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("/error_404");
        return modelAndView;
    }
}