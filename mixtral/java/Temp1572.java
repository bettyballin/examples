import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.SecureRandom;
import sun.security.pkcs11.SunPKCS11;

public class Temp1572 {
    public static void main(String[] args) throws Exception {
        String configName = "/tmp/pkcs11.cfg";
        Provider p = new SunPKCS11(configName);
        Security.addProvider(p);

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "SunPKCS11-SoftHSM2");
        kpg.initialize(2048, SecureRandom.getInstanceStrong());

        KeyPair keyPair = kpg.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        
        // You can now use the privateKey object as needed
        System.out.println("Private Key: " + privateKey);
    }
}