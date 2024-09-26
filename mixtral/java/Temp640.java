import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp640 extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private RoleHierarchy roleHierarchy;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
        webExpressionVoter.setRoleHierarchy(roleHierarchy);

        http
            // add your configurations here
            .authorizeRequests()
            .anyRequest().authenticated()
            .accessDecisionManager(defaultAccessDecisionManager());
    }

    private AccessDecisionManager defaultAccessDecisionManager() {
        // configure and return your AccessDecisionManager here
        return null;
    }
    
    public static void main(String[] args) {
        // SpringApplication.run(Temp640.class, args); // Uncomment this line if using Spring Boot
    }
}