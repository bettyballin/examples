import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.RSAKeyGenParameterSpec;

public class KeyPairSerializer extends StdSerializer<KeyPair> {

    public KeyPairSerializer() {
        this(null);
    }

    public KeyPairSerializer(Class<KeyPair> t) {
        super(t);
    }

    @Override
    public void serialize(KeyPair keyPair, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = objectMapper.createArrayNode();

        // Serialize the first element (the public key)
        arrayNode.addPOJO(keyPair.getPublic());

        // Serialize the second element (the private key)
        arrayNode.addPOJO(keyPair.getPrivate());

        jsonGenerator.writeTree(arrayNode);
    }

    public static void main(String[] args) throws Exception {
        // Example usage
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new SimpleModule().addSerializer(KeyPair.class, new KeyPairSerializer()));
        String jsonString = objectMapper.writeValueAsString(keyPair);
        System.out.println(jsonString);
    }
}