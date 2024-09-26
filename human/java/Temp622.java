public class Temp622 {
    public static void main(String[] args) {
        // Simulating what might be configuration for a web security framework
        String config = """
            <http auto-config="true" request-matcher="regex">
                <intercept-url pattern="/welcome*" access="ROLE_USER"/>
                <intercept-url pattern="/*" access="IS_AUTHENTICATED,IS_AUTHENTICATED_ANONYMOUSLY"/>
            </http>
        """;
        
        System.out.println(config);
    }
}