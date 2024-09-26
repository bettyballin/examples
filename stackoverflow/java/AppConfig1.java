// Assuming you want to refactor this into a Java configuration class

package my.awesome.package;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

    @Bean
    public MyAwesomeShaPasswordEncoder passwordEncoder() {
        return new MyAwesomeShaPasswordEncoder();
    }
}