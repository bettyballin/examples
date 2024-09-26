import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.ASN1InputStream;

public class Temp2593 {
    public static void main(String[] args) {
        // Example usage
        // InputStream input = ...; // Provide an InputStream to a PKCS#8 private key file
        // try {
        //     PrivateKey privateKey = readPrivateKey(input);
        //     System.out.println(privateKey);
        // } catch (IOException | GeneralSecurityException e) {
        //     e.printStackTrace();
        // }
    }

    /** Read a PKCS#8 format private key. */
    private static PrivateKey readPrivateKey(InputStream input) throws IOException, GeneralSecurityException {
        try {
            byte[] buffer = new byte[4096];
            int size = input.read(buffer);
            byte[] bytes = Arrays.copyOf(buffer, size);
            /* Check to see if this is in an EncryptedPrivateKeyInfo structure. */
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
            /*
             * Now it's in a PKCS#8 PrivateKeyInfo structure. Read its Algorithm
             * OID and use that to construct a KeyFactory.
             */
            ASN1InputStream bIn = new ASN1InputStream(new ByteArrayInputStream(spec.getEncoded()));
            PrivateKeyInfo pki = PrivateKeyInfo.getInstance(bIn.readObject());
            String algOid = pki.getPrivateKeyAlgorithm().getAlgorithm().getId();
            return KeyFactory.getInstance(algOid).generatePrivate(spec);
        } finally {
            input.close();
        }
    }
}