import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.SecureClassLoader;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {
    private String pluginDirectoryPath;

    public PluginClassLoader(URL[] urls, ClassLoader parent, String pluginDirectoryPath) {
        super(urls, parent);
        this.pluginDirectoryPath = pluginDirectoryPath;
    }

    @Override
    protected PermissionCollection getPermissions(CodeSource codesource) {
        Permissions permissions = new Permissions();
        permissions.add(new java.security.AllPermission());
        return permissions;
    }

    // If you need to load a class or resource from the plugin directory
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return super.findClass(name);
        } catch (ClassNotFoundException e) {
            URL[] urls = this.getURLs();
            for (URL url : urls) {
                if (url.getFile().endsWith(".jar")) {
                    try (URLClassLoader jarLoader = new URLClassLoader(new URL[]{url}, this.getParent())) {
                        return jarLoader.loadClass(name);
                    }
                }
            }
            throw e;
        }
    }
}