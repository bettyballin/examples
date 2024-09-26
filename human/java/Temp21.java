import javax.security.auth.login.*;
import javax.security.auth.Subject;
import java.security.PrivilegedAction;
import java.util.*;

public class JAASKrb5Example {
    public static void main(String[] args) {
        try {
            // Create a configuration instance
            Configuration config = new Configuration() {
                @Override
                public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
                    Map<String, String> options = new HashMap<>();
                    options.put("useKeyTab", "true");
                    options.put("storeKey", "true");
                    options.put("doNotPrompt", "true");
                    options.put("keyTab", "/home/myusr/my-server.keytab");
                    options.put("principal", "myserv/mymachine.some.domain");
                    
                    return new AppConfigurationEntry[]{
                        new AppConfigurationEntry(
                            "com.sun.security.auth.module.Krb5LoginModule",
                            AppConfigurationEntry.LoginModuleControlFlag.REQUIRED,
                            options
                        )
                    };
                }
            };

            // Set the configuration
            Configuration.setConfiguration(config);

            // Create a login context
            LoginContext lc = new LoginContext("anything");
            lc.login();

            // Perform actions as the authenticated user
            Subject subject = lc.getSubject();
            Subject.doAs(subject, (PrivilegedAction<Void>) () -> {
                System.out.println("Authenticated as: " + subject);
                return null;
            });

        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}