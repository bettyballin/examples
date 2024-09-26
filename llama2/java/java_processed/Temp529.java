public class Temp529 {
    public static void main(String[] args) {
        // Assuming this is part of a Frida script, it should be written in JavaScript and executed by Frida
        String script = "Java.perform(function () {" +
                        "  var Class_A_D = Java.use('a.d');" +
                        "  Class_A_D.b.implementation = function(){" +
                        "    var ret = this.a().toInt(); // cast to int" +
                        "    return ret;" +
                        " }" +
                        "});";
        
        // This part is just to print the script for verification
        System.out.println(script);
    }
}