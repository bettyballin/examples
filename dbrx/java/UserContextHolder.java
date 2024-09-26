public final class UserContextHolder {
    private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void set(User user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static User get() {
        return USER_THREAD_LOCAL.get();
    }

    public static void clear() {
        USER_THREAD_LOCAL.remove();
    }

    public static void main(String[] args) {
        User user = new User("JohnDoe", "john.doe@example.com");
        UserContextHolder.set(user);
        
        System.out.println("Current User: " + UserContextHolder.get());

        UserContextHolder.clear();
        System.out.println("User after clear: " + UserContextHolder.get());
    }
}

class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}