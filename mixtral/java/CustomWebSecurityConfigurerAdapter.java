import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Create a custom authentication filter
        AbstractAuthenticationProcessingFilter filter = new MyCustomAuthFilter();

        List<Filter> filters = new ArrayList<>(http.getSharedObject(Filter.class).getFilters());

        for (int i = 0; i < filters.size() - 1; ++i) {
            if (!(filters.get(i + 1) instanceof AnonymousAuthenticationFilter)) continue;

            // Remove the filter
            http.addFilterBefore((AbstractAuthenticationProcessingFilter) filter, AbstractPreAuthenticatedProcessingFilter.class);

            filters.remove(i + 1);
        }

        super.configure(http);

        for (Filter f : filters) {
            // Add the remaining filters back
            http.addFilterBefore((AbstractAuthenticationProcessingFilter) f, AbstractPreAuthenticatedProcessingFilter.class);
        }

    }

    // Dummy MyCustomAuthFilter class to make it compilable
    private static class MyCustomAuthFilter extends AbstractAuthenticationProcessingFilter {
        protected MyCustomAuthFilter() {
            super("/custom/**");
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
                throws AuthenticationException, IOException, ServletException {
            return null;
        }
    }
}