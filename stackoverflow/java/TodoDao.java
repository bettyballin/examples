import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;

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
    @PreAuthorize("isAuthenticated() and @authenticationFacade.hasPermission(#todo)")
    public void changeTodoStatus(Todo todo) {
        sessionFactory.getCurrentSession().update(todo);
    }
}