import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class LinkedInOAuth2ResponseModifier implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body,
            ClientHttpRequestExecution execution) throws IOException {

        // Execute the HTTP request and get response
        ClientHttpResponse originalResponse = execution.execute(request, body);

        if (originalResponse.getStatusCode() == HttpStatus.OK &&
                "https://www.linkedin.com/oauth/v2/accessToken".equalsIgnoreCase(
                    request.getURI().toString())) {

            // Create a new response with the modified body
            return createModifiedResponse(originalResponse);
        }

        return originalResponse;
    }

    private ClientHttpResponse createModifiedResponse(ClientHttpResponse original) throws IOException {

        HttpHeaders headers = new HttpHeaders();

        // Copy all existing response headers
        for (String headerName : original.getHeaders().keySet()) {
            if (!headerName.equalsIgnoreCase("Content-Length")) {
                headers.put(
                    headerName,
                    Arrays.asList(original.getHeaders().getFirst(headerName))
                );
            }
        }

        // Read original body and modify it as needed
        byte[] originalBody = original.getBody().readAllBytes();
        String modifiedBodyString = new String(originalBody) + " modified";
        byte[] modifiedBody = modifiedBodyString.getBytes();

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return original.getStatusCode();
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return original.getRawStatusCode();
            }

            @Override
            public String getStatusText() throws IOException {
                return original.getStatusText();
            }

            @Override
            public void close() {
                original.close();
            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(modifiedBody);
            }

            @Override
            public HttpHeaders getHeaders() {
                return headers;
            }
        };
    }
}