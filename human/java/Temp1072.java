public class MainClassName {
    public static void main(String[] args) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String className = stackTraceElements[stackTraceElements.length - 1].getClassName();
        if (className.contains("MainClassName")) {
            System.out.println("Class name contains 'MainClassName'");
        }
    }
}