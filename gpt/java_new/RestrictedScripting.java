import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

// Define a class filter that disallows all imports
class NoClassFilter implements jdk.nashorn.api.scripting.ClassFilter {
    @Override
    public boolean exposeToScripts(String className) {
        return false;
    }
}

public class RestrictedScripting {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();

        // Get the Nashorn JavaScript engine
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // Set the class filter on the engine
        if (engine instanceof jdk.nashorn.api.scripting.NashornScriptEngine) {
            ((jdk.nashorn.api.scripting.NashornScriptEngine) engine).setClassFilter(new NoClassFilter());
        }
    }
}