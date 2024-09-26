import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.security.KeyFactory;
import java.security.Key;
import java.security.spec.X509EncodedKeySpec;

public class PublicKeyReader {
    public static Key get(String filename) throws Exception {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int)f.length()];
        dis.readFully(keyBytes);
        dis.close();

        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public static void main(String[] args) {
        try {
            Key publicKey = get("path/to/your/publickeyfile");
            System.out.println("Public Key: " + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}