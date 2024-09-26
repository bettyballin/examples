import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

import javax.crypto.Cipher;
import java.io.StringReader;
import java.security.PublicKey;
import java.security.Security;
import java.security.NoSuchProviderException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;

public class Temp1435 {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        // Add your test code or method calls here
    }

    public static byte[] encrypt(byte[] publicKey, byte[] inputData) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        try {
            PublicKey key = new JcaPEMKeyConverter().getPublicKey(
                (SubjectPublicKeyInfo) new PEMParser(new StringReader(new String(publicKey))).readObject()
            );

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            return cipher.doFinal(inputData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}