import org.apache.commons.codec.binary.Hex;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import javax.crypto.spec.DHParameterSpec;

public class Temp2234 {
    public static void main(String[] args) {
        try {
            String publicKey = generatePublicKeyEncode();
            System.out.println("Generated Public Key: " + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generatePublicKeyEncode() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");

        // Prime and generator values for Diffie-Hellman key pair generation
        BigInteger p = new BigInteger(1, Hex.decodeHex("DE4779E7F4523CA143FFE102853E671CAAAB96203B1FC3C42D0EA1CB6878FC" +
                "A889C79C709DDDB119DF9073050B1AD410D34A48A6E5A1D2C1854C471528DB3C4FE4" +
                "8A237FC86BAAB77AAAB8A17750DBA7948F258BD55E480B"));
        BigInteger g = new BigInteger(1, Hex.decodeHex("D719835971E8A" +
                "91980141201FF765392A0049841142A3C203862AF"));

        DHParameterSpec dhParams = new DHParameterSpec(p, g, 1);
        kpg.initialize(dhParams, new SecureRandom());

        KeyPair keyPair = kpg.generateKeyPair();

        return Hex.encodeHexString(keyPair.getPublic().getEncoded());
    }
}