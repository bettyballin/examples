import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

import java.security.SecureRandom;
import java.security.Security;

public class McElieceKeyGen {
    public static void main(String[] args) throws Exception {
        // Add BouncyCastlePQCProvider
        Security.addProvider(new BouncyCastlePQCProvider());

        // Define the key generation parameters
        SecureRandom random = new SecureRandom();
        McElieceKeyGenerationParameters keyGenParams = new McElieceKeyGenerationParameters(random, new McElieceKeyGenerationParameters.McElieceParameters());

        // Generate a new key pair
        McElieceKeyPairGenerator generator = new McElieceKeyPairGenerator();
        generator.init(keyGenParams);
        AsymmetricCipherKeyPair keyPair = generator.generateKeyPair();

        // Extract the public and private keys
        McEliecePublicKeyParameters publicKey = (McEliecePublicKeyParameters) keyPair.getPublic();
        McEliecePrivateKeyParameters privateKey = (McEliecePrivateKeyParameters) keyPair.getPrivate();

        System.out.println("Public Key: " + publicKey);
        System.out.println("Private Key: " + privateKey);
    }
}