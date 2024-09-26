import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;

import static org.springframework.test.context.TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
@TestExecutionListeners(listeners = WithSecurityContextTestExecutionListener.class, mergeMode = MERGE_WITH_DEFAULTS)
public class FooServiceTest {

    @Autowired
    private FooService service;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void someTest() {
        service.findFoo(1L);
    }
}