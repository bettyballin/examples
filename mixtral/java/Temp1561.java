import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .oauth2Login()
                    .successHandler(myAuthSuccessHandler());
    }

    @Bean
    public AuthenticationSuccessHandler myAuthSuccessHandler() {
        return new MyAuthSuccessHandler();
    }

    @Component
    public static class MyAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            // Custom success handler logic here
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}


xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <http>
        <!-- other config -->
        <custom-filter ref="myAuthenticationFilter" after="OAUTH2_LOGIN_FILTER"/>
    </http>

    <!-- Bean definition for your custom filter -->
    <bean id="myAuthenticationFilter" class="com.example.MyAuthSuccessHandler"/>
</beans>