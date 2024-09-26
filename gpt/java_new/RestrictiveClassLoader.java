public class RestrictiveClassLoader extends ClassLoader {
    private static final String[] restrictedPackages = {
        // yourRestrictedPackagesHere
        // e.g., "my.restricted.package."
    };

    static {
        System.setProperty("python.security.respectJavaAccessibility", "true");
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        for (String restrictedPackage : restrictedPackages) {
            if (name.startsWith(restrictedPackage)) {
                throw new ClassNotFoundException("Access to package " + name + " is not allowed.");
            }
        }
        return super.loadClass(name, resolve);
    }
}