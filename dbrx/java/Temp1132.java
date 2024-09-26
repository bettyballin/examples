import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@SpringBootTest
@AutoConfigureMockMvc
public class Temp1132 {

    private MockMvc mockMvc;
    private final WebApplicationContext webApplicationContext;

    public Temp1132(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp1132.class, args);
    }

    @PostConstruct
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        CustomUser customUser = new CustomUser("username", "password", new ArrayList<>());
        MyCustomAuth customAuth = new MyCustomAuth(customUser);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/your-endpoint")
                        .principal(customAuth))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    public static class CustomUser implements UserDetails {
        private final String username;
        private final String password;
        private final List<GrantedAuthority> authorities;

        public CustomUser(String username, String password, List<GrantedAuthority> authorities) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

    public static class MyCustomAuth implements Authentication {
        private final CustomUser customUser;

        public MyCustomAuth(CustomUser customUser) {
            this.customUser = customUser;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return customUser.getAuthorities();
        }

        @Override
        public Object getCredentials() {
            return customUser.getPassword();
        }

        @Override
        public Object getDetails() {
            return null;
        }

        @Override
        public Object getPrincipal() {
            return customUser;
        }

        @Override
        public boolean isAuthenticated() {
            return true;
        }

        @Override
        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        }

        @Override
        public String getName() {
            return customUser.getUsername();
        }
    }
}