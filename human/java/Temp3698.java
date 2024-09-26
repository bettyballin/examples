import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

class ExceptionResponse {
    private String message;
    private int code;

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String responseStr = "{\"message\": \"Error occurred\", \"code\": 500}";
        String responseStrAlternated = "{\"message\": \"Different error\", \"code\": 404}";

        ExceptionResponse emptyExceptionResponse = new ExceptionResponse();

        try {
            ExceptionResponse exceptionResponse1 = objectMapper.readValue(responseStr, ExceptionResponse.class);
            ExceptionResponse exceptionResponse2 = objectMapper.readerForUpdating(emptyExceptionResponse).readValue(responseStrAlternated);

            System.out.println("ExceptionResponse1: " + exceptionResponse1.getMessage() + ", " + exceptionResponse1.getCode());
            System.out.println("ExceptionResponse2: " + exceptionResponse2.getMessage() + ", " + exceptionResponse2.getCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}