import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

public class Temp1212 {
    public static void main(String[] args) throws Exception {
        KeyPair serverKpair = generateKeyPair();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gzos = new GZIPOutputStream(baos);
        ObjectOutputStream oos = new ObjectOutputStream(gzos);

        oos.writeObject(serverKpair);
        oos.close();
        gzos.close();
        baos.close();

        byte[] serializedObject = baos.toByteArray();
        String base64Encoded = Base64.getEncoder().encodeToString(serializedObject);
        System.out.println(base64Encoded.length());
    }

    private static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        return kpg.generateKeyPair();
    }
}