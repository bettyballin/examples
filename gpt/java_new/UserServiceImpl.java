import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Locale; // Assuming Local is a typo and should be Locale

public interface UserService {
    User getUser(String login);
    List<Locale> getUserLocales(User user);
}

@Service
public class UserServiceImpl implements UserService {
    // ... other service methods ...

    @Override
    public User getUser(String login) {
        // Implementation of getUser method
        return null; // Stub return value
    }

    @Override
    @Transactional
    public List<Locale> getUserLocales(User user) {
        // Assuming User class has a method getUserLocales()
        return user.getUserLocales(); // Stub return value
    }
}