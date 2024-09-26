import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.RSAKeyGenParameterSpec;

public class Main47 {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        RSAKeyGenParameterSpec kpgSpec = new RSAKeyGenParameterSpec(2048, BigInteger.valueOf(3));
        kpg.initialize(kpgSpec);
        KeyPair kp = kpg.genKeyPair();
    }
}