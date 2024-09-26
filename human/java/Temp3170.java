public class Temp3170 {
    public static void main(String[] args) {
        String[] securityFilterChain = {
                "WebAsyncManagerIntegrationFilter",
                "SecurityContextPersistenceFilter",
                "HeaderWriterFilter",
                "LogoutFilter",
                "JwtUsernameAndPasswordFilter",  // This is your filter
                "UsernamePasswordAuthenticationFilter",
                "JwtTokenVerifier",              // This is your filter
                "DefaultLoginPageGeneratingFilter",
                "DefaultLogoutPageGeneratingFilter",
                "RequestCacheAwareFilter",
                "SecurityContextHolderAwareRequestFilter",
                "AnonymousAuthenticationFilter",
                "SessionManagementFilter",
                "ExceptionTranslationFilter",
                "FilterSecurityInterceptor"
        };

        System.out.println("Security filter chain: ");
        for (String filter : securityFilterChain) {
            System.out.println(filter);
        }
    }
}