import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig208urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig208 extends WebSecurityConfig208urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .logout();

        // If Vaadin handles routing, configure Spring Security to ignore Vaadin internal requests
        RouteConfiguration.forApplicationScope().getAvailableRoutes().forEach(routeData -> {
            String url = routeData.getUrl();
            UI.getCurrent().getPage().executeJs("console.log('Ignoring Spring Security for route: " + url + "');");
            http.authorizeRequests().antMatchers(url).permitAll();
        });

        // If using Vaadin Servlet, ignore requests for static resources
        String contextPath = VaadinServletRequest.getCurrent().getService().getContextPath();
        http.authorizeRequests().antMatchers(contextPath + "/VAADIN/**").permitAll();

        // If using Vaadin Service, ignore service requests
        http.authorizeRequests().requestMatchers(VaadinServletRequest.class::isInstance).permitAll();
        http.authorizeRequests().requestMatchers(VaadinServletResponse.class::isInstance).permitAll();
    }
}