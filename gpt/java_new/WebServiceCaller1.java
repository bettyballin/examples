import javax.xml.ws.soap.SOAPFaultException;

public class WebServiceCaller1 {
    public static void main(String[] args) {
        try {
            // ... your code to call the web service
        } catch (SOAPFaultException e) {
            System.err.println("SOAP Fault: " + e.getFault().getFaultString());
            e.printStackTrace();
        }
    }
}