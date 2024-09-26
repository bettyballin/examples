// Assuming that ConcurrentSessionControlStrategy is a user-defined class and getMaximumSessionsForThisUser() is a static method of it.
// Also assuming that the method does not require any parameters to be passed.

public class YourMainClass {

    public static void main(String[] args) {
        int maximumSessions = ConcurrentSessionControlStrategy.getMaximumSessionsForThisUser();
        System.out.println("Maximum sessions for this user: " + maximumSessions);
    }
}