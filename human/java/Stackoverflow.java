import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Stackoverflow {

    private static final int keySize = 128;
    static byte[] saltForThisRun = new byte[8];
    static {
        SecureRandom random = new SecureRandom();
        random.nextBytes(saltForThisRun);
    }

    public static void main(
            String[] args) throws Exception {
        Message message = buildTestMessage("from@null.org", new String[] { "to@null.org", "to2@null.org" },
                "Subject is needed here", Optional.of("This is just a text"), Optional.empty());

        char[] password = "password".toCharArray();
        String encryptedMsg = encrypt(password, saltForThisRun, message);
        System.out.println("encryptedMsg: " + encryptedMsg);
        Message message2 = decrypt(password, saltForThisRun, encryptedMsg);

        // out sth. like from@domain <--> null
        System.out.println(message.getFrom()[0] + " <--> " + message2.getFrom()[0]);

    }

    private static Message decrypt(
            char[] password,
            byte[] salt,
            String base64CipherText) throws EncryptionException {
        try {
            SecretKey secretKey = generateKey(password, salt, keySize);
            byte[] initializationVector = createInitializationVector(keySize);

            Cipher aesCipherForDecryption = Cipher.getInstance("AES/CBC/PKCS5PADDING");

            aesCipherForDecryption.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(initializationVector));
            byte[] decryptedByteCipherText = Base64.getDecoder().decode(base64CipherText);
            byte[] byteDecryptedMessage = aesCipherForDecryption.doFinal(decryptedByteCipherText);
            return createMessageFromBytes(byteDecryptedMessage);
        } catch (IllegalStateException | InvalidKeyException | InvalidAlgorithmParameterException
                | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException
                | IllegalBlockSizeException | BadPaddingException | MessagingException e) {
            throw new EncryptionException(String.format("Unable to enrypt message due to: %s", e.getMessage()), e);
        }
    }

    /**
     * 
     * @param password
     * @param salt
     * @param message
     * @param charArray
     * @return Base64 encoded CipherText
     * @throws EncryptionException
     *             If sth. goes wrong
     */
    private static String encrypt(
            char[] password,
            byte[] salt,
            Message message) throws EncryptionException {
        try {
            /**
             * Step 1. Generate an AES key with password and salt
             * 
             */
            SecretKey secretKey = generateKey(password, salt, keySize);
            System.out.println(secretKey.getEncoded().length);

            /**
             * Step 2. Generate an Initialization Vector (IV)
             * a. Use SecureRandom to generate random bits
             * The size of the IV matches the blocksize of the cipher (e.g. 128 bits for AES)
             * b. Construct the appropriate IvParameterSpec object for the data to pass to Cipher's init() method
             */
            byte[] initializationVector = createInitializationVector(keySize);

            /**
             * Step 3. Create a Cipher by specifying the following parameters
             * a. Algorithm name - here it is AES
             * b. Mode - here it is CBC mode
             * c. Padding - e.g. PKCS7 or PKCS5
             * 
             * Must specify the mode explicitly as most JCE providers default to ECB mode!!
             */
            Cipher aesCipherForEncryption = Cipher.getInstance("AES/CBC/PKCS5PADDING");

            /**
             * Step 4. Initialize the Cipher for Encryption