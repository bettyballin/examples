import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.access.intercept.MethodInvocation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CustomMethodSecurityMetadataSource implements MethodSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(MethodInvocation mi) {
        // Register the isAllowedToViewEmployee() custom method
        return Arrays.asList(new ConfigAttribute[]{ new SecurityConfig("isAllowedToViewEmployee('empId')") });
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // Return an empty collection
        return Collections.emptySet();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}