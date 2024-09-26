public class MySecurityManager1 extends SecurityManager {
    @Override
    public void checkExit(int status) {
        if (status != 0) {
            throw new SecurityException("System exit not allowed");
        }
    }
}