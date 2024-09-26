import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTests {

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
            .addFilters(this.springSecurityFilterChain).build();
    }

    @Test
    public void testLoginPostController() throws Exception {
        Account account = new AccountBuilder("test", "test", "test@gmail.com", Address.FAKE_EMPTY_ADDRESS4TESTS)
                .build();
        this.mockMvc.perform(post("/j_spring_security_check").param("j_username", account.getUsername()).param("j_password", "test"))
                .andDo(print())
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/public/index.htm"));
    }

    // Mock AccountBuilder and Address classes for the test
    public static class AccountBuilder {
        private String username;
        private String password;
        private String email;
        private Address address;

        public AccountBuilder(String username, String password, String email, Address address) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.address = address;
        }

        public Account build() {
            return new Account(username, password, email, address);
        }
    }

    public static class Account {
        private String username;
        private String password;
        private String email;
        private Address address;

        public Account(String username, String password, String email, Address address) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.address = address;
        }

        public String getUsername() {
            return username;
        }
    }

    public static class Address {
        public static final Address FAKE_EMPTY_ADDRESS4TESTS = new Address();
    }
}