import java.util.List;

public class Temp787 {
    public static void main(String[] args) {
        Temp787 temp787 = new Temp787();
        List<UserDto> users = temp787.getAllUsers();
        // Do something with users
    }

    // Assuming PreAuthorize is part of a security framework, we'll comment it out
    //@PreAuthorize("hasRole('list_users_permission')")
    public List<UserDto> getAllUsers() {
        return doGetAllUsers();
    }

    public List<UserDto> doGetAllUsers() {
        // Mock implementation for demonstration
        return List.of(new UserDto("John Doe"), new UserDto("Jane Smith"));
    }
}

class UserDto {
    private String name;

    public UserDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                '}';
    }
}