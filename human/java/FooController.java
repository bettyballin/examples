import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FooApplication {
    public static void main(String[] args) {
        SpringApplication.run(FooApplication.class, args);
    }
}

@RestController
class FooController {
    
    @GetMapping("/foo")
    Foo getFoo(Authentication a) {
        return FooUtils.generateFoo(a);
    }
}

class Foo {
    private String data;
    
    public Foo(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

class FooUtils {
    static Foo generateFoo(Authentication a) {
        return new Foo("Generated data based on authentication: " + a.getName());
    }
}