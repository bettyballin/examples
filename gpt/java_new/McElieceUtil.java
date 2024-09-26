import de.flexiprovider.api.keys.KeyFactory;
import de.flexiprovider.api.keys.KeySpec;
import de.flexiprovider.core.FlexiCoreProvider;
import de.flexiprovider.pqc.FlexiPQCProvider;
import de.flexiprovider.pqc.ecc.mceliece.McEliecePrivateKeySpec;
import de.flexiprovider.pqc.ecc.mceliece.McEliecePublicKeySpec;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

public class McElieceUtil {

    static {
        Security.addProvider(new FlexiCoreProvider());
        Security.addProvider(new FlexiPQCProvider());
    }

    public KeyPair generateKeyPair() throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("McEliece", "FlexiPQC");
        KeySpec publicKeySpec = new McEliecePublicKeySpec("McEliece", 11, 50);
        KeySpec privateKeySpec = new McEliecePrivateKeySpec("McEliece", 11, 50, new byte[]{0}, new byte[]{0}, new byte[]{0}, new int[]{0}, new int[]{0}, new byte[][]{new byte[]{0}});
        
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
        
        return new KeyPair(publicKey, privateKey);
    }
}