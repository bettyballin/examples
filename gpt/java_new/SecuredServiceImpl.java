import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.BundleContext;

public class SecuredServiceImpl implements SecuredService {
    @Override
    public void securedMethod() {
        BundleContext bundleContext = FrameworkUtil.getBundle(SecuredServiceImpl.class).getBundleContext();
        Bundle callerBundle = bundleContext.getBundle();
        // Now you can use callerBundle to get information about the calling bundle
        // and apply your security checks accordingly.
    }
}

interface SecuredService {
    void securedMethod();
}