import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1400 {

    public static void main(String[] args) {
        Temp1400 temp = new Temp1400();
        Widget widget = temp.getWidgetById(1L);
        System.out.println(widget);
    }

    @PostAuthorize("returnObject.owner.id == principal.id")
    public Widget getWidgetById(long id) {
        // Mock implementation
        Widget widget = new Widget();
        widget.setId(id);
        widget.setOwner(new User(1L)); // Assume the logged-in user has id 1
        return widget;
    }

}

class Widget {
    private long id;
    private User owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Widget{id=" + id + ", owner=" + owner + "}";
    }
}

class User {
    private long id;

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{id=" + id + "}";
    }
}