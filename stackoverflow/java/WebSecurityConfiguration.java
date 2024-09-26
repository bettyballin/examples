import com.brahalla.PhotoAlbum.dao.AccountRepository;
import com.brahalla.PhotoAlbum.domain.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .anyRequest().authenticated()
      .and()
        .formLogin()
          .loginPage("/login")
          .permitAll()
      .and()
        .logout()
          .permitAll()
      .and()
        .httpBasic()
      .and()
        .csrf().disable();
  }

  @Bean
  @Override
  public UserDetailsService userDetailsService() {
    return username -> {
      Account account = accountRepository.findByUsername(username);
      if (account != null) {
        return new User(
          account.getUsername(),
          account.getPassword(),
          AuthorityUtils.createAuthorityList("USER")
        );
      } else {
        throw new UsernameNotFoundException("could not find the user '" + username + "'");
      }
    };
  }
}