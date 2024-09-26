import javax.swing.JComponent;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.basic.BasicLabelUI;

public class WindowsLabelExtUI extends BasicLabelUI {
    private static final WindowsLabelExtUI singleton = new WindowsLabelExtUI();

    public static ComponentUI createUI(JComponent c) {
        c.putClientProperty("html.disable", Boolean.TRUE);
        return singleton;
    }
}