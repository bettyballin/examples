import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Iterator;

public class Temp1961 {
    public static void main(String[] args) {
        // Example usage:
        // Note: Replace with actual file paths and password
        try {
            PublicKey publicKey = getPublicKey("path/to/public/key");
            System.out.println("Got public key: " + publicKey);

            InputStream privateKeyInputStream = new FileInputStream("path/to/private/key");
            char[] password = "password".toCharArray();
            PrivateKey privateKey = getPrivateKey(privateKeyInputStream, password);
            System.out.println("Got private key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PublicKey getPublicKey(String filePath)
            throws PGPException, NoSuchProviderException, FileNotFoundException, IOException {
        PGPPublicKey encKey = readPublicKey(new FileInputStream(filePath));
        return new JcaPGPKeyConverter().setProvider("BC").getPublicKey(encKey);
    }

    public static PrivateKey getPrivateKey(InputStream in, char[] passwd)
            throws IOException, PGPException, NoSuchProviderException {
        in = PGPUtil.getDecoderStream(in);

        PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(in);

        Iterator<?> rIt = pgpSec.getKeyRings();

        while (rIt.hasNext()) {
            PGPSecretKeyRing kRing = (PGPSecretKeyRing) rIt.next();
            Iterator<?> kIt = kRing.getSecretKeys();

            while (kIt.hasNext()) {
                PGPSecretKey k = (PGPSecretKey) kIt.next();

                if (k != null) {
                    PGPPrivateKey pk = k.extractPrivateKey(passwd, "BC");
                    return new JcaPGPKeyConverter().setProvider("BC").getPrivateKey(pk);
                }
            }
        }

        throw new IllegalArgumentException("Can't find secured key in key ring.");
    }

    public static PGPPublicKey readPublicKey(InputStream in)
            throws IOException, PGPException {
        in = PGPUtil.getDecoderStream(in);

        PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(in);

        Iterator<?> rIt = pgpPub.getKeyRings();

        while (rIt.hasNext()) {
            PGPPublicKeyRing kRing = (PGPPublicKeyRing) rIt.next();
            Iterator<?> kIt = kRing.getPublicKeys();

            while (kIt.hasNext()) {
                PGPPublicKey k = (PGPPublicKey) kIt.next();

                if (k.isEncryptionKey()) {
                    return k;
                }
            }
        }

        throw new IllegalArgumentException("Can't find encryption key in key ring.");
    }
}