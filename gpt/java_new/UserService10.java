import org.springframework.transaction.annotation.Transactional;

public class UserService10 {

    // Assuming userRepo is defined and injected elsewhere in your class

    @Transactional
    public void bindStudentWithCoursesAfterRegistration(String email) {
        User user = userRepo.findFirstByEmail(email);
        if (user == null) {
            // Handle the case where the user is not found, perhaps throw an exception or log a warning
            return;
        }
        // ... rest of your logic
    }
}