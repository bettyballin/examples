import javax.annotation.security.RolesAllowed;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class YourWebService {
    @WebMethod
    @RolesAllowed("ROLE_NAME_1")
    public String yourSecureMethod() {
        // Implement your method logic here
        return "Secure Method Accessed";
    }

    public static void main(String[] args) {
        // Example to start the web service
        YourWebService service = new YourWebService();
        System.out.println(service.yourSecureMethod());
    }
}

becomes:


import javax.annotation.security.RolesAllowed;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class YourWebService {
    @WebMethod
    @RolesAllowed("ROLE_NAME_1")
    public String yourSecureMethod() {
        // Implement your method logic here
        return "Secure Method Accessed";
    }

    public static void main(String[] args) {
        // Example to start the web service
        Endpoint.publish("http://localhost:8080/YourWebService", new YourWebService());
        YourWebService service = new YourWebService();
        System.out.println(service.yourSecureMethod());
    }
}