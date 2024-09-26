import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.access.vote.WebExpressionVoter;
import org.springframework.security.core.authority.mapping.GrantedAuthorityDefaults;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import java.util.ArrayList;
import java.util.List;

public class Temp2357 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2357.class, args);
    }

    @Bean
    public AccessDecisionManager customAccessDecisionManager() {
        List<AccessDecisionVoter<?>> decisionVoters = new ArrayList<>();

        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        // Define your own hierarchy if needed

        GrantedAuthorityDefaults grantedAuthorityDefaults =
                (GrantedAuthorityDefaults) SpringApplication.getBeanFactory().getSingleton("grantedAuthorityDefaults");

        roleHierarchy.setRolePrefix("");

        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();

        // Add the custom RoleVoter
        decisionVoters.add(webExpressionVoter);

        AffirmativeBased accessDecisionManager =
                (AffirmativeBased) SpringApplication.getBeanFactory().getSingleton("accessDecisionManager");

        return new AffirmativeBased(decisionVoters);
    }
}