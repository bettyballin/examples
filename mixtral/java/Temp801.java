import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.interfaces.ECPrivateKey;

public class Main {
    public static void main(String[] args) throws Exception {
        // Add instance of provider class
        Security.addProvider(new BouncyCastleProvider());

        // Initializing parameter specs secp256r1/prime192v1
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("prime192v1");

        // Key pair generator to generate public and private key
        KeyPairGenerator generator = KeyPairGenerator.getInstance("ECDH", new BouncyCastleProvider());

        // Initialize the key pair generator
        generator.initialize(ecSpec);

        // Generate a keypair
        KeyPair keyPair = generator.generateKeyPair();

        // Derive shared secret using ECDHBasicAgreement
        KDF2BytesGenerator kdf = new KDF2BytesGenerator(new SHA1Digest());
        kdf.init(new HMac(new SHA1Digest()), ((ECPrivateKey) keyPair.getPrivate()).getD().toByteArray());
        byte[] sharedSecret = new byte[32];
        kdf.generateBytes(sharedSecret, 0, sharedSecret.length);

        // Generate AES-GCM parameters
        AESFastEngine aesEngine = new AESFastEngine();
        byte[] nonce = new byte[12]; // typically, a nonce is 12 bytes in GCM mode
        AEADParameters params = new AEADParameters(new KeyParameter(sharedSecret), 128, nonce);

        GCMBlockCipher gcmBlockCipher = new GCMBlockCipher(aesEngine);
        gcmBlockCipher.init(true, params);

        // Example usage of the cipher (encryption/decryption) can be added here
    }
}