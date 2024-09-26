import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.filter.FilterType;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(
    value = SomeController.class,
    excludeAutoConfiguration = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
    excludeFilters = @ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE,
            classes = WebSecurityConfigurer.class))
@AutoConfigureMockMvc(addFilters = false)
public class SomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SomeService someService;

    @Test
    @WithMockUser
    public void testSomeEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/some-endpoint"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

// Dummy controller for demonstration purposes
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping("/some-endpoint")
    public String someEndpoint() {
        return "Hello, World!";
    }
}

// Dummy service for demonstration purposes
import org.springframework.stereotype.Service;

@Service
public class SomeService {
    public String performAction() {
        return "Action performed";
    }
}