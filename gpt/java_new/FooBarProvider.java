import javax.crypto.Cipher;
import java.security.Provider;
import java.security.Security;

public class FooBarProvider extends Provider {
    public FooBarProvider() {
        super("FooBar", 1.0, "Provider for AES/CBC/PKCS5Padding");
        put("Cipher.AES", "foo.bar.AESCipher");
        put("Cipher.AES/CBC/PKCS5Padding", "foo.bar.AESCipher");
    }

    public static void main(String[] args) throws Exception {
        Security.insertProviderAt(new FooBarProvider(), 1);
        Cipher cip = Cipher.getInstance("AES/CBC/PKCS5Padding");
        System.out.println(cip.getProvider().getInfo());
    }
}