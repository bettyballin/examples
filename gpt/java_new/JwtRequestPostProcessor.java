import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.mock.web.MockHttpServletRequest;

public class JwtRequestPostProcessor implements RequestPostProcessor {

    private final String tokenValue;

    public JwtRequestPostProcessor(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    @Override
    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
        request.addHeader("Authorization", "Bearer " + tokenValue);
        return request;
    }

    // Static helper method to easily apply this post processor
    public static JwtRequestPostProcessor bearerToken(String token) {
        return new JwtRequestPostProcessor(token);
    }
}