import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

class MobileData {
    private String publicKeyEncoded;

    public String getPublicKeyEncoded() {
        return publicKeyEncoded;
    }

    public void setPublicKeyEncoded(byte[] publicKeyEncoded) {
        this.publicKeyEncoded = Base64.getEncoder().encodeToString(publicKeyEncoded);
    }
}

public class Temp2239 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();

            MobileData data = new MobileData();
            data.setPublicKeyEncoded(keyPair.getPublic().getEncoded());

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(data);
            System.out.println(jsonString);
        } catch (NoSuchAlgorithmException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}