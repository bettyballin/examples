public class Temp2569 {
    public static void main(String[] args) {
        System.setProperty("JAVAWS_TRACE_NATIVE", "1");
        System.setProperty("JAVA_TOOL_OPTIONS", "-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000");
        
        try {
            Runtime.getRuntime().exec("javaws myjnlp.jnlp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}