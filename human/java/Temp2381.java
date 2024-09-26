import com.google.gson.Gson;

public class Temp2381 {
    public static void main(String[] args) {
        Object value = "Example String"; // Example value, replace with your actual value
        Temp2381 temp = new Temp2381();
        String result = temp.processValue(value);
        System.out.println(result);
    }

    public String processValue(Object value) {
        Gson gson = new Gson();
        String escaped = gson.toJson(value);
        if (value instanceof String) {
            if (escaped.startsWith("\"")) {
                escaped = escaped.substring(1);
            }
            if (escaped.endsWith("\"")) {
                escaped = escaped.substring(0, escaped.length() - 1);
            }
            return escaped;
        }
        return escaped;
    }
}