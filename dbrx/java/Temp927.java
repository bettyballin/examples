import java.io.FileInputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        new Main().foo();
    }

    public void foo() {
        MySecurityManager secManager = new MySecurityManager();
        System.setSecurityManager(secManager);

        try {
            ConfigValidator.main(new String[]{"-dirs", "SdkServiceConfig.s.PROPERTIES_FILE_PATH"});

            AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
                try (FileInputStream fis = new FileInputStream("/Users/eladb/WorkspaceQa/sdk-service/src/main/resources/convert_conditions.sh")) {

                    // Do something with the file input stream

                } catch (IOException e) {
                    logger.severe("Failed to read file: " + e.getMessage());
                }
                return null;
            });

        } catch (SecurityException e) {
            // Do something if the external code used System.exit()
            String a = "1";
        } catch (Exception e) {
            logger.severe("Failed converting properties file to proto: " + e.getMessage());
        }
    }
}

class MySecurityManager extends SecurityManager {
    @Override
    public void checkExit(int status) {
        throw new SecurityException("System.exit not allowed");
    }

    @Override
    public void checkPermission(Permission perm) {
        // Allow other permissions
    }
}

class ConfigValidator {
    public static void main(String[] args) {
        // Dummy implementation for the example
        System.out.println("ConfigValidator running with args: " + String.join(", ", args));
    }
}