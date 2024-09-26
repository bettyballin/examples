import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;
import org.bouncycastle.pqc.jcajce.spec.McElieceKeyGenParameterSpec;
import org.bouncycastle.pqc.jcajce.spec.McEliecePublicKeySpec;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Security;

public class Temp1248 {
    public static void main(String[] args) {

        // key generation
        Security.addProvider(new BouncyCastlePQCProvider());
        KeyPairGenerator keygen = null;
        try {
            keygen = KeyPairGenerator.getInstance("McEliece", "BCPQC");
        } catch (Exception e) {
            System.out.println("Error: KeyPairGenerator instance failed. " + e.getMessage());
            return;
        }

        McElieceKeyGenParameterSpec bcSpec = new McElieceKeyGenParameterSpec(2048, 1, 50);

        try {
            keygen.initialize(bcSpec);
        } catch (InvalidAlgorithmParameterException e) {
            System.out.println("Error: Initialize failed. " + e.getMessage());
            return;
        }

        PublicKey pub = keygen.generateKeyPair().getPublic();
        McEliecePublicKeySpec spec = (McEliecePublicKeySpec) pub;
        McEliecePublicKeyParameters keyParameters = new McEliecePublicKeyParameters(
                spec.getN(),
                spec.getT(),
                spec.getG()
        );

        // serialization
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(keyParameters);
            System.out.println("OK");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}