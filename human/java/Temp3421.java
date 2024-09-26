import javax.swing.*;
import java.awt.*;

public class CountrySelector {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CountrySelector::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Country Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Country:");
        panel.add(label, gbc);

        gbc.gridx = 1;

        JTextField countryInput = new JTextField(15);
        countryInput.setToolTipText("Enter country");
        countryInput.setPreferredSize(new Dimension(200, 25));
        countryInput.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(countryInput, gbc);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}