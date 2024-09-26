package testSwing;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ComponentUI;
import com.sun.java.swing.plaf.windows.WindowsLabelUI;

public class WindowsLabelExtUI extends WindowsLabelUI {
    static WindowsLabelExtUI singleton = new WindowsLabelExtUI();

    public static ComponentUI createUI(JComponent c) {
        c.putClientProperty("html.disable", Boolean.TRUE);
        return singleton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test WindowsLabelExtUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel label = new JLabel("This is a test label");
            label.setUI(WindowsLabelExtUI.createUI(label));
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
        });
    }
}