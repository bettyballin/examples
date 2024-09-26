import javax.script.*;

public class RestrictedScriptEngine {
    
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {
            engine.eval("print('Hello, World!');");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}