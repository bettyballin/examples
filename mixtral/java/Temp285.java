import java.util.ArrayList;
import java.util.List;

public class Temp285 {
    public static void main(String[] args) {
        Temp285 temp = new Temp285();
        try {
            List<Local> locales = temp.findLoggedInUsersLocals("user_login");
            System.out.println("Locales: " + locales);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Local> findLoggedInUsersLocals(String login) {
        User user = getUser(login);

        if (user != null && user.getUserLocaleList() != null && !user.getUserLocaleList().isEmpty()) {
            return new ArrayList<>(user.getUserLocaleList());
        }

        throw new RuntimeException("No locales found for the logged-in user.");
    }

    private User getUser(String login) {
        // Mock implementation for testing
        if ("user_login".equals(login)) {
            User user = new User();
            user.addLocale(new Local("en_US"));
            return user;
        }
        return null;
    }

    class User {
        private List<Local> userLocaleList = new ArrayList<>();

        public List<Local> getUserLocaleList() {
            return userLocaleList;
        }

        public void addLocale(Local locale) {
            userLocaleList.add(locale);
        }
    }

    class Local {
        private String locale;

        public Local(String locale) {
            this.locale = locale;
        }

        @Override
        public String toString() {
            return locale;
        }
    }
}