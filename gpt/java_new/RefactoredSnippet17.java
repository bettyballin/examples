import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;

public class RefactoredSnippet17 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public PrivateKey generatePrivateKey() throws Exception {
        ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("prime256v1");
        KeyFactory kf = KeyFactory.getInstance("ECDSA", BouncyCastleProvider.PROVIDER_NAME);
        ECPrivateKeySpec privateKeySpec = new ECPrivateKeySpec(spec.getN(), spec);
        ECPrivateKey privateKey = (ECPrivateKey) kf.generatePrivate(privateKeySpec);
        return privateKey;
    }
}