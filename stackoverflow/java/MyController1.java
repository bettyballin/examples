import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MyController1 {

    @RequestMapping(value = "/url", method = RequestMethod.GET, headers = "my-header")
    public void myMethod() {
        // Method body
    }
}