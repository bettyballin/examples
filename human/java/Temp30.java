public class Temp30 {
    public static void main(String[] args) {
        System.out.println("DEBUG DefaultFilterInvocationDefinitionSource,http-8443-1:196 - Converted URL to lowercase, from: '/url1/'; to: '/url1/'");
        System.out.println("DEBUG DefaultFilterInvocationDefinitionSource,http-8443-1:224 - Candidate is: '/url1/'; pattern is /url2**; matched=false");
        System.out.println("DEBUG DefaultFilterInvocationDefinitionSource,http-8443-1:224 - Candidate is: '/url1/'; pattern is /url1**; matched=true");
        System.out.println("DEBUG AbstractSecurityInterceptor,http-8443-1:250 - Secure object: FilterInvocation: URL: /url1/; ConfigAttributes: [ROLE_USER]");
        System.out.println("DEBUG XmlWebApplicationContext,http-8443-1:244 - Publishing event in context [org.springframework.web.context.support.XmlWebApplicationContext@17af46e]: org.springframework.security.event.authorization.AuthenticationCredentialsNotFoundEvent[source=FilterInvocation: URL: /url1/]");
        System.out.println("DEBUG ExceptionTranslationFilter,http-8443-1:150 - Authentication exception occurred; redirecting to authentication entry point");
    }
}