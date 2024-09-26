import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class SomeController4 {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("userId");
    }
    
}