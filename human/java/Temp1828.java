import com.google.common.hash.Hashing;
import com.google.common.base.Charsets;

public class Temp1828 {
    public static void main(String[] args) {
        String secretKey = "your_secret_key_here"; // replace with your actual secret key
        String hash = Hashing.sha1().hashString(secretKey, Charsets.UTF_8).toString();
        System.out.println(hash);
    }
}