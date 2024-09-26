import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// Assuming there is an AuthenticationFacade interface
interface AuthenticationFacade {
    Object getAuthentication();
}

// Assuming there is an ITodoDao interface
interface ITodoDao {
    void changeTodoStatus(Todo todo);
}

// Assuming there is a Todo class
class Todo {
    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

@Component
@Transactional
public class TodoDao implements ITodoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Override
    @PreAuthorize("@authenticationFacade.getAuthentication().getPrincipal().equals(#todo)") // Corrected the SpEL expression
    public void changeTodoStatus(Todo todo) {
        Object user = authenticationFacade.getAuthentication();
        todo.setDone(!todo.isDone());
        sessionFactory.getCurrentSession().update(todo);
    }
}