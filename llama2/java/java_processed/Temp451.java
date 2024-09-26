import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.ECNamedCurveTable;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class Temp451 {
    private Signature signer;
    private PrivateKey privKey;

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        Temp451 temp = new Temp451();
        temp.init();
        byte[] data = "Hello, World!".getBytes();
        byte[] signature = temp.sign(data);
        System.out.println("Signature length is " + signature.length);
    }

    public void init() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "BC");
        keyGen.initialize(new ECGenParameterSpec("secp521r1"));
        KeyPair keyPair = keyGen.generateKeyPair();
        privKey = keyPair.getPrivate();

        signer = Signature.getInstance("SHA512withECDSA", "BC");
        signer.initSign(privKey);
    }

    public byte[] sign(byte[] bytes) throws Exception {
        signer.update(bytes);
        byte[] signature = signer.sign();
        return signature;
    }
}