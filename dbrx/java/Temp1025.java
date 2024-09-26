import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @ExceptionHandler(MyException.class)
    public String notConfirmedError(Model model) {
        return "redirect:/notconfirmed";
    }

    @RequestMapping("/notconfirmed")
    public String notConfirmed(Model model) {
        // Add any data required for the view here
        return "notconfirmed";
    }
}

public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}