import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Arrays;

public class Temp799 {

    public static void main(String[] args) {
        Temp799 temp = new Temp799();
        String rawPassword = "password";
        String encodedPassword = temp.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
        System.out.println("Password matches: " + temp.matches(rawPassword, encodedPassword));
    }

    private SaltGenerator saltGenerator = new SaltGenerator();

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        byte[] digested = decode(encodedPassword);
        byte[] salt = subArray(digested, 0, saltGenerator.getKeyLength());
        return Arrays.equals(digested, digest(rawPassword, salt));
    }

    public String encode(CharSequence rawPassword) {
        byte[] salt = saltGenerator.generateSalt();
        byte[] digested = digest(rawPassword, salt);
        return encode(digested);
    }

    private byte[] digest(CharSequence rawPassword, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            md.update(rawPassword.toString().getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] decode(String encodedPassword) {
        return Base64.getDecoder().decode(encodedPassword);
    }

    private String encode(byte[] digested) {
        return Base64.getEncoder().encodeToString(digested);
    }

    private byte[] subArray(byte[] array, int start, int length) {
        byte[] subArray = new byte[length];
        System.arraycopy(array, start, subArray, 0, length);
        return subArray;
    }

    class SaltGenerator {
        private static final int KEY_LENGTH = 16;

        public byte[] generateSalt() {
            byte[] salt = new byte[KEY_LENGTH];
            for (int i = 0; i < KEY_LENGTH; i++) {
                salt[i] = (byte) (Math.random() * 256 - 128);
            }
            return salt;
        }

        public int getKeyLength() {
            return KEY_LENGTH;
        }
    }
}