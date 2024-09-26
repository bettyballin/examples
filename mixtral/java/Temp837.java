import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootApplication
@EnableWebMvc
public class Temp837 implements WebMvcConfigurer {

    @Autowired
    private Filter springSecurityFilterChain;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Temp837.class, args);
        WebApplicationContext webApplicationContext = (WebApplicationContext) context;

        MockMvc mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .addFilters(webApplicationContext.getBean("springSecurityFilterChain"))
                .build();

        // You can now use mockMvc to perform tests
    }

    @Bean
    public Filter springSecurityFilterChain() {
        return new DelegatingFilterProxy();
    }
}