import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private ApplicationContext context;

    @GetMapping(value = "/method")
    public String exampleForMethodPreAuthorize() {
        if (context.getBean(MyController.class).methodController()) {
            return "forMethodPreAuthorize";
        } else {
            return null;
        }
    }

    public boolean methodController() {
        // Example logic for methodController
        return true;
    }
}