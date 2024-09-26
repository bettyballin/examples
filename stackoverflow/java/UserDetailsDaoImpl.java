public class UserDetailsDaoImpl {

    private static String emailsBlocked;

    public static void setEmailsBlocked(String emailsBlocked){
        UserDetailsDaoImpl.emailsBlocked = emailsBlocked;
    }
}