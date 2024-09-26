import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Temp1200 {
    public static void main(String[] args) {
        String input = "{\"key\": \"value\"}"; // Example JSON input

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonData = mapper.readTree(input);

            // Process the parsed JSON data
            System.out.println(jsonData);

        } catch (JsonProcessingException e) {
            // Proceed to step 2 for HTML sanitization
            e.printStackTrace();
        }
    }
}