import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JWSObject;
import org.junit.Assert;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // Mock result.getResponse().getContentAsString() as needed
        String mockResponse = "{\"idToken\":\"eyJhbGciOiJIUzI1NiJ9.eyJub25jZSI6InJhbmRvbV9zdHJpbmcifQ.s8S5a2Jq2jv7g1hX8Cw5p8P3zR7sJ5vK4A9aQ0l7Z8g\"}";
        MockResult result = new MockResult(mockResponse);

        String token = mapper.readValue(result.getResponse().getContentAsString(), TokenResponseDTO.class).getIdToken();
        JWSObject jwsObject = JWSObject.parse(token);
        JWTPayloadDTO payload = mapper.readValue(jwsObject.getPayload().toString(), JWTPayloadDTO.class);

        Assert.assertEquals("random_string", payload.getNonce());
        // other checks
    }
}

class MockResult {
    private final String content;

    public MockResult(String content) {
        this.content = content;
    }

    public MockResponse getResponse() {
        return new MockResponse(content);
    }
}

class MockResponse {
    private final String content;

    public MockResponse(String content) {
        this.content = content;
    }

    public String getContentAsString() {
        return content;
    }
}

class TokenResponseDTO {
    private String idToken;

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}

class JWTPayloadDTO {
    private String nonce;

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}