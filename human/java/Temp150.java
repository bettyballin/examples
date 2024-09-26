public class Temp150 {
    public static void main(String[] args) {
        Temp150 temp = new Temp150();
        temp.exit(0);
    }

    public void exit(int status) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkExit(status);
        }
        System.exit(status);
    }
}