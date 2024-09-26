import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.access.intercept.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1068 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Main method content (if needed)
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Configuration goes here
            .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                    fsi.setSecurityMetadataSource(customSecurityMetadataSource());
                    return fsi;
                }
            });
    }

    private SecurityMetadataSource customSecurityMetadataSource() {
        LinkedHashMap<String, Collection<ConfigAttribute>> metadata = new LinkedHashMap<>();
        // Additional configurations go here
        ConfigAttribute attrSupervised = new CustomRole(CustomAuthoritiesConstants.SUPERVISED);
        metadata.put("/api/great-resource", Collections.singletonList(attrSupervised));
        return new CustomSecurityMetadataSource(metadata);
    }

    // Assuming CustomRole and CustomAuthoritiesConstants are defined somewhere else
    private class CustomRole implements ConfigAttribute {
        private final String role;

        public CustomRole(String role) {
            this.role = role;
        }

        @Override
        public String getAttribute() {
            return role;
        }
    }

    // Dummy class for example purposes
    private static class CustomAuthoritiesConstants {
        public static final String SUPERVISED = "ROLE_SUPERVISED";
    }

    // Dummy class for example purposes
    private static class CustomSecurityMetadataSource implements SecurityMetadataSource {
        private final LinkedHashMap<String, Collection<ConfigAttribute>> metadata;

        public CustomSecurityMetadataSource(LinkedHashMap<String, Collection<ConfigAttribute>> metadata) {
            this.metadata = metadata;
        }

        @Override
        public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
            // Implementation goes here
            return null;
        }

        @Override
        public Collection<ConfigAttribute> getAllConfigAttributes() {
            // Implementation goes here
            return null;
        }

        @Override
        public boolean supports(Class<?> clazz) {
            // Implementation goes here
            return true;
        }
    }
}