import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.BadCredentialsException;

public class CustomTokenAuthenticationProvider implements AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication a) {
    if (a instanceof CustomTokenAuthenticationRequest) {
      String token = ((CustomTokenAuthenticationRequest) a).getToken();
      // Implement token validation logic here
      boolean tokenValid = validateToken(token);

      if (tokenValid) {
        CustomTokenAuthentication returnValue = createCustomTokenAuthentication(token);
        return returnValue;
      }
    }
    throw new BadCredentialsException("Invalid token");
  }

  @Override
  public boolean supports(Class<?> authClass) {
    return CustomTokenAuthenticationRequest.class.isAssignableFrom(authClass);
  }

  private boolean validateToken(String token) {
    // Implement token validation logic
    // Return true if valid; false otherwise
    return true; // Placeholder return value
  }

  private CustomTokenAuthentication createCustomTokenAuthentication(String token) {
    // Create and return a new instance of CustomTokenAuthentication
    return new CustomTokenAuthentication(token); // Placeholder return value
  }
}