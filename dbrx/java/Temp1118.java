import org.apache.ws.security.WSConstants;
import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.components.crypto.CryptoFactory;
import org.apache.ws.security.message.WSSecSignature;

public class Temp1118 {
    public static void main(String[] args) throws Exception {
        Crypto crypto = CryptoFactory.getInstance("crypto.properties");
        WSSecSignature signatureBuilder = new WSSecSignature();
        signatureBuilder.setUserInfo("myalias", "mypassword");
        signatureBuilder.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE);
    }
}