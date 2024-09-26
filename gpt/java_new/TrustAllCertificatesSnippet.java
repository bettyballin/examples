import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.SecureRandom;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class TrustAllCertificatesSnippet {
    public static void main(String[] args) {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        // No need to implement.
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        // No need to implement.
                    }
                }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());

            // Create all-trusting host name verifier
            // Code for hostname verifier (if required) would go here

            // Set up the environment for creating the initial context
            Hashtable<String, Object> env = new Hashtable<String, Object>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://<ldap_server>:<port>");
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "<username>");
            env.put(Context.SECURITY_CREDENTIALS, "<password>");
            env.put("java.naming.ldap.factory.socket", "your.package.TrustAllSslSocketFactory");

            // Create the initial context
            LdapContext ctx = new InitialLdapContext(env, null);

            // ... use the context ...

            // Close the context when done
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}