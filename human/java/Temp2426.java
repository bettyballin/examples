import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

public class Temp2426 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = context.getBean(MyService.class);
        myService.method("DEV");
        context.close();
    }
}

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class AppConfig {
    @Bean
    @Profile("DEV")
    public MyService myServiceDev() {
        return new MyService();
    }

    @Bean
    @Profile("PROD")
    public MyService myServiceProd() {
        return new MyService();
    }
}

class MyService {
    @PreAuthorize("hasRole('SOME_' + #profile + '_ROLE')")
    public void method(@Value("#{ environment.getActiveProfiles()[0]?.toUpperCase() }") String profile) {
        System.out.println("Profile: " + profile);
    }
}


Make sure you have the required dependencies in your `pom.xml` or `build.gradle` file to run the above code, including Spring Framework and Spring Security.