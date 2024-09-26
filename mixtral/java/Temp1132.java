import org.bouncycastle.bcpg.*;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.operator.jcajce.JcaPEMKeyConverter;

import java.io.*;
import java.security.PublicKey;
import java.util.Iterator;

public class Temp1132 {
    public static void main(String[] args) {
        try {
            PublicKey publicKey = getPublicKey("path/to/your/pubkeyfile.asc");
            System.out.println(publicKey);
        } catch (IOException | PGPException e) {
            e.printStackTrace();
        }
    }

    public static PublicKey getPublicKey(String filename) throws IOException, PGPException {
        InputStream keyIn = new BufferedInputStream(new FileInputStream(filename));

        JcaPGPPublicKeyRingCollection pgpPub = new JcaPGPPublicKeyRingCollection(
                PGPUtil.getDecoderStream(keyIn)
        );

        PGPPublicKey publicKey = null;

        Iterator<PGPPublicKeyRing> keyRings = pgpPub.getKeyRings();

        while (publicKey == null && keyRings.hasNext()) {
            PGPPublicKeyRing kRing = keyRings.next();

            Iterator<PGPPublicKey> keys = kRing.getPublicKeys();

            while (keys.hasNext() && publicKey == null)
                publicKey = keys.next();
        }

        if (publicKey != null) {
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");

            return converter.getPublicKey(PGPPublicKey.convertPublicKey(publicKey));
        }

        return null;
    }
}