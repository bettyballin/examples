import java.security.Policy;
import java.security.Permission;
import java.security.Permissions;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.security.Principal;
import java.security.cert.Certificate;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AllPermission;
import java.security.PermissionCollection;
import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws Exception {
        Policy.setPolicy(new MySecurityPolicy());
        System.setSecurityManager(new SecurityManager());

        ClassLoader secureCL = new SecureClassLoader(Main.class.getClassLoader());
        Thread.currentThread().setContextClassLoader(secureCL);

        Class<?> appClass = secureCL.loadClass("MyApp");
        Constructor<?> constructor = appClass.getDeclaredConstructor();
        MyApp app = (MyApp) constructor.newInstance();
        app.run(args);
    }
}

class MySecurityPolicy extends Policy {
    @Override
    public PermissionCollection getPermissions(CodeSource codesource) {
        Permissions permissions = new Permissions();
        permissions.add(new AllPermission());
        return permissions;
    }
}

class SecureClassLoader extends URLClassLoader {
    public SecureClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> cls = super.loadClass(name, resolve);
        return cls;
    }
}

class MyApp {
    public void run(String[] args) {
        System.out.println("MyApp is running");
    }
}