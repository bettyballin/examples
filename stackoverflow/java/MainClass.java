import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainClass {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    byte[] input = "www.java2s.com".getBytes();
    byte[] keyBytes = new byte[] {
      (byte)0x00, (byte)0x01, (byte)0x02, (byte)0x03, (byte)0x04,
      (byte)0x05, (byte)0x06, (byte)0x07, (byte)0x08, (byte)0x09,
      (byte)0x0a, (byte)0x0b, (byte)0x0c, (byte)0x0d, (byte)0x0e,
      (byte)0x0f, (byte)0x10, (byte)0x11, (byte)0x12, (byte)0x13,
      (byte)0x14, (byte)0x15, (byte)0x16, (byte)0x17 };

    SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

    System.out.println(new String(input));

    // encryption pass
    cipher.init(Cipher.ENCRYPT_MODE, key);

    byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
    int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
    ctLength += cipher.doFinal(cipherText, ctLength);
    System.out.println(new String(cipherText));
    System.out.println(ctLength);

    // decryption pass
    cipher.init(Cipher.DECRYPT_MODE, key);
    byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
    int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
    ptLength += cipher.doFinal(plainText, ptLength);
    System.out.println(new String(plainText));
    System.out.println(ptLength);
  }
}