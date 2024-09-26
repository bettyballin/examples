import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SecureEncryption {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public byte[] encrypt(String data, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[cipher.getBlockSize()]);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        
        return cipher.doFinal(data.getBytes());
    }

    public static void main(String[] args) {
        try {
            String data = "Hello, World!";
            byte[] key = "1234567890123456".getBytes(); // 16-byte key for AES-128
            SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
            
            SecureEncryption secureEncryption = new SecureEncryption();
            byte[] encryptedData = secureEncryption.encrypt(data, secretKey);
            
            System.out.println("Encrypted Data: " + new String(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}