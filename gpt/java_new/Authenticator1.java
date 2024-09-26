import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class Authenticator1 {
  
  private static final int ITERATION_COUNT = 65536;
  private static final int KEY_LENGTH = 128;

  // ... other methods ...

  public static boolean check(byte[] dbHash, String password, byte[] salt) {
    try {
      // Generate the hash from the input password and salt
      byte[] inputHash = generateHash(password, salt);

      // Compare the hash from the database with the generated hash
      return Arrays.equals(dbHash, inputHash);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      // Handle exceptions properly; depending on your application's needs,
      // you might want to log this exception or handle it in another way.
      e.printStackTrace();
      return false;
    }
  }
  
  private static byte[] generateHash(String password, byte[] salt) 
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    return skf.generateSecret(spec).getEncoded();
  }
}