import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:securityContext.xml")
public class OwnerTerminalsControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    SecurityContextHolderAwareRequestFilter securityContextHolderAwareRequestFilter;

    private MockMvc mockMvc;

    @Autowired
    public void setMockMvc(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilters(new DelegatingFilterProxy(securityContextHolderAwareRequestFilter))
                .build();
    }

    @Test
    public void testEditTerminal() throws Exception {
        mockMvc.perform(post("/owner/terminals/edit").with(request -> {
            HttpServletRequestWrapper wrapper =
                    new SecurityContextHolderAwareRequestWrapper((HttpServletRequest) request, null);
            return (HttpServletRequestWrapper) wrapper;
        })
                .principal(() -> "principal").secure(true))
                .andExpect(status().isOk());
    }
}