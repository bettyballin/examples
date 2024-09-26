import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Temp319 {
    public static void main(String[] args) {
        String inputPassword = "yourPassword";
        byte[] saltFromDatabase = "yourSalt".getBytes(); // Replace with actual salt bytes

        // Compute hash
        SimpleHash hash = new SimpleHash(
                Sha256Hash.ALGORITHM_NAME,
                inputPassword,
                ByteSource.Util.bytes(saltFromDatabase),
                1024
        );
        
        String hashedPassword = "storedHashedPassword"; // Replace with actual stored hashed password
        boolean isMatched = hashedPassword.equalsIgnoreCase(hash.toHex());

        // Output the result
        System.out.println("Password match: " + isMatched);
    }
}