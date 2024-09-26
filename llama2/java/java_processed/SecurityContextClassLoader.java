import java.security.ClassLoader;

class SecurityContext {
    private Authentication authentication;

    public SecurityContext(Authentication authentication) {
        this.authentication = authentication;
    }

    public Authentication getAuthentication() {
        return authentication;
    }
}

class Authentication {
    private Object principal;

    public Authentication(Object principal) {
        this.principal = principal;
    }

    public Object getPrincipal() {
        return principal;
    }
}

public class SecurityContextClassLoader extends ClassLoader {
    private final ClassLoader parent;
    private final SecurityContext context;

    public SecurityContextClassLoader(ClassLoader parent, SecurityContext context) {
        super(parent);
        this.parent = parent;
        this.context = context;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return context.getAuthentication().getPrincipal() != null ?
                super.loadClass(name, resolve) :
                parent.loadClass(name, resolve);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // Example usage
        ClassLoader parentClassLoader = SecurityContextClassLoader.class.getClassLoader();
        SecurityContext context = new SecurityContext(new Authentication("user"));
        SecurityContextClassLoader securityContextClassLoader = new SecurityContextClassLoader(parentClassLoader, context);

        // Load a class
        Class<?> clazz = securityContextClassLoader.loadClass("java.lang.String");
        System.out.println("Loaded class: " + clazz.getName());
    }
}