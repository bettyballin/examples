import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class Temp2409 {

    @ModelAttribute
    public void load(ModelMap model, @AuthenticationPrincipal CustomUser user){
        if(user != null){
            long userId = user.getId();
            //Query database with userId and add data to model
        }
    }

    public static void main(String[] args) {
        // This main method is not necessary for a Spring application but added here to make it a complete class
        System.out.println("This is a Spring Controller class");
    }
}

class CustomUser {
    private long id;

    public CustomUser(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}