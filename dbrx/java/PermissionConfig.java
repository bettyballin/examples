import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PermissionConfig {

    @Bean(name = "permissionList")
    public List<String> getPermissionList() {
        return Arrays.asList("super", "long", "list");
    }

    public static void main(String[] args) {
        org.springframework.context.ApplicationContext context = 
            new org.springframework.context.annotation.AnnotationConfigApplicationContext(PermissionConfig.class);
        List<String> permissionList = (List<String>) context.getBean("permissionList");
        System.out.println(permissionList);
    }
}