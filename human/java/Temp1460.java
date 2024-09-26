import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp1460 {
    public static void main(String[] args) {
        try {
            // Sample data for demonstration
            byte[] encryptedMessage = new byte[]{/* your encrypted data */};
            byte[] key = new byte[]{/* your key data */};
            byte[] iv = new byte[]{/* your IV data */};

            Temp1460 temp = new Temp1460();
            byte[] decryptedMessage = temp.decrypt(encryptedMessage, key, iv);
            
            // Print the decrypted message (Assuming it's a string for demonstration)
            System.out.println(new String(decryptedMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] decrypt(byte[] encMsgtoDec, byte[] key, byte[] iv) throws Exception {
        // Prepare key
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        // Prepare cipher
        String cipherALG = "AES/CBC/PKCS5Padding"; // use your preferred algorithm 
        Cipher cipher = Cipher.getInstance(cipherALG);
        String string = cipher.getAlgorithm();

        // As iv (Initial Vector) is only required for CBC mode
        if (string.contains("CBC")) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);      
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        }

        byte[] decMsg = cipher.doFinal(encMsgtoDec);        
        return decMsg;
    }
}