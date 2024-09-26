import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@ControllerAdvice
public class ExceptionController implements ErrorController {

  private static final String ERROR_PATH = "/error";

  // @ExceptionHandler methods here.

  @Override
  public String getErrorPath() {
    return ERROR_PATH;
  }
}