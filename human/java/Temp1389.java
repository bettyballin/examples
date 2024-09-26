import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temp1389 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel fnameLabel = new JLabel("First name:");
        JTextField fnameField = new JTextField();
        JLabel lnameLabel = new JLabel("Last name:");
        JTextField lnameField = new JTextField();
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = fnameField.getText();
                String lname = lnameField.getText();
                JOptionPane.showMessageDialog(frame, "First name: " + fname + "\nLast name: " + lname);
            }
        });

        frame.add(fnameLabel);
        frame.add(fnameField);
        frame.add(lnameLabel);
        frame.add(lnameField);
        frame.add(submitButton);

        frame.setVisible(true);
    }
}