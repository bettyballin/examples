import org.apache.rampart.RampartMessageData;
import org.apache.rampart.handler.WSSHandlerConstants;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecUsernameToken;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.ws.security.WSPasswordCallback;
import org.apache.ws.security.WSPasswordCallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class WSSecurityHeaderExample {
    public static void main(String[] args) {
        try {
            // Create a ServiceClient instance
            ConfigurationContext configContext = ConfigurationContextFactory.createConfigurationContextFromFileSystem(null, null);
            ServiceClient serviceClient = new ServiceClient(configContext, null);
            
            // Set the endpoint URL
            serviceClient.getOptions().setTo(new EndpointReference("http://localhost:8080/axis2/services/MyService"));

            // Create a security header
            WSSecHeader secHeader = new WSSecHeader();
            secHeader.insertSecurityHeader(serviceClient.getAxisService().getAxisConfiguration());

            // Create a username token
            WSSecUsernameToken usernameToken = new WSSecUsernameToken();
            usernameToken.setPasswordType(WSConstants.PW_TEXT);
            usernameToken.setUserInfo("username", "password");

            // Build the username token and add it to the security header
            usernameToken.build(serviceClient.getAxisService().getAxisConfiguration(), secHeader);

            // Set the security options
            Options options = serviceClient.getOptions();
            options.setProperty(WSSHandlerConstants.ACTION, WSSHandlerConstants.USERNAME_TOKEN);
            options.setProperty(WSSHandlerConstants.USER, "username");
            options.setProperty(WSSHandlerConstants.PW_CALLBACK_REF, new PWCallback());
            options.setProperty(RampartMessageData.KEY_IDENTIFIER, "DirectReference");
            serviceClient.setOptions(options);

            // Call the service
            serviceClient.sendReceive(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PWCallback implements WSPasswordCallbackHandler {
    public void handle(WSPasswordCallback[] callbacks) throws java.io.IOException, UnsupportedCallbackException {
        for (WSPasswordCallback callback : callbacks) {
            if (callback.getUsage() == WSPasswordCallback.USERNAME_TOKEN) {
                callback.setPassword("password");
            }
        }
    }
}