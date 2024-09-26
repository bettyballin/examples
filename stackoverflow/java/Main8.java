import javax.swing.*;
import java.awt.*;

public class Main8 {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("JList Test");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] selections = {"<html><img src='http://invalid/url'>", "<html><h1>Hello</h1></html>", "orange", "dark blue"};

        JList<String> list = new JList<>(selections);

        list.setSelectedIndex(1);
        System.out.println(list.getSelectedValue());

        JLabel jLabel = new JLabel("<html><h2>Standard Label</h2></html>");
        frame.add(new JScrollPane(list));
        frame.add(jLabel);
        frame.pack();

        frame.setVisible(true);
    }
}