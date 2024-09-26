import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.hibernate.SessionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
@Transactional
public class TodoDao implements ITodoDao  {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Override
    @PreAuthorize("authentication.principal == #todo.user")
    public void changeTodoStatus(Todo todo) {
        todo.setDone(!todo.isDone());
        sessionFactory.getCurrentSession().update(todo);
    }
}

interface ITodoDao {
    void changeTodoStatus(Todo todo);
}

class Todo {
    private String user;
    private boolean done;

    // Getters and setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

@Component
class AuthenticationFacade {
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}