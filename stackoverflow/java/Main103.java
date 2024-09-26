import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Main103 {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String responseStr = "{\"message\":\"error\"}";
        String responseStrAlternated = "{\"message\":\"alternative error\"}";

        try {
            ExceptionResponse exceptionResponse1 = objectMapper.readValue(responseStr, ExceptionResponse.class);
            ExceptionResponse emptyExceptionResponse = new ExceptionResponse();
            objectMapper.readerForUpdating(emptyExceptionResponse).readValue(responseStrAlternated);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ExceptionResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}