import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

interface UserDetailsService {
    // method signatures
}

@Component
class UserDetailServiceImpl implements UserDetailsService {
    // implementation
}

@Component
public class Temp1187 {

    @Autowired
    private List<UserDetailsService> userDetailServices;

    @PostConstruct
    public void init() {
        for (UserDetailsService uds : userDetailServices) {
            if (!(uds instanceof UserDetailServiceImpl)) {
                throw new IllegalStateException("Another instance of UserDetailsService found: " + uds.getClass());
            }
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Temp1187.class);
        context.close();
    }
}