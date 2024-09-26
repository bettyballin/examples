import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jwt.JWSObject;
import org.junit.Assert;

// ... other imports

public class SomeTestClass3 {

    // Assuming the existence of TokenResponseDTO and JWTPayloadDTO classes
    // with the appropriate getters and setters.

    // ... other methods and class members

    public void someTestMethod() throws Exception {
        // Assuming 'result' is a valid MockHttpServletResponse and 'mapper' is an ObjectMapper instance

        ObjectMapper mapper = new ObjectMapper(); // or obtained from elsewhere
        // MockHttpServletResponse result = ...; // Assuming 'result' is already defined and valid

        String token = mapper.readValue(result.getContentAsString(), TokenResponseDTO.class).getIdToken();
        JWSObject jwsObject = JWSObject.parse(token);
        JWTPayloadDTO payload = mapper.readValue(jwsObject.getPayload().toString(), JWTPayloadDTO.class);

        Assert.assertEquals("random_string", payload.getNonce());
        // ... other checks
    }
}