public class Temp688 {
    public static void main(String[] args) {
        System.out.println("This is a placeholder for the authentication manager configuration.");
    }
}


xml
<authentication-manager>
    <authentication-provider>
        <jdbc-user-service data-source-ref="securityDataSource" 
            users-by-username-query="your customized SQL goes here"
            authorities-by-username-query="your customized SQL goes here"
            group-authorities-by-username-query="your customized SQL goes here"
        />
    </authentication-provider>
</authentication-manager>