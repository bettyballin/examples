import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Temp1511 {
    public static void main(String[] args) {
        String jsonString = "{\"fieldName\": 42}"; // Example JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode myObj = objectMapper.readTree(jsonString);

            if (myObj.get("fieldName").isNumber()) {
                int value = myObj.get("fieldName").intValue();
                System.out.println("Integer value: " + value);
            } else if (myObj.get("fieldName").isTextual() && !myObj.get("fieldName").asText().isEmpty()) {
                String textValue = myObj.get("fieldName").textValue();
                System.out.println("Text value: " + textValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}