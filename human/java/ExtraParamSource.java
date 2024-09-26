import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationDetailsSource;

class ExtraParamSource implements AuthenticationDetailsSource<HttpServletRequest, ExtraParam> {
    @Override
    public ExtraParam buildDetails(HttpServletRequest context) {
        return new ExtraParam(context);
    }
}

class ExtraParam {
    private HttpServletRequest request;

    public ExtraParam(HttpServletRequest request) {
        this.request = request;
    }

    // Additional methods can be added here
}

// Example usage
class Main {
    public static void main(String[] args) {
        // Assuming a request object is available
        HttpServletRequest request = null; // Placeholder, should be an actual request object
        ExtraParamSource source = new ExtraParamSource();
        ExtraParam extraParam = source.buildDetails(request);
        
        // Use the extraParam object as needed
    }
}