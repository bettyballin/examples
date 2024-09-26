public class Temp1362 {
    public static void main(String[] args) {
        String script = "Java.perform(function() {"
                + "    var eType = Java.use('e.a.x.e');"
                + "    console.log(eType.$cast(this).a);"
                + "});";

        executeFridaScript(script);
    }

    private static void executeFridaScript(String script) {
        System.out.println("Executing Frida script: " + script);
    }
}