import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.hibernate.SessionFactory;

@Component
@Transactional
public class TodoDao implements ITodoDao {

    private final SessionFactory sessionFactory;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public TodoDao(SessionFactory sessionFactory, AuthenticationFacade authenticationFacade) {
        this.sessionFactory = sessionFactory;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    @PreAuthorize("hasPermission(#todo, 'CHANGE')")
    public void changeTodoStatus(Todo todo) {
        // Method implementation
    }
}