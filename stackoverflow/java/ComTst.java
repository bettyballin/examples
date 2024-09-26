import java.util.Enumeration;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;

public class ComTst {
    public static void main(String[] args) {
        ComThread.InitMTA();
        try {
            ActiveXComponent wmi = new ActiveXComponent("winmgmts:\\\\.");
            Variant instances = wmi.invoke("InstancesOf", "Win32_SystemUsers");
            Enumeration<Variant> en = new EnumVariant(instances.toDispatch());
            while (en.hasMoreElements()) {
                Variant element = en.nextElement();
                ActiveXComponent bb = new ActiveXComponent(element.toDispatch());
                System.out.println(bb.getPropertyAsString("PartComponent"));
            }
        } finally {
            ComThread.Release();
        }
    }
}