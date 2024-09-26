import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyConverter;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.RSAKeyGenParameterSpec;

public class Temp1908 {
    public static void main(String[] args) throws Exception {
        // Generate a sample RSA key pair
        KeyPair keyPair = generateRSAKeyPair();

        JcaPGPContentSignerBuilder signerBuilder = new JcaPGPContentSignerBuilder(
                PGPSignature.DEFAULT_CERTIFICATION, HashAlgorithmTags.SHA256);

        // Convert the AsymmetricCipherKeyPair to OpenPGPPublicKey and OpenPGPPrivateKey
        JcaPGPKeyConverter converter = new JcaPGPKeyConverter();

        PGPPublicKey openPublicKey = converter.getPGPPublicKey(PGPPublicKey.RSA_GENERAL, keyPair.getPublic(), new java.util.Date());
        PGPPrivateKey openPrivateKey = converter.getPGPPrivateKey(openPublicKey, keyPair.getPrivate());

        // Create the PGP Key pair
        PGPKeyRingGenerator keyRingGen = new PGPKeyRingGenerator(
                PGPSignature.POSITIVE_CERTIFICATION,
                openPublicKey,
                "umaimaahmed1@gmail.com",
                null,
                null,
                null,
                signerBuilder,
                null
        );

        // Add the private key to the KeyRing
        keyRingGen.addSubKey(openPublicKey, openPrivateKey);

        PGPPublicKey publicKey = keyRingGen.generatePublicKeyRing().getPublicKeys().next();
        PGPSecretKey secretKey = keyRingGen.generateSecretKeyRing().getSecretKeys().next();

        // Output keys for verification
        System.out.println("Public Key ID: " + publicKey.getKeyID());
        System.out.println("Secret Key ID: " + secretKey.getKeyID());
    }

    private static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(new RSAKeyGenParameterSpec(2048, RSAKeyGenParameterSpec.F4));
        return keyPairGenerator.generateKeyPair();
    }
}