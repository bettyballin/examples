import org.mozilla.javascript.ClassShutter;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class RhinoSandboxExample {
    public static void main(String[] args) {
        Context ctx = Context.enter();
        try {
            Scriptable scope = ctx.initStandardObjects();

            // Set up a class shutter to prevent access to the Java API
            ctx.setClassShutter(new ClassShutter() {
                public boolean visibleToScripts(String className) {
                    return false; // No access to any Java classes
                }
            });

            // Execute your script within this context and scope
            // String yourScript = "...";
            // ctx.evaluateString(scope, yourScript, "script", 1, null);

        } finally {
            Context.exit();
        }
    }
}