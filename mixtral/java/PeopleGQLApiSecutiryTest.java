import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(classes = {SecurityConfigImpl.class})
@SpringBootTest
public class PeopleGQLApiSecurityTest {

    @Autowired
    private SecurityContext securityContext;

    @Autowired
    private SecurityService securityServiceMock;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);

        Authentication authentication = new UsernamePasswordAuthenticationToken("username", "password");

        when(securityServiceMock.loadUserByUsername("username")).thenReturn(
            new org.springframework.security.core.userdetails.User(
                "username", 
                "password", 
                Collections.emptyList()
            )
        );

        securityContext.setAuthentication(authentication);
    }

    // ...
}