public class Temp489 {
    public static void main(String[] args) {
        Temp489 temp = new Temp489();
        temp.registerNewSession("session123", new Object());
    }

    public void registerNewSession(String sessionId, Object principal) {
        System.out.println("Session ID: " + sessionId + ", Principal: " + principal.toString());
    }
}