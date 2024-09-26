import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.JCEECPublicKey;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;

public class Temp3312 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", "BC");
        keyPairGenerator.initialize(256);
        KeyPair pair = keyPairGenerator.generateKeyPair();

        final BCECPublicKey pubKey = pair.getPublic() instanceof BCECPublicKey
                ? (BCECPublicKey) pair.getPublic()
                : new BCECPublicKey((ECPublicKey) pair.getPublic(), BouncyCastleProvider.CONFIGURATION);

        System.out.println("Public Key: " + pubKey);
    }
}