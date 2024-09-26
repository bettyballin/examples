import java.security.*;

class Secret {
    void secret() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);

        try {
            KeyPair kp = kpg.generateKeyPair();

            PublicKey pubkey = kp.getPublic();
            PrivateKey privkey = kp.getPrivate();

            System.out.println("Public Key: " + pubkey);
            System.out.println("Private Key: " + privkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Secret secret = new Secret();
            secret.secret();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}