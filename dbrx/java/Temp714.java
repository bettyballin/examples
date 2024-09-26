import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Temp714 {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String cleanInput = "{\"key\": \"value\"}"; // Example JSON input
            JsonNode jsonNode = objectMapper.readTree(cleanInput);
            System.out.println(jsonNode.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}