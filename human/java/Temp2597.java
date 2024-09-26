import com.google.common.collect.ImmutableList;
import delight.nashornsandbox.NashornSandbox;
import delight.nashornsandbox.NashornSandboxes;
import delight.nashornsandbox.exceptions.ScriptCPUAbuseException;
import jdk.nashorn.api.scripting.NashornScriptEngine;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import java.io.File;
import java.util.concurrent.Executors;

public class NashornExample {
    public static void main(String[] args) {
        NashornSandbox sandbox = NashornSandboxes.create();
        
        // Configuring the sandbox
        sandbox.setMaxCPUTime(1000); // 1 second
        sandbox.setMaxMemory(50 * 1024 * 1024); // 50 MB
        sandbox.setExecutor(Executors.newSingleThreadExecutor());
        
        // Allowing the File class
        sandbox.allow(File.class);
        
        try {
            // Evaluating the script
            Object result = sandbox.eval("var File = Java.type('java.io.File'); File;");
            System.out.println(result);
        } catch (ScriptCPUAbuseException e) {
            System.out.println("Script took too long to execute.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}