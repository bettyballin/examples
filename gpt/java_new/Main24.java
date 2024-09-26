import javax.crypto.KeyGenerator;

public class Main24 {
    public static void main(String[] args) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // You need to have the Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy installed for this to work
            // Use the generated key for your purposes
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}