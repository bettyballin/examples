import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import java.security.PrivateKey;

public class Main86 {
    public static void main(String[] args) {
        // Assuming you have an instance of PrivateKey named privateKey
        PrivateKey privateKey = getPrivateKeySomehow();

        if (privateKey instanceof BCECPrivateKey) {
            BCECPrivateKey privateKey1 = (BCECPrivateKey) privateKey;
            byte[] bigIntPk = privateKey1.getS().toByteArray();
            // Do something with the byte array
        }
    }

    private static PrivateKey getPrivateKeySomehow() {
        // Your method to obtain a PrivateKey instance
        return null;
    }
}