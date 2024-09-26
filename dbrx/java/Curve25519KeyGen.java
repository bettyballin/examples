import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

public class Curve25519KeyGen {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("X25519");
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDH", "BC");

        SecureRandom random = new SecureRandom();
        keyGen.initialize(ecSpec, random);

        KeyPair keypair = keyGen.generateKeyPair();

        System.out.println(keypair.getPrivate());
        System.out.println(keypair.getPublic());
    }
}