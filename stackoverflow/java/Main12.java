import java.io.RandomAccessFile;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class Main12 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("d:\\host.pk8", "r");
        byte[] buf = new byte[(int)raf.length()];
        raf.readFully(buf);
        raf.close();
        PKCS8EncodedKeySpec kspec = new PKCS8EncodedKeySpec(buf);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privKey = kf.generatePrivate(kspec);
        // Use the private key (privKey) as needed for your application
    }
}