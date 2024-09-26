import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;
import java.util.Map;
import java.util.HashMap;

public class MyController4 {

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    Map<String, String> printHello(ModelMap model) {
        Map<String, String> json = new HashMap<String, String>();
        json.put("name", "abcd");
        return json;
    }
}