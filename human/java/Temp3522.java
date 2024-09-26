import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class MatcherConfig {
    
    @Bean
    public AntPathRequestMatcher antmatcherServlet() {
        return new AntPathRequestMatcher("/servlet/**", null, false);
    }

    @Bean
    public AntPathRequestMatcher antmatcherMobile() {
        return new AntPathRequestMatcher("/mobile.html", null, false);
    }
}


xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="org.springframework.security.web.util.matcher.AntPathRequestMatcher" id="antmatcherServlet">
        <constructor-arg value="/servlet/**" index="0"/>
        <constructor-arg index="1"><null/></constructor-arg>
        <constructor-arg value="false" index="2"/>
    </bean>
    
    <bean class="org.springframework.security.web.util.matcher.AntPathRequestMatcher" id="antmatcherMobile">
        <constructor-arg value="/mobile.html" index="0"/>
        <constructor-arg index="1"><null/></constructor-arg>
        <constructor-arg value="false" index="2"/>
    </bean>

</beans>