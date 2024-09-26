public class Temp2576 {
    public static void main(String[] args) {
        Temp2576 temp = new Temp2576();
        temp.setExceptionIfMaximumExceeded(true);
        temp.setMaximumSessions(10);
    }

    public void setExceptionIfMaximumExceeded(boolean exceptionIfMaximumExceeded) {
        // Implementation here
        System.out.println("Exception if maximum exceeded: " + exceptionIfMaximumExceeded);
    }

    public void setMaximumSessions(int maximumSessions) {
        // Implementation here
        System.out.println("Maximum sessions: " + maximumSessions);
    }
}