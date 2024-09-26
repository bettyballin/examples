public class Temp979 {
    public static void main(String[] args) {
        // Example usage of UserService and its implementation
        UserService userService = new UserServiceImpl();
        RegistrationForm form = new RegistrationForm("example@example.com");
        
        try {
            User user = userService.registerNewUserAccount(form);
            System.out.println("User registered: " + user.getEmail());
        } catch (DuplicateEmailException e) {
            System.out.println("Duplicate email error: " + e.getMessage());
        }
    }

    public interface UserService {
        User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException;
    }

    public static class UserServiceImpl implements UserService {
        @Override
        public User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException {
            // Simulate checking for existing email
            if ("duplicate@example.com".equals(userAccountData.getEmail())) {
                throw new DuplicateEmailException("Email already exists");
            }
            // Simulate user creation
            return new User(userAccountData.getEmail());
        }
    }

    public static class RegistrationForm {
        private String email;

        public RegistrationForm(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
    }

    public static class User {
        private String email;

        public User(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
    }

    public static class DuplicateEmailException extends Exception {
        public DuplicateEmailException(String message) {
            super(message);
        }
    }
}