import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;

public class SoapMessageCreator {
  public static void main(String[] args) {
    try {
      // Create a SOAPMessage
      MessageFactory messageFactory = MessageFactory.newInstance();
      SOAPMessage soapMessage = messageFactory.createMessage();
      SOAPPart soapPart = soapMessage.getSOAPPart();

      // Obtain the SOAPEnvelope and header from the SOAPPart
      SOAPEnvelope envelope = soapPart.getEnvelope();
      SOAPHeader header = envelope.getHeader();

      // Check if header is null and add a header if needed
      if (header == null) {
        header = envelope.addHeader();
      }

      // Save changes
      soapMessage.saveChanges();

      // Print the message
      soapMessage.writeTo(System.out);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}