import org.apache.rampart.handler.RampartReceiver;
import org.apache.rampart.handler.WSDoAllReceiver;
import org.apache.rampart.handler.PostDispatchVerificationHandler;

public class HandlerConfiguration {
    public static void main(String[] args) {
        System.out.println("Handler Configuration:");
        System.out.println("<InFaultFlow>");
        
        System.out.println("    <handler name=\"PolicyBasedSecurityInHandler\" class=\"" + RampartReceiver.class.getName() + "\">");
        System.out.println("        <order phase=\"Security\" phaseFirst=\"true\"/>");
        System.out.println("    </handler>");
        
        System.out.println("    <handler name=\"SecurityInHandler\" class=\"" + WSDoAllReceiver.class.getName() + "\">");
        System.out.println("        <order phase=\"Security\"/>");
        System.out.println("    </handler>");
        
        System.out.println("    <handler name=\"PostDispatchVerificationHandler\" class=\"" + PostDispatchVerificationHandler.class.getName() + "\">");
        System.out.println("        <order phase=\"Dispatch\" phaseLast=\"true\"/>");
        System.out.println("    </handler>");
        
        System.out.println("</InFaultFlow>");
    }
}