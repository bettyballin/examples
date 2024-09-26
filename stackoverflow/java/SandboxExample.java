import delight.nashornsandbox.NashornSandbox;
import delight.nashornsandbox.NashornSandboxes;

public class SandboxExample {
    public static void main(String[] args) {
        NashornSandbox sandbox = NashornSandboxes.create();
        sandbox.allow(File.class);  
        try {
            sandbox.eval("var File = Java.type('java.io.File'); File;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}