import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp2017 {
    public static void main(String[] args) {
        System.out.println("Server is running...");
    }

    @RequestMapping(value = "/is_auth")
    public boolean getAuth() {
        return true;
    }
}