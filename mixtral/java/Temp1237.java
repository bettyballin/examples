import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2ParametersGenerator;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import java.security.SecureRandom;
import java.security.Security;

public class Temp1237 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastlePQCProvider());

        McElieceCCA2ParametersGenerator gen = new McElieceCCA2ParametersGenerator();
        SecureRandom random = new SecureRandom();
        gen.init(new McElieceCCA2KeyGenerationParameters(random, new McElieceCCA2Parameters()));

        AsymmetricCipherKeyPair keyPair = gen.generateKeyPair();
        
        System.out.println("Key pair generated successfully.");
    }
}