import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class DiffieHellmanExample {
    public static void main(String[] args) throws Exception {
        // Generate a key pair for Alice
        KeyPairGenerator aliceKpairGen = KeyPairGenerator.getInstance("DH");
        aliceKpairGen.initialize(2048);
        KeyPair aliceKpair = aliceKpairGen.generateKeyPair();

        // Generate a key pair for Bob
        KeyPairGenerator bobKpairGen = KeyPairGenerator.getInstance("DH");
        bobKpairGen.initialize(2048);
        KeyPair bobKpair = bobKpairGen.generateKeyPair();

        // Alice creates and initializes her KeyAgreement object
        KeyAgreement aliceKeyAgree = KeyAgreement.getInstance("DH");
        aliceKeyAgree.init(aliceKpair.getPrivate());

        // Bob creates and initializes his KeyAgreement object
        KeyAgreement bobKeyAgree = KeyAgreement.getInstance("DH");
        bobKeyAgree.init(bobKpair.getPrivate());

        // Alice encodes her public key and sends it over to Bob
        byte[] alicePubKeyEnc = aliceKpair.getPublic().getEncoded();

        // Bob encodes his public key and sends it over to Alice
        byte[] bobPubKeyEnc = bobKpair.getPublic().getEncoded();

        // Bob uses Alice's public key to initialize his KeyAgreement object
        KeyFactory bobKeyFac = KeyFactory.getInstance("DH");
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(alicePubKeyEnc);
        PublicKey alicePubKey = bobKeyFac.generatePublic(x509KeySpec);
        bobKeyAgree.doPhase(alicePubKey, true);

        // Alice uses Bob's public key to initialize her KeyAgreement object
        KeyFactory aliceKeyFac = KeyFactory.getInstance("DH");
        x509KeySpec = new X509EncodedKeySpec(bobPubKeyEnc);
        PublicKey bobPubKey = aliceKeyFac.generatePublic(x509KeySpec);
        aliceKeyAgree.doPhase(bobPubKey, true);

        // Both parties generate the shared secret
        byte[] aliceSharedSecret = aliceKeyAgree.generateSecret();
        byte[] bobSharedSecret = bobKeyAgree.generateSecret();

        // Compare the shared secrets
        System.out.println("Alice's shared secret: " + bytesToHex(aliceSharedSecret));
        System.out.println("Bob's shared secret: " + bytesToHex(bobSharedSecret));
        System.out.println("Shared secrets are equal: " + MessageDigest.isEqual(aliceSharedSecret, bobSharedSecret));
    }
    
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}