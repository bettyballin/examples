package testSwing;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;

public class WindowsClassicLookAndFeelExt extends WindowsClassicLookAndFeel {
    @Override 
    protected void initClassDefaults(UIDefaults table){
        super.initClassDefaults(table);
        Object[] uiDefaults = { "LabelUI", WindowsLabelExtUI.class.getCanonicalName() };
        table.putDefaults(uiDefaults);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsClassicLookAndFeelExt());
            // Create a simple GUI to test the look and feel
            javax.swing.JFrame frame = new javax.swing.JFrame("Test Swing");
            javax.swing.JLabel label = new javax.swing.JLabel("Hello, World!");
            frame.getContentPane().add(label);
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}

class WindowsLabelExtUI extends javax.swing.plaf.basic.BasicLabelUI {
    // Custom UI implementation
}