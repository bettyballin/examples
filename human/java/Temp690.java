import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlafChanger extends JApplet {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboBox;

    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't complete successfully");
        }
    }

    private void createGUI() {
        setLayout(new BorderLayout());

        UIManager.LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
        String[] plafNames = new String[plafs.length];
        for (int i = 0; i < plafs.length; i++) {
            plafNames[i] = plafs[i].getName();
        }

        comboBox = new JComboBox<>(plafNames);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = comboBox.getSelectedIndex();
                try {
                    UIManager.setLookAndFeel(plafs[index].getClassName());
                    SwingUtilities.updateComponentTreeUI(PlafChanger.this);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(comboBox, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PlafChanger");
        PlafChanger applet = new PlafChanger();
        applet.init();
        frame.getContentPane().add(applet);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}