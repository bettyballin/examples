import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SecurityAnswerRequest {

    private static KeyGenerator keyGen = null; // Initialize once and reuse

    public static boolean encrypt(String text) {
        byte[] encryptedText = new byte[0];
        SecretKey myDesKey = null;
        try {
            if (keyGen == null)
                keyGen = KeyGenerator.getInstance("DES");

            myDesKey = keyGen.generateKey();
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); // Use ECB mode for simplicity
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            encryptedText = desCipher.doFinal(text.getBytes());

        } catch (Exception e) {
            System.out.println("There has been an error encrypting the file");
            return false;
        }

        String stringKey = Base64.getEncoder().encodeToString(myDesKey.getEncoded());
        JTextArea textArea = new JTextArea(2, 50);
        textArea.setText("Your encryption key is: " + stringKey
                + ". Ensure you store it in a safe place");
        textArea.setEditable(false);

        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "RESULT", JOptionPane.INFORMATION_MESSAGE);

        return true;
    }

    public static void main(String[] args) {
        String text = JOptionPane.showInputDialog("Enter text to encrypt:");
        encrypt(text);
    }
}