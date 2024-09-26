import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.interfaces.BCECPublicKey;
import java.security.KeyPair;
import java.security.interfaces.ECPublicKey;

public class PublicKeyRefactor1 {
    public static void main(String[] args) {
        KeyPair pair = null; // Assume pair is initialized elsewhere with a proper ECPublicKey
        BCECPublicKey pubKey = pair.getPublic() instanceof BCECPublicKey
            ? (BCECPublicKey) pair.getPublic()
            : new BCECPublicKey((ECPublicKey) pair.getPublic(), BouncyCastleProvider.CONFIGURATION);
    }
}