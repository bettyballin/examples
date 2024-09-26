public class Temp1715 {
    public static void main(String[] args) {
        System.setProperty("java.security.krb5.debug", "true");
        System.setProperty("java.security.auth.login.config", "C:\\login.conf");
        System.setProperty("java.security.krb5.conf", "C:\\krb5.conf");
        System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
        
        // Your application logic here
        System.out.println("Kerberos configuration set.");
    }
}