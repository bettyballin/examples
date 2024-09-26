import java.util.Vector;
import javax.security.auth.callback.CallbackHandler;
import org.apache.ws.security.WSDocInfo;
import org.apache.ws.security.WSSecurityEngine;
import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.apache.ws.security.message.token.UsernameToken;
import org.apache.ws.security.processor.Processor;
import org.apache.ws.security.util.WSSecurityUtil;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSPasswordCallback;
import org.apache.ws.security.handler.WSHandler;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecUsernameToken;
import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.components.crypto.CryptoFactory;
import org.apache.ws.security.WSSConfig;
import org.w3c.dom.Element;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Temp1741 {
    private static final Log logger = LogFactory.getLog(Temp1741.class);

    public static void main(String[] args) {
        WSSecurityEngine secEngine = new WSSecurityEngine();
        WSSConfig wsConfig = WSSConfig.newInstance();
        wsConfig.setProcessor(UsernameToken.TOKEN, new Processor() {

            @Override
            public void handleToken(Element arg0, Crypto arg1, Crypto arg2, CallbackHandler arg3, WSDocInfo arg4, Vector arg5, WSSConfig arg6)
                    throws WSSecurityException {
                // skip the token processing
                logger.debug("Skipping processing of the username token");
            }

            @Override
            public String getId() {
                return null;
            }
        });
        secEngine.setWssConfig(wsConfig);
    }
}