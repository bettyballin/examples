import com.macasaet.fernet.Key;
import com.macasaet.fernet.Token;

public class FernetExample {

    public static void main(String[] args) {
        final String keyString = "3t55GSk5qDRUif_v4MNQGLrkzaWv-TFOSJpqQWj9KKg=";
        final Key key = new Key(keyString);

        String message = "Hello, World!";
        Token token = Token.generate(key, message);

        String payload = token.validateAndDecrypt(key, (timestamp, string) -> string);

        System.out.println(payload);
    }
}