import java.security.*;

public class Secret {
    public void generateKeys() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            PublicKey pubkey = kp.getPublic();
            PrivateKey privkey = kp.getPrivate();
            System.out.println(java.util.Base64.getEncoder().encodeToString(privkey.getEncoded()) + "---" + java.util.Base64.getEncoder().encodeToString(pubkey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello!");
        Secret sec = new Secret();
        sec.generateKeys();
    }
}