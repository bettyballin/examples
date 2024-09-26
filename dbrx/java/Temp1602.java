import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootApplication
public class Temp1602 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "admin")
    public void adminsCanAccessRuntimeConfig() throws Exception {
        mockMvc.perform(get("/my/custom/api"))
               .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    public void nonAdminsCannotAccessRuntimeConfig() throws Exception {
        mockMvc.perform(get("/my/custom/api"))
               .andExpect(status().isUnauthorized());
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp1602.class, args);
    }

    @RestController
    static class MyController {
        @GetMapping("/my/custom/api")
        public String myCustomApi() {
            return "OK";
        }
    }
}