import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@RestController
public class MyController9 {

    @Autowired
    private ApplicationContext context;

    @GetMapping(value= "/method")
    public String exampleForMethodPreAuthorize() {
        if(this.methodController()){
            return "forMethodPreAuthorize";
        }
        else return null;
    }
    
    public boolean methodController(){
        // Your business logic here
        return true;
    }
}