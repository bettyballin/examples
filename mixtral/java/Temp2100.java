import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class Temp2100 {
    public static void main(String[] args) {
        try {
            PrivateKey privateKey = getPrivateKey("path/to/your/privatekey.pem");
            System.out.println("Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PrivateKey getPrivateKey(String filename) throws Exception {
        File f = new File(filename);

        if (!f.exists())
            throw new IllegalArgumentException("File does not exist.");

        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));

        byte[] keyBytes = new byte[(int) f.length()];

        dis.readFully(keyBytes);
        dis.close();

        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);

        KeyFactory kf = KeyFactory.getInstance("RSA");

        return kf.generatePrivate(spec);
    }
}