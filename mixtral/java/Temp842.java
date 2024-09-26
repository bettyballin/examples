import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Security;

public class Temp842 {
    private PrivateKey privateKey;

    public static void main(String[] args) {
        Temp842 temp = new Temp842();
        temp.generateKeyPair();
        temp.signContent();
    }

    private void generateKeyPair() {
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            this.privateKey = keyPair.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void signContent() {
        try {
            ContentSigner sha256Signer = new JcaContentSignerBuilder("SHA256withRSA")
                    .setProvider("BC")
                    .build(this.privateKey);
            System.out.println("ContentSigner created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}