// Import necessary packages
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Dummy UserDetailsServiceImpl class for demonstration purposes
class UserDetailsServiceImpl {
    // Implementation details...
}

// Dummy LoginAuthentiCatioNSuccessHandler class for demonstration purposes
class LoginAuthentiCatioNSuccessHandler {
    private final UserDetailsServiceImpl userDetailsService;

    public LoginAuthentiCatioNSuccessHandler(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Implementation details...
}

// Configuration Class
@Configuration
public class AppConfig {

    @Bean
    public UserDetailsServiceImpl userDetailsServiceImpl() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public LoginAuthentiCatioNSuccessHandler loginAuthentiCatioNSuccessHandler(UserDetailsServiceImpl userDetailsService) {
        return new LoginAuthentiCatioNSuccessHandler(userDetailsService);
    }

    public static void main(String[] args) {
        // Load Java-based configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        LoginAuthentiCatioNSuccessHandler handler = context.getBean(LoginAuthentiCatioNSuccessHandler.class);
        System.out.println("Java-based configuration: " + handler);

        // Load XML-based configuration
        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginAuthentiCatioNSuccessHandler xmlHandler = (LoginAuthentiCatioNSuccessHandler) xmlContext.getBean("loginAuthenticationSuccessHandler");
        System.out.println("XML-based configuration: " + xmlHandler);

        context.close();
        xmlContext.close();
    }
}


xml
<!-- applicationContext.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userDetailsServiceImpl" class="com.example.UserDetailsServiceImpl"/>

    <bean id="loginAuthenticationSuccessHandler" class="com.example.LoginAuthentiCatioNSuccessHandler">
        <constructor-arg ref="userDetailsServiceImpl"/>
    </bean>

</beans>