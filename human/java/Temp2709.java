import org.springframework.security.access.prepost.PreAuthorize;

public class Temp2709 {

    public static void main(String[] args) {
        Temp2709 temp = new Temp2709();
        User authUser = new User(1);
        System.out.println(temp.sampleMethod(authUser, 1));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or #authUser.id == #userId")
    public boolean sampleMethod(User authUser, int userId) {
        // Method logic
        return true;
    }

    static class User {
        int id;

        public User(int id) {
            this.id = id;
        }
    }
}