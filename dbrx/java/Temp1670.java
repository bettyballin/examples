import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class Temp1670 {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private UserService userService;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @WithMockUser(authorities = "ADMIN")
    public void getAllUsers_shouldBeSuccess() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("0", true, new Role("USER")));

        when(userService.getUsers()).thenReturn(new ResponseEntity<>(users, HttpStatus.OK));

        mvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    // Assuming User and Role classes are defined as follows:
    public static class User {
        private String id;
        private boolean active;
        private Role role;

        public User(String id, boolean active, Role role) {
            this.id = id;
            this.active = active;
            this.role = role;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }
    }

    public static class Role {
        private String name;

        public Role(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // Assuming UserService is defined as follows:
    public interface UserService {
        ResponseEntity<ArrayList<User>> getUsers();
    }
}