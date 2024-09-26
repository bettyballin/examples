import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

@Configuration
public class TestConfig extends AbstractSecurityWebApplicationInitializer {

    @Bean
    public Filter springSecurityFilterChain() throws Exception {
        return new DelegatingFilterProxy("springSecurityFilterChain");
    }

    public static void main(String[] args) throws Exception {
        WebApplicationContext context = null; // Initialize your context here
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context)
                                          .apply(org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity())
                                          .addFilters(context.getBean("springSecurityFilterChain", Filter.class))
                                          .build();

        // Example request to test the setup
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        
        mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/"))
               .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isOk());
    }
}