import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    public static void main(String[] args) throws Exception {
        byte[] keyBytes = new byte[]{
            (byte) 0x36, (byte) 0xf1, (byte) 0x83, (byte) 0x57,
            (byte) 0xbe, (byte) 0x4d, (byte) 0xbd, (byte) 0x77,
            (byte) 0xf0, (byte) 0x35, (byte) 0xae, (byte) 0x2f,
            (byte) 0x25, (byte) 0x57, (byte) 0x8b, (byte) 0x9a
        };
        
        byte[] ivBytes = new byte[]{
            (byte) 0x86, (byte) 0x23, (byte) 0x10, (byte) 0x4f,
            (byte) 0x33, (byte) 0x98, (byte) 0x90, (byte) 0x22,
            (byte) 0x77, (byte) 0x56, (byte) 0x10, (byte) 0x34,
            (byte) 0x89, (byte) 0x10, (byte) 0x31, (byte) 0x66
        };

        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        String plaintext = "This is a plaintext message.";
        byte[] encrypted = cipher.doFinal(plaintext.getBytes());
        
        // Outputs encrypted data in hexadecimal form
        for (byte b : encrypted) {
            System.out.format("%02X", b);
        }
    }
}