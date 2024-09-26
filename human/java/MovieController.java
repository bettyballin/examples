import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/movies", produces="application/json")
public class MovieController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public MyResponseObject getMovies() {
        // you can return a POJO object if you are using a Jackson Mapper
        return new MyResponseObject("foo", "bar");
    }

    static class MyResponseObject {
        private String field1;
        private String field2;

        public MyResponseObject(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }
    }
}