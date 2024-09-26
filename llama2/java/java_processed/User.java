// User.java

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public boolean hasPermission(String permission, Item item) {
        // Dummy permission check logic
        return "allowed_permission".equals(permission) && "allowed_item".equals(item.getName());
    }

    public String getName() {
        return name;
    }
}

// Item.java

public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// GrantedAuthority.java

public interface GrantedAuthority {
    boolean isPermitted(String permission);
    boolean isAssignable();
}

// CustomGrantedAuthority.java

public class CustomGrantedAuthority implements GrantedAuthority {
    private final User user;
    private final Item item;

    public CustomGrantedAuthority(User user, Item item) {
        this.user = user;
        this.item = item;
    }

    @Override
    public boolean isPermitted(String permission) {
        // Check if the user has the required permission for the item
        return user.hasPermission(permission, item);
    }

    @Override
    public boolean isAssignable() {
        // This method is not used in this example
        return false;
    }

    public static void main(String[] args) {
        User user = new User("Alice");
        Item item = new Item("allowed_item");

        CustomGrantedAuthority authority = new CustomGrantedAuthority(user, item);

        System.out.println("Is permitted: " + authority.isPermitted("allowed_permission"));
        System.out.println("Is permitted: " + authority.isPermitted("denied_permission"));
    }
}
```

```bash
javac User.java Item.java GrantedAuthority.java CustomGrantedAuthority.java
java CustomGrantedAuthority