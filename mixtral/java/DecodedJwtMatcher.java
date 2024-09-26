import io.jsonwebtoken.*;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class DecodedJwtMatcher extends TypeSafeDiagnosingMatcher<String> {
    private final String claimName;
    private final Object expectedValue;

    public static Matcher<String> decodesTo(final String claimName, final Object value) {
        return new DecodedJwtMatcher(claimName, value);
    }

    private DecodedJwtMatcher(final String claimName, final Object expectedValue) {
        this.expectedValue = expectedValue;
        this.claimName = claimName;
    }

    @Override
    protected boolean matchesSafely(String jwtToken, Description mismatchDescription) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey("your_secret").parseClaimsJws(jwtToken);
            Claims claims = claimsJws.getBody();
            Object actualValue = claims.get(claimName);

            if (!expectedValue.equals(actualValue)) {
                mismatchDescription.appendText("was ").appendValue(actualValue);
                return false;
            }
            return true;
        } catch (JwtException e) {
            mismatchDescription.appendText("was an invalid JWT: ").appendText(e.getMessage());
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a JWT with claim ").appendText(claimName)
                   .appendText(" = ").appendValue(expectedValue);
    }
}