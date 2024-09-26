import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.aurora.timeexpense.service.MyUserService;

@Configuration
public class AppConfig {

    @Bean
    public MyUserService customUserDetailsService() {
        return new MyUserService();
    }
}

package org.aurora.timeexpense.service;

public class MyUserService {
    // Implement your service methods here
}