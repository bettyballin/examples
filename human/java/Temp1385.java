public class Temp1385 {
    private static String emails_blocked;

    public static void main(String[] args) {
        setEmails_Blocked("example@example.com");
        System.out.println("Emails Blocked: " + emails_blocked);
    }

    public static void setEmails_Blocked(String emails_blocked) {
        Temp1385.emails_blocked = emails_blocked;
    }
}