import org.springframework.context.annotation.Import;

@Import(AuthenticationConfiguration.class)
public @interface EnableGlobalAuthentication {}