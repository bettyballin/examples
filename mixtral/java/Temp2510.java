import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Temp2510 {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void getAllUsers_shouldBeSuccess() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("0", true, new Role("USER")));

        when(userService.getUsers()).thenReturn(users);

        mvc.perform(
                get("/users")
                        .with(jwt().authorities(new SimpleGrantedAuthority("ADMIN")))
        )
        .andExpect(status().isOk());
    }
}

// Mock classes to make the code compile
class User {
    private String id;
    private boolean active;
    private Role role;

    public User(String id, boolean active, Role role) {
        this.id = id;
        this.active = active;
        this.role = role;
    }
}

class Role {
    private String name;

    public Role(String name) {
        this.name = name;
    }
}

interface UserService {
    ArrayList<User> getUsers();
}
}