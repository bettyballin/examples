import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp595 {
    public static void main(String[] args) {
        SpringApplication.run(Temp595.class, args);
    }
}

@RestController
class MyController {
    @GetMapping("/my/custom/api")
    public String customApi() {
        return "Hello, world!";
    }
}

@SpringBootTest
@AutoConfigureMockMvc
class Temp595Tests {

    @Autowired
    private MockMvc mockedMvc;

    @Test
    @WithMockUser(username = "user", password = "password", roles = {"IS NOT admin"})
    public void nonAdminsCannotAccessRuntimeConfig() throws Exception {
        this.mockedMvc.perform(MockMvcRequestBuilders.get("/my/custom/api"))
            .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }
}