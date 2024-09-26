import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTNonceMatcher extends TypeSafeDiagnosingMatcher<String> {
    private final String expectedNonce;
    private final String secretKey;

    public JWTNonceMatcher(String expectedNonce, String secretKey) {
        this.expectedNonce = expectedNonce;
        this.secretKey = secretKey;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("JWT nonce value ");
        description.appendValue(expectedNonce);
        description.appendText(" found in JSON path '$.id_token'");
    }

    @Override
    protected boolean matchesSafely(String jsonPathResult, Description mismatchDescription) {
        try {
            // Decode the JWT token
            Jws<Claims> jwt = Jwts.parser()
                                  .setSigningKey(secretKey)
                                  .parseClaimsJws(jsonPathResult);

            // Check if the nonce value matches
            String actualNonce = jwt.getBody().get("nonce", String.class);
            if (expectedNonce.equals(actualNonce)) {
                return true;
            } else {
                mismatchDescription.appendText("Expected nonce: ")
                                   .appendValue(expectedNonce)
                                   .appendText(" but was: ")
                                   .appendValue(actualNonce);
                return false;
            }
        } catch (Exception e) {
            mismatchDescription.appendText("Error decoding JWT token: ");
            mismatchDescription.appendValue(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Example usage
        String secretKey = "mySecretKey";
        String expectedNonce = "123456";
        String jwtToken = Jwts.builder()
                              .claim("nonce", expectedNonce)
                              .signWith(SignatureAlgorithm.HS256, secretKey)
                              .compact();

        JWTNonceMatcher matcher = new JWTNonceMatcher(expectedNonce, secretKey);
        Description description = new Description.NullDescription();

        if (matcher.matches(jwtToken)) {
            System.out.println("Nonce matches!");
        } else {
            matcher.describeMismatch(jwtToken, description);
            System.out.println("Nonce does not match: " + description.toString());
        }
    }
}