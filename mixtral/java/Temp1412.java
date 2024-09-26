import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Temp1412 extends WebSecurityConfigurerAdapter {
    private List<GlobalSettings> globals; // Assuming GlobalSettings is a defined class

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        for (GlobalSettings global : globals) {
            String path = "/" + global.getPath();

            http
                .authorizeRequests()
                    .antMatchers(path + "/**").permitAll()
                    .antMatchers(path + "/admin/**").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin().loginProcessingUrl("/" + global.getPath() + "/login")
                    .successHandler((request, response, authentication) -> {
                        String targetUrl = path + "/admin";

                        if (response.isCommitted()) {
                            System.out.println("Response has already been committed");
                            return;
                        }

                        new RedirectStrategy() {
                            @Override
                            public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
                                // Use the path-specific URL for redirection
                                response.sendRedirect(targetUrl);
                            }
                        }.sendRedirect(request, response, targetUrl);
                    });
        }
    }

    // Dummy GlobalSettings class for code completion
    public static class GlobalSettings {
        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

    public static void main(String[] args) {
        // Main method for execution
    }
}