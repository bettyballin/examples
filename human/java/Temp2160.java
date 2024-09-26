import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Temp2160 {

    public static void main(String[] args) {
        // Main method is not necessary for this example
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("userId");
    }
}