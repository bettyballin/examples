import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.SecretKeyFactory;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class EncryptionDemo {

    private static final Map<String, String> COMMON_ATTRIBUTES = new HashMap<>();
    private static final Map<String, char[]> SECURE_ATTRIBUTES = new HashMap<>();
    private static final char[] PASSWORD = "Unauthorized_Personel_Is_Unauthorized".toCharArray();
    private static final byte[] SALT = {(byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12};
    private static final File DESKTOP = new File(System.getProperty("user.home") + "/Desktop");
    private static final String NO_ENCRYPTION = "no_layers.txt";
    private static final String SINGLE_LAYER = "single_layer.txt";
    private static final String DOUBLE_LAYER = "double_layer.txt";

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        COMMON_ATTRIBUTES.put("Gender", "Male");
        COMMON_ATTRIBUTES.put("Age", "21");
        COMMON_ATTRIBUTES.put("Name", "Hypot Hetical");
        COMMON_ATTRIBUTES.put("Nickname", "HH");

        SECURE_ATTRIBUTES.put("Username", "Hypothetical".toCharArray());
        SECURE_ATTRIBUTES.put("Password", "LetMePass_Word".toCharArray());

        create_EncryptedFile(NO_ENCRYPTION, COMMON_ATTRIBUTES, SECURE_ATTRIBUTES, 0);
        create_EncryptedFile(SINGLE_LAYER, COMMON_ATTRIBUTES, SECURE_ATTRIBUTES, 1);
        create_EncryptedFile(DOUBLE_LAYER, COMMON_ATTRIBUTES, SECURE_ATTRIBUTES, 2);

        System.out.println("NO ENCRYPTION: \n" + readFile_NoDecryption(NO_ENCRYPTION) + "\n\n\n");
        System.out.println("SINGLE LAYER ENCRYPTION: \n" + readFile_NoDecryption(SINGLE_LAYER) + "\n\n\n");
        System.out.println("DOUBLE LAYER ENCRYPTION: \n" + readFile_NoDecryption(DOUBLE_LAYER) + "\n\n\n");

        String decryptedContent = readFile_ApplyDecryption(DOUBLE_LAYER);
        System.out.println("READ: [first layer decrypted]\n" + decryptedContent + "\n\n\n");

        for (String line : decryptedContent.split("\n")) {
            String[] pair = line.split(": ", 2);
            if (pair[0].equalsIgnoreCase("Username") || pair[0].equalsIgnoreCase("Password")) {
                System.out.println("Decrypted: " + pair[0] + ": " + decrypt(pair[1]));
            }
        }
    }

    private static String encrypt(byte[] property) throws GeneralSecurityException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return Base64.getEncoder().encodeToString(pbeCipher.doFinal(property));
    }

    private static String encrypt(char[] property) throws GeneralSecurityException {
        byte[] bytes = new byte[property.length];
        for (int i = 0; i < property.length; i++) {
            bytes[i] = (byte) property[i];
        }
        return encrypt(bytes);
    }

    private static String encrypt(String property) throws GeneralSecurityException {
        return encrypt(property.getBytes());
    }

    private static String decrypt(String property) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return new String(pbeCipher.doFinal(Base64.getDecoder().decode(property)));
    }

    private static void create_EncryptedFile(String fileName, Map<String, String> commonAttributes, Map<String, char[]> secureAttributes, int layers) throws GeneralSecurityException, IOException {
        StringBuilder sb = new StringBuilder();
        for (String k : commonAttributes.keySet()) {
            sb.append(k).append(": ").append(commonAttributes.get