import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

public class Temp127 {
    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put("java.naming.ldap.factory.socket", "com.example.MySSLSocketFactory");

        try {
            InitialDirContext ctx = new InitialDirContext(env);
            // Add your LDAP operations here
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}