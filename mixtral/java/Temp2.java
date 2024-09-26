public class Temp2 {
    public static void main(String[] args) {
        // Sample implementation of AttemptService
        AttemptService attemptService = new AttemptServiceImpl();
        
        // Example usage
        String username = "user1";
        attemptService.saveFailedAttempt(username);
        System.out.println("Number of failed attempts today: " + attemptService.getNumberOfFailedAttempsTodayByUsername(username));
        System.out.println("Is blocked: " + attemptService.isBlocked(username));
    }

    public interface AttemptService {
        void saveFailedAttempt(String username);

        int getNumberOfFailedAttempsTodayByUsername(String username);

        boolean isBlocked(String username);

        // Other methods for managing and resetting attempts
    }

    static class AttemptServiceImpl implements AttemptService {
        private int failedAttempts = 0;
        
        @Override
        public void saveFailedAttempt(String username) {
            failedAttempts++;
            System.out.println("Failed attempt for user: " + username);
        }

        @Override
        public int getNumberOfFailedAttempsTodayByUsername(String username) {
            return failedAttempts;
        }

        @Override
        public boolean isBlocked(String username) {
            return failedAttempts >= 3;
        }
    }
}