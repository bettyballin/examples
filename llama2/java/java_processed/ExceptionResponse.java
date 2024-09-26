import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

public class ExceptionResponse extends Exception {
    private String[] reasons;

    public ExceptionResponse(String message, Throwable cause) {
        super(message, cause);
        this.reasons = new String[]{cause.getMessage()};
    }

    public String[] getReasons() {
        return reasons;
    }

    public void writeTo(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("message", getMessage());
        jsonGenerator.writeArrayFieldStart("reasons");
        for (String reason : reasons) {
            jsonGenerator.writeString(reason);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}

public class CompanyExceptionResponseWrapper extends ExceptionResponse {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public CompanyExceptionResponseWrapper(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        // Customize the exception response string
        return "Company Exception: " + getMessage() + "\nReasons: [" + Arrays.toString(getReasons()) + "]\nCompany Error Code: 1234";
    }

    @Override
    public void writeTo(JsonGenerator jsonGenerator) throws IOException {
        // Customize the exception response JSON
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("message", getMessage());
        jsonGenerator.writeArrayFieldStart("reasons");
        for (String reason : getReasons()) {
            jsonGenerator.writeString(reason);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeStringField("companyErrorCode", "1234");
        jsonGenerator.writeEndObject();
    }

    public static void main(String[] args) {
        try {
            throw new CompanyExceptionResponseWrapper("Custom Exception Message", new Throwable("Root Cause"));
        } catch (CompanyExceptionResponseWrapper e) {
            System.out.println(e);
            try {
                StringWriter writer = new StringWriter();
                JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(writer);
                e.writeTo(jsonGenerator);
                jsonGenerator.close();
                System.out.println(writer.toString());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}