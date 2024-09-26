import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.security.interfaces.DSAPublicKey;
import java.util.Base64;

public class Temp1841 {
    public static void main(String[] args) {
        String publicPEM = "-----BEGIN PUBLIC KEY-----\n" +
                           "MIIBtjCCASsGByqGSM44BAEwggEeAoGBANpJNNPFXl8R0D5V5NxU7EhI4JvD7VGH\n" +
                           "L6Jm3wV8F9R7uK5v6Tn3q43H6zFQ2D8mZ7ZlE4tQ1aV9yD/6N0cG7PFS6HbS5R8L\n" +
                           "3yMZqQ1i6D6pB2uUkXzESMT0DlgxXWg+3yH7tYZhA1lO2yrLQG+3uQ98C4h0I6qO\n" +
                           "9W8ES9v0k1jG0+e0wX5kPj9dM4WRAhUAk8QK2fP3PZQW9pgwzD0idyoWZqVjGBg=\n" +
                           "-----END PUBLIC KEY-----";

        publicPEM = publicPEM.replace("-----BEGIN PUBLIC KEY-----\n", "");
        publicPEM = publicPEM.replace("-----END PUBLIC KEY-----", "");
        publicPEM = publicPEM.replace("\n", "");

        byte[] encodedPublicKey = Base64.getDecoder().decode(publicPEM);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedPublicKey);

        try {
            DSAPublicKey dsaPubKey = (DSAPublicKey) KeyFactory.getInstance("DSA").generatePublic(keySpec);
            System.out.println("DSA Public Key: " + dsaPubKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}