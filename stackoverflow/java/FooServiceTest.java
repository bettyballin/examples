import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.test.context.support.WithMockUser;
import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FooServiceTest {

    @Autowired
    private FooService service;

    @Test
    @WithMockUser(username = "usertest", password = "password", roles = "USER")
    public void someTest() {    
        service.findFoo(1L);
    }

}