import org.bouncycastle.crypto.params.Argon2Parameters;
import com.github.javadev.argon2.Argon2;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String argonString = "$argon2id$v=19$m=65536,t=10,p=1$BeHo0SdgM6vt5risz+yuLg$dOBFlfeoPPGCk/OLCGJ9sRhyPl0zMqMAUZvkltFWxnA";
        Argon2 argon2 = Argon2.createFromEncoded(argonString);
        Argon2Parameters params = argon2.getParameters();

        System.out.println("Salt: " + Base64.getEncoder().encodeToString(params.getSalt()));
    }
}