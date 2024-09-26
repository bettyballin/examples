import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2Engine;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoException;
import java.security.Security;
import java.security.SecureRandom;

public class Temp1240 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastlePQCProvider());

        try {
            McElieceCCA2KeyPairGenerator keyGen = new McElieceCCA2KeyPairGenerator();
            keyGen.init(new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Engine().getDefaultParams()));

            AsymmetricCipherKeyPair keyPair = keyGen.generateKeyPair();
            McElieceCCA2PublicKeyParameters pubParams = (McElieceCCA2PublicKeyParameters) keyPair.getPublic();
            McElieceCCA2PrivateKeyParameters privParams = (McElieceCCA2PrivateKeyParameters) keyPair.getPrivate();

            McElieceCCA2Engine cipher = new McElieceCCA2Engine();
            cipher.init(true, pubParams);

            byte[] message = "Hello, World!".getBytes();
            byte[] cipherTextBytes = cipher.messageEncrypt(message);

            System.out.println("Cipher text: " + new String(cipherTextBytes));

            cipher.init(false, privParams);
            byte[] decryptedMessage = cipher.messageDecrypt(cipherTextBytes);

            System.out.println("Decrypted message: " + new String(decryptedMessage));
        } catch (CryptoException e) {
            e.printStackTrace();
        }
    }
}