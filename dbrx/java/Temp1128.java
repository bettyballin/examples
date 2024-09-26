import javax.script.*;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

public class ScriptEngineExample {
    public static void main(String[] args) {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");

            AccessControlContext context = AccessController.doPrivileged(new PrivilegedAction<AccessControlContext>() {
                public AccessControlContext run() {
                    return (new AccessControlContext(new ProtectionDomain[] { new ProtectionDomain(null, null) }));
                }
            });

            engine.eval("javax.swing.JOptionPane.showMessageDialog(null, 'Hello Server!');", new SimpleBindings());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}