import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        String publicKeyString = "AAAAB3NzaC1yc2EAAAADAQABAAABAQC9+oZzGyvXbShKj6sJkV62YQPc8wTlLvOeICrBpzb/0hDxu5RdMg4UXn7PEL3iS1U2ADqfPeyCQa9+oZzGyvXbShKj6sJkV62YQPc8wTlLvOeICrBpzb/0hDxu5RdMg4UXn7PEL3iS1U2ADqfPeyCQa9+oZzGyvXbShKj6sJkV62YQPc8wTlLvOeICrBpzb/0hDxu5RdMg4UXn7PEL3iS1U2ADqfPeyCQa9+oZzGyvXbShKj6sJkV62YQPc8wTlLvOeICrBpzb/0hDxu5RdMg4UXn7PEL3iS1U2ADqfPeyCQa9+oZzGyvXbShKj6sJkV62YQPc8wTlLvOeICrBpzb/0hDxu5RdMg4UXn7PEL3iS1U2ADqfPeyCQa9+oZzGyvXbShKj6sJkV62YQPc8";

        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        System.out.println(publicKey);
    }
}