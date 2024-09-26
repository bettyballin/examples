import org.apache.wss4j.common.WSSecurityEngine;
import org.apache.wss4j.common.WSSConfig;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.common.ext.WSSecurityExtension;
import org.apache.wss4j.dom.WSDocInfo;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.dom.processor.Processor;
import org.apache.wss4j.dom.engine.WSSecurityEngineResult;
import org.apache.wss4j.dom.message.token.UsernameToken;
import org.w3c.dom.Element;
import javax.security.auth.callback.CallbackHandler;
import java.util.Vector;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.encryption.XMLCipher;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.utils.EncryptionConstants;
import org.apache.xml.security.utils.SignatureConstants;
import org.apache.wss4j.common.crypto.Crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RefactoredSnippet6 {
    private static final Logger logger = LoggerFactory.getLogger(RefactoredSnippet6.class);

    public static void main(String[] args) {
        WSSecurityEngine secEngine = new WSSecurityEngine();
        WSSConfig wsConfig = WSSConfig.getNewInstance();
        wsConfig.setProcessor(UsernameToken.TOKEN, new CustomProcessor());
        secEngine.setWssConfig(wsConfig);
    }

    private static class CustomProcessor implements Processor {
        @Override
        public void handleToken(Element arg0, Crypto arg1, Crypto arg2, CallbackHandler arg3, WSDocInfo arg4, Vector<WSSecurityEngineResult> arg5, WSSConfig arg6) throws WSSecurityException {
            // skip the token processing
            logger.debug("Skipping processing of the username token");
        }

        @Override
        public String getId() {
            return null;
        }
    }
}