import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncoderExample {
    public static void main(String[] args) throws Exception {

        StandardPasswordEncoder encoder = new StandardPasswordEncoder("secret");
        String result = encoder.encode("myPassword");

        System.out.println(result);

        String salt = result.substring(0, 16);
        String hash = result.substring(16);

        byte[] decodedSaltBytes = Hex.decode(salt);
        byte[] decodedHashBytes = Hex.decode(hash);

        // Use the salt and hash bytes to compare with user input
    }
}