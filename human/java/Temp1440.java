import javax.swing.*;
import java.awt.event.*;

public class Temp1440 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 60, 80, 25);
        panel.add(submitButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(150, 60, 80, 25);
        panel.add(clearButton);

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myClearAction();
            }
        });
    }

    private static void myClearAction() {
        System.out.println("Clear action performed");
    }
}