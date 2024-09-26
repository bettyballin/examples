import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class MyComponent {

    @Autowired
    private ApplicationContext applicationContext;

    private FilterChainProxy springSecurityFilterChain;

    @PostConstruct
    public void init() {
        springSecurityFilterChain = (FilterChainProxy) applicationContext.getBean("springSecurityFilterChain");
    }

    public String getLoginPage() {
        return springSecurityFilterChain.getFilterChains().stream()
                .flatMap(chain -> chain.getFilters().stream())
                .filter(filter -> filter instanceof SomeLoginFilter) // Replace with your specific filter class
                .findFirst()
                .map(filter -> ((SomeLoginFilter) filter).getUrl()) // Replace with your method to get URL
                .orElse(null);
    }
}