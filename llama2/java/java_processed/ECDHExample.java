import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.ECGenParameterSpec;
import java.security.KeyAgreement;
import java.security.PublicKey;

import org.apache.commons.codec.binary.Base64;

public class ECDHExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, Exception {
        // Generate a key pair for Alice
        KeyPairGenerator aliceKeyGen = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1");
        aliceKeyGen.initialize(ecSpec);
        KeyPair aliceKeyPair = aliceKeyGen.generateKeyPair();

        // Generate a key pair for Bob
        KeyPairGenerator bobKeyGen = KeyPairGenerator.getInstance("EC");
        bobKeyGen.initialize(ecSpec);
        KeyPair bobKeyPair = bobKeyGen.generateKeyPair();

        // Perform key agreement
        KeyAgreement aliceKeyAgree = KeyAgreement.getInstance("ECDH");
        aliceKeyAgree.init(aliceKeyPair.getPrivate());
        aliceKeyAgree.doPhase(bobKeyPair.getPublic(), true);
        byte[] aliceSharedSecret = aliceKeyAgree.generateSecret();

        KeyAgreement bobKeyAgree = KeyAgreement.getInstance("ECDH");
        bobKeyAgree.init(bobKeyPair.getPrivate());
        bobKeyAgree.doPhase(aliceKeyPair.getPublic(), true);
        byte[] bobSharedSecret = bobKeyAgree.generateSecret();

        // Print the shared secrets
        System.out.println("Alice's Shared Secret: " + Base64.encodeBase64String(aliceSharedSecret));
        System.out.println("Bob's Shared Secret: " + Base64.encodeBase64String(bobSharedSecret));
    }
}