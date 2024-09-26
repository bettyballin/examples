import javax.security.auth.Subject;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.Krb5LoginModule;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KinitExample {

    public static void main(String[] args) {
        try {
            // Admin configuration and cache creation logic

            Configuration.setConfiguration(new JaasConf("MutualAdmin"));

            LoginContext lc = new LoginContext("");
            lc.login();

            Subject subject = lc.getSubject();
            Set<Principal> principals = subject.getPrincipals();
            Principal principal = null;
            for (Principal p : principals) {
                if (p instanceof KerberosPrincipal && ((KerberosPrincipal) p).getName().contains("@")) {
                    principal = p;
                    break;
                }
            }

            String cacheFileLocAdmin = "C:\\Users\\User1\\temp\\admin.cache";
            Krb5LoginModule krb5LoginModule = new Krb5LoginModule();
            Map<String, Object> options = new HashMap<>();
            options.put("useTicketCache", "true");
            options.put("ticketCache", cacheFileLocAdmin);

            Subject subjectNewAdmin = new Subject(false, Collections.singleton(principal), Collections.emptySet(), Collections.emptySet());
            krb5LoginModule.initialize(subjectNewAdmin, null, null, options);
            krb5LoginModule.login();

            // New Admin configuration and cache creation logic

            Configuration.setConfiguration(new JaasConf("sp.kerb.sso.KinitExampleNewAdmin"));

            LoginContext lcNew = new LoginContext("");
            lcNew.login();

            Subject subjectNew = lcNew.getSubject();
            Set<Principal> principalsNew = subjectNew.getPrincipals();
            
            // Further logic for new admin can be added here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Mock JaasConf class for demonstration
class JaasConf extends Configuration {
    private String name;

    public JaasConf(String name) {
        this.name = name;
    }

    @Override
    public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
        return new AppConfigurationEntry[]{new AppConfigurationEntry(
                "com.sun.security.auth.module.Krb5LoginModule",
                AppConfigurationEntry.LoginModuleControlFlag.REQUIRED,
                Collections.emptyMap())};
    }
}