import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class Temp2171 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method for running the application
    }

    @Override
    protected void configure(HttpSecurity httpSec) throws Exception {
        httpSec
            .exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) ->
                    sendCustomResponse(response, "You have to log in to see this content", HttpStatus.UNAUTHORIZED))
            .and()
            .csrf().disable()
            .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) ->
                    sendCustomResponse(response, "You have to log in to see this content", HttpStatus.UNAUTHORIZED))
            .and()
            .headers().frameOptions().disable();
    }

    private void sendCustomResponse(HttpServletResponse response, String message, HttpStatus status) throws Exception {
        response.setStatus(status.value());
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(new ObjectMapper().writeValueAsString(message));
        writer.flush();
        writer.close();
    }
}