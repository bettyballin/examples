import com.google.gson.*;
import java.lang.reflect.Type;

class NestedClass {
    // Fields and methods for NestedClass
}

public class Main {
    private static final JsonDeserializer<NestedClass> NESTED_CLASS_DESERIALIZER = new JsonDeserializer<NestedClass>() {
        @Override
        public NestedClass deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            // Deserialize the object manually here
            return new Gson().fromJson(json, NestedClass.class);
        }
    };

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(NestedClass.class, NESTED_CLASS_DESERIALIZER)
                .create();
        
        // Example usage
        String json = "{\"field\": \"value\"}";
        NestedClass obj = gson.fromJson(json, NestedClass.class);
        System.out.println(obj);
    }
}