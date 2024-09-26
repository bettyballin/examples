public class Temp1976 {
    public static void main(String[] args) {
        Temp1976 obj = new Temp1976();
        obj.checkPackageAccess("java.lang.reflect");
    }

    public void checkPackageAccess(String pkg) {
        // don't allow the use of the reflection package
        if (pkg.equals("java.lang.reflect")) {
            throw new SecurityException("Reflection is not allowed!");
        }
    }
}