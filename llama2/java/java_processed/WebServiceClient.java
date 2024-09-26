import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;

public class WebServiceClient {

    public static void main(String[] args) {
        WebServiceTemplate webService = new WebServiceTemplate();
        webService.setCheckConnectionForError(false);
        
        // Example SOAP envelope as a string
        String soapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<example:MyRequest xmlns:example=\"http://example.com\">" +
                "<example:RequestData>SomeData</example:RequestData>" +
                "</example:MyRequest>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
        
        Source source = new StringSource(soapEnvelope);
        
        try {
            StringResult result = new StringResult();
            webService.sendSourceAndReceiveToResult(
                    "http://example.com/webservice-endpoint", source, result);
            System.out.println("Response received: " + result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Define MyResponse class, but for the above example, you don't need it
    // You should use StringResult instead
    // public static class MyResponse {
    //     // Define response fields and methods
    // }
}