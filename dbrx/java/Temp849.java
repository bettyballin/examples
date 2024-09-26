import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.Merlin;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.engine.WSSConfig;
import org.apache.wss4j.dom.message.WSSecEncrypt;

import java.util.Properties;

public class Temp849 {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.setProperty("org.apache.wss4j.crypto.merlin.keystore.file", "path/to/keystore.jks");
            properties.setProperty("org.apache.wss4j.crypto.merlin.keystore.password", "password");
            Crypto crypto = new Merlin(properties);

            WSSConfig.init();

            WSSecEncrypt encryptBuilder = new WSSecEncrypt(WSSConfig.getNewInstance());
            encryptBuilder.setUserInfo("username", "password");
            encryptBuilder.setSymmetricEncAlgorithm(WSConstants.AES_256);
            encryptBuilder.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE);
            encryptBuilder.setUseThisCert(crypto.getCertificates("alias")[0]);

            // Continue with encryption process...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}