import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Demo {

    public static final String PRIVATE_KEY = "/home/user/private.der";
    public static final String PUBLIC_KEY = "/home/user/public.der";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        //get the private key
        byte[] keyBytes = Files.readAllBytes(Paths.get(PRIVATE_KEY));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(spec);
        System.out.println("Exponent :" + privKey.getPrivateExponent());
        System.out.println("Modulus :" + privKey.getModulus());

        //get the public key
        byte[] keyBytes1 = Files.readAllBytes(Paths.get(PUBLIC_KEY));
        X509EncodedKeySpec spec1 = new X509EncodedKeySpec(keyBytes1);
        KeyFactory kf1 = KeyFactory.getInstance("RSA");
        RSAPublicKey pubKey = (RSAPublicKey) kf1.generatePublic(spec1);
        System.out.println("Exponent :" + pubKey.getPublicExponent());
        System.out.println("Modulus :" + pubKey.getModulus());
    }
}