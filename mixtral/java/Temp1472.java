import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class User {
    private int admin;
    private int user;
    private String name;

    public User(int admin, int user, String name) {
        this.admin = admin;
        this.user = user;
        this.name = name;
    }

    public int getAdmin() {
        return admin;
    }

    public int getUser() {
        return user;
    }

    public String getName() {
        return name;
    }
}

class SimpleGrantedAuthority {
    private String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "SimpleGrantedAuthority{" +
                "role='" + role + '\'' +
                '}';
    }
}

class AuthorityMapping {
    private String fieldName;
    private String role;

    private AuthorityMapping(String fieldName, String role) {
        this.fieldName = fieldName;
        this.role = role;
    }

    public static AuthorityMapping fromFieldName(String fieldName) {
        switch (fieldName) {
            case "admin":
                return new AuthorityMapping(fieldName, "ROLE_ADMIN");
            case "user":
                return new AuthorityMapping(fieldName, "ROLE_USER");
            default:
                return null;
        }
    }

    public String getRole() {
        return role;
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User(1, 0, "John Doe");

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Field field : User.class.getDeclaredFields()) {
            if (!field.getType().equals(int.class)) continue;

            AuthorityMapping mapping = AuthorityMapping.fromFieldName(field.getName());

            field.setAccessible(true); // Make private fields accessible
            try {
                int value = field.getInt(user);

                if (value == 1 && mapping != null)
                    authorities.add(new SimpleGrantedAuthority(mapping.getRole()));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        for (SimpleGrantedAuthority authority : authorities) {
            System.out.println(authority);
        }
    }
}