import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.engine.WSSConfig;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecUsernameToken;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import java.io.IOException;

public class Temp399 {
    public static void main(String[] args) {
        try {
            // Initialize WSS4J configuration
            WSSConfig.init();

            // Create a SOAP message
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            // Create a security header and insert it into the SOAP message
            WSSecHeader secHeader = new WSSecHeader();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            secHeader.insertSecurityHeader(soapPart);

            // Create a UsernameToken and add it to the SOAP message
            WSSecUsernameToken usernameToken = new WSSecUsernameToken();
            usernameToken.setPasswordType(WSConstants.PASSWORD_TEXT);
            usernameToken.setUserInfo("username", "password");
            usernameToken.build(soapPart, secHeader);

            // Print the SOAP message
            soapMessage.writeTo(System.out);
        } catch (SOAPException | IOException e) {
            e.printStackTrace();
        }
    }
}