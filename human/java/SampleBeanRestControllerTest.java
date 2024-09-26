import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Import(SampleBeanRestControllerTestConfig.class)
@WebMvcTest(SampleBeanRestController.class)
@AutoConfigureMockMvc
public class SampleBeanRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSampleEndpoint() throws Exception {
        mockMvc.perform(get("/sample-endpoint"))
                .andExpect(status().isOk());
    }
}

// SampleBeanRestController.java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleBeanRestController {

    @GetMapping("/sample-endpoint")
    public String sampleEndpoint() {
        return "Hello, World!";
    }
}

// SampleBeanRestControllerTestConfig.java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleBeanRestControllerTestConfig {

    @Bean
    public SampleBeanRestController sampleBeanRestController() {
        return new SampleBeanRestController();
    }
}