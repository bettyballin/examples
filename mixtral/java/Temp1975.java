import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp1975 {
    public static void main(String[] args) throws Exception {
        byte[] key = "12345678".getBytes(); // 8-byte key for DES
        byte[] iv = "12345678".getBytes();  // 8-byte IV for DES

        Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
        SecretKeySpec k = new SecretKeySpec(key, "DES");
        IvParameterSpec ivspec = new IvParameterSpec(iv);
        c.init(Cipher.ENCRYPT_MODE, k, ivspec);
        byte[] ct = c.doFinal("plaintext".getBytes());

        System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(ct));
    }
}