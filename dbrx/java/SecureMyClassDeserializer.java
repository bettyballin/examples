import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

public class SecureMyClassDeserializer extends StdDeserializer<MyClassRequest> {

    public SecureMyClassDeserializer() {
        super(MyClassRequest.class);
    }

    @Override
    public MyClassRequest deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        MyClassRequest myClassRequest = new MyClassRequest();

        // Only set the allowed properties/fields here.
        JsonNode myDataNode = jsonNode.get("myData");
        if (myDataNode != null && !myDataNode.asText().isEmpty()) {
            myClassRequest.setMyData(myDataNode.asText());
        }

        return myClassRequest;
    }
}

class MyClassRequest {
    private String myData;

    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }
}