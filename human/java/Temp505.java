import java.util.Date;

public class Temp505 {
    public static void main(String[] args) {
        Temp505 temp = new Temp505();
        // This is just a placeholder. You need to call the authenticate method with actual parameters.
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        User user = null;
        if (username != null) {
            user = getUserRepository().findByUserName(username);
            if (user != null) {
                if (user.getEnabled() != 0) {
                    if ((user.getUserDetail().getConfirmed() != 0)
                            || ((new Date().getTime() - user.getUserDetail().getRequestDate().getTime())
                                    / (1000 * 60 * 60 * 24)) <= getUnconfirmedDays()) {
                        if (getPasswordEncoder().isPasswordValid(user.getPassword(),
                                (String) authentication.getCredentials(), user)) {
                            user.authenticated = true;
                            user.getAuthorities();
                        } else {
                            throw new BadCredentialsException("Password incorrect");
                        }
                    } else {
                        throw new UserNotConfirmedAndTimeExceeded(
                                "User has not been confirmed in the established time period");
                    }
                } else {
                    throw new DisabledException("User is disabled");
                }
            } else {
                throw new BadCredentialsException("User does not exist");
            }
        } else {
            throw new AuthenticationCredentialsNotFoundException("No credentials found in context");
        }
        return user;
    }

    // Placeholder methods and classes for compilation. You should replace these with actual implementations.
    private UserRepository getUserRepository() {
        return new UserRepository();
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder();
    }

    private int getUnconfirmedDays() {
        return 7; // Example value
    }

    // Placeholder classes to enable compilation. You should replace these with actual implementations.
    class Authentication {
        public Object getPrincipal() {
            return null;
        }

        public Object getCredentials() {
            return null;
        }
    }

    class User {
        private String password;
        private boolean authenticated;

        public String getPassword() {
            return password;
        }

        public int getEnabled() {
            return 1;
        }

        public UserDetail getUserDetail() {
            return new UserDetail();
        }

        public void getAuthorities() {
        }
    }

    class UserDetail {
        public int getConfirmed() {
            return 1;
        }

        public Date getRequestDate() {
            return new Date();
        }
    }

    class UserRepository {
        public User findByUserName(String username) {
            return new User();
        }
    }

    class PasswordEncoder {
        public boolean isPasswordValid(String password, String credentials, User user) {
            return true;
        }
    }

    class AuthenticationException extends Exception {
    }

    class BadCredentialsException extends AuthenticationException {
        public BadCredentialsException(String message) {
            super(message);
        }
    }

    class DisabledException extends AuthenticationException {
        public DisabledException(String message) {
            super(message);
        }
    }

    class UserNotConfirmedAndTimeExceeded extends AuthenticationException {
        public UserNotConfirmedAndTimeExceeded(String message) {
            super(message);
        }
    }

    class AuthenticationCredentialsNotFoundException extends AuthenticationException {
        public AuthenticationCredentialsNotFoundException(String message) {
            super(message);
        }
    }
}