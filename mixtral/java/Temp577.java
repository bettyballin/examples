import com.sun.jna.Native;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class TestClass {
    public interface IHelper {
        // Define the methods for the IHelper interface here
    }
    
    private IHelper pHelper;
    
    public String Test() {
        return AccessController.doPrivileged(new PrivilegedAction<String>() {
            @Override
            public String run() {
                pHelper = (IHelper) Native.loadLibrary("Helper", IHelper.class);
                
                // Perform other privileged actions here if needed

                return "test";
            }
        });
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        System.out.println(testClass.Test());
    }
}