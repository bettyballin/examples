import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

@Controller
public class MyResource {

    // This resource will require role ROLE_ADMIN
    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Admin Page";
    }

    // Override the default setting for this specific method
    @PreAuthorize("hasAnyRole('ROLE_USER', 'IS_AUTHENTICATED_ANONYMOUSLY')")
    @RequestMapping("/userOrAnonymous")
    @ResponseBody
    public String userOrAnonymous() {
        return "User or Anonymous Page";
    }
}