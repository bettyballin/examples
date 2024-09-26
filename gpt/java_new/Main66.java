import org.jasypt.util.text.BasicTextEncryptor;

public class Main66 {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("mySecretEncryptionKey");
        String myEncryptedText = textEncryptor.encrypt("PasswordToEncrypt");
        System.out.println(myEncryptedText);
    }
}