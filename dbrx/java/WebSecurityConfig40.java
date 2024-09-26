import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CourseRoleVoter courseRoleVoter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/course/**").access("@courseRoleVoter.vote(authentication, request)")
                .anyRequest().authenticated();
    }
}

@Component
public class CourseRoleVoter implements AccessDecisionVoter<HttpServletRequest> {

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return HttpServletRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public int vote(Authentication authentication, HttpServletRequest request, Collection<ConfigAttribute> attributes) {
        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
        WebSecurityExpressionRoot webSecurityExpressionRoot = new WebSecurityExpressionRoot(authentication, request);
        return webExpressionVoter.vote(authentication, webSecurityExpressionRoot, attributes);
    }

    public boolean vote(WebSecurityExpressionRoot root, HttpServletRequest request) {
        // Implement your voting logic here
        return true; // or false based on your logic
    }
}