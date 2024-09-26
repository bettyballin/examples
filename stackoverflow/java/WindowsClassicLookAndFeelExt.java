import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLabelUI;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;

public class WindowsClassicLookAndFeelExt extends WindowsClassicLookAndFeel {
    @Override
    protected void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);
        final String className = BasicLabelUI.class.getName();
        Object[] uiDefaults = {"LabelUI", className};
        table.putDefaults(uiDefaults);
    }
}