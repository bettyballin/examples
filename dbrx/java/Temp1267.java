import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.servlet.ServletWebRequest;
import org.apache.wicket.request.http.WebRequest;
import org.apache.wicket.request.http.WebResponse;

public class Temp1267 extends WebApplication {

    public static void main(String[] args) {
        System.out.println("Application started.");
    }

    @Override
    public Class<? extends org.apache.wicket.Page> getHomePage() {
        return null; // Implement your home page here
    }

    @Override
    protected WebResponse newWebResponse(final WebRequest request, final WebResponse response) {
        if (request instanceof ServletWebRequest && ((ServletWebRequest) request).isMultipart()) {
            return super.newWebResponse(request, response);
        }

        return new MultipartFormWebApplication(super.newWebResponse(request, response));
    }
}

class MultipartFormWebApplication extends WebResponse {
    private final WebResponse response;

    public MultipartFormWebApplication(WebResponse response) {
        super(); // Add this
        this.response = response;
    }

    // Rest of your code...
}