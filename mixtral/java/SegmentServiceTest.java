import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SegmentServiceTest {

    @Autowired
    private SegmentService service;

    // ...

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void testUpdateSegment() throws Exception {
        UpdateSegmentReq request = new UpdateSegmentReq();

        String name = "TEST";

        SegmentNode segment = service.updateSegment(request);

        assertEquals("TEST", segment.getName());

        // ...

    }
}