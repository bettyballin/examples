import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class MySecureScriptEngine {
    public void execute(String script) throws Exception {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                try {
                    ScriptEngineManager factory = new ScriptEngineManager();
                    ScriptEngine engine = factory.getEngineByName("js"); // Changed from "JavaScript" to "js"
                    if (engine != null) {
                        engine.eval(script);
                    } else {
                        System.out.println("JavaScript engine not found");
                    }
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }
        });
    }

    public static void main(String[] args) {
        MySecureScriptEngine engine = new MySecureScriptEngine();
        try {
            engine.execute("print('Hello, World!');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}