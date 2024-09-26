import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Temp1119 {
    public static void main(String[] args) {
        String soapXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://example.org/webservices/\"><soapenv:Header/><soapenv:Body><web:MyRequest><web:Value>123</web:Value></web:MyRequest></soapenv:Body></soapenv:Envelope>";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(soapXml.getBytes());
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message = messageFactory.createMessage(null, inputStream);
            System.out.println("SOAP Message created successfully.");
        } catch (SOAPException | IOException e) {
            e.printStackTrace();
        }
    }
}