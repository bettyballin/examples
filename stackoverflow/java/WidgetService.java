import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Component;

@Component
public class WidgetService {

    @PostAuthorize("returnObject.owner.id == principal.id")
    public Widget getWidgetById(long id) {
        // ... your database logic here

        // Stub return for compilation
        return new Widget();
    }

    // Placeholder inner class for Widget (for compilation purposes)
    public class Widget {
        private User owner;

        public User getOwner() {
            return owner;
        }

        // Placeholder inner class for User (for compilation purposes)
        public class User {
            private long id;

            public long getId() {
                return id;
            }
        }
    }
}