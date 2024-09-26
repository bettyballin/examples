public class SpringSecurityConfiguration {
    private AccessDeniedHandler accessDeniedHandler;

    public SpringSecurityConfiguration(AccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    // ...
}