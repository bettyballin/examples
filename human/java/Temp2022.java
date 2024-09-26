import java.util.Base64;
import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;

public class Temp2022 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PublicKey pubKey = keyPair.getPublic();
            PrivateKey privKey = keyPair.getPrivate();

            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", "BC");
            OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-256", "MGF1", new PSource.PSpecified(new byte[0]));
            cipher.init(Cipher.ENCRYPT_MODE, pubKey, oaepParams);

            String pubKeyEncoded = Base64.getEncoder().encodeToString(pubKey.getEncoded());
            String data = "{\"key\" : \"" + pubKeyEncoded + "\"}";

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost("http://localhost:9000/crypt/");
            request.setEntity(new StringEntity(data));
            request.setHeader("Content-Type", "application/json");

            HttpResponse response = httpClient.execute(request);
            String respText = EntityUtils.toString(response.getEntity());

            cipher.init(Cipher.DECRYPT_MODE, privKey, oaepParams);
            byte[] decoded = cipher.doFinal(Base64.getDecoder().decode(respText));

            System.out.println(new String(decoded));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}