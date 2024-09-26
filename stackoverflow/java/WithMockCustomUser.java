import org.springframework.security.test.context.support.WithSecurityContext;

@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory.class)
public @interface WithMockCustomUser {
    // Add any necessary parameters for the custom user annotation here
}