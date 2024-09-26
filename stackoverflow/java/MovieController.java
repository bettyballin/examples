import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/movies", produces="application/json")
public class MovieController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public MyResponseObject getMovies(){
        return new MyResponseObject("foo", "bar");
    }
}

class MyResponseObject {
    private String foo;
    private String bar;

    public MyResponseObject(String foo, String bar) {
        this.foo = foo;
        this.bar = bar;
    }

    // Getters and Setters
    public String getFoo() { return foo; }
    public void setFoo(String foo) { this.foo = foo; }
    public String getBar() { return bar; }
    public void setBar(String bar) { this.bar = bar; }
}