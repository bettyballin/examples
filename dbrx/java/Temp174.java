import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Map;

public class Temp174 {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            // Assuming 's' is a JSON string. Replace 's' with your actual JSON string.
            String s = "{\"key\":\"value\"}";
            Object obj = parser.parse(s);
            Map js = (Map) obj;
            System.out.println(js);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}