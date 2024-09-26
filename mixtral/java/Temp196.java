import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class Temp196 {

    public static void main(String[] args) {
        Temp196 temp = new Temp196();
        try {
            IniShrioConfig iniShrioConfig = temp.iniShrioConfig();
            temp.securityManager(iniShrioConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public IniShrioConfig iniShrioConfig() throws IOException {
        Resource resource = new ClassPathResource("shiro.ini");
        return new IniShrioConfig(resource.getInputStream());
    }

    @Bean
    public DefaultWebSecurityManager securityManager(IniShrioConfig config) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(config);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        return (DefaultWebSecurityManager) securityManager;
    }
}

class IniShrioConfig extends org.apache.shiro.config.Ini {
    public IniShrioConfig(java.io.InputStream inputStream) throws IOException {
        super.load(inputStream);
    }
}