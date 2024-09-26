import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RefactoredSnippet3 {
    public static void main(String[] args) {
        try {
            SecretKeySpec k = new SecretKeySpec(new byte[16], "AES");
            IvParameterSpec iv = new IvParameterSpec(new byte[16]);
            byte[] textData = "Your Plain Text Here".getBytes();

            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, k, iv);
            byte[] someData = c.update(textData);
            byte[] moreData = c.doFinal();

            System.out.println("E: " + (someData.length + moreData.length));

            c.init(Cipher.DECRYPT_MODE, k, iv);
            byte[] someDecrypted = c.update(someData);
            byte[] moreDecrypted = c.doFinal(moreData);

            System.out.println("R: " + (someDecrypted.length + moreDecrypted.length));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}