import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Map;

public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {

    public CustomOauthExceptionSerializer() {
        super(CustomOauthException.class);
    }

    @Override
    public void serialize(CustomOauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("custom_error", value.getOAuth2ErrorCode());
        gen.writeStringField("custom_error_description", value.getMessage());
        if (value.getAdditionalInformation() != null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                gen.writeStringField(key, add);
            }
        }
        gen.writeEndObject();
    }
}

// Assuming the CustomOauthException class is defined as follows:
class CustomOauthException extends Exception {
    private String oAuth2ErrorCode;
    private Map<String, String> additionalInformation;

    public CustomOauthException(String message, String oAuth2ErrorCode, Map<String, String> additionalInformation) {
        super(message);
        this.oAuth2ErrorCode = oAuth2ErrorCode;
        this.additionalInformation = additionalInformation;
    }

    public String getOAuth2ErrorCode() {
        return oAuth2ErrorCode;
    }

    public Map<String, String> getAdditionalInformation() {
        return additionalInformation;
    }
}