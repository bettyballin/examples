import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame{

    String passwordRules;

    JButton addLowerAndUpperCaseRuleButton;
    JButton deleteSelectedButton;
    JTextField addLowerAndUpperCaseRuleField;
    JCheckBox addLowerAndUpperCaseRuleBox;

    JList<String> rulesList;
    DefaultListModel<String> listModel;

    JTextField testPasswordField;
    JButton testPasswordButton;

    public Test(){
        this.setPreferredSize(new Dimension(900, 100));

        addLowerAndUpperCaseRuleField = new JTextField();
        addLowerAndUpperCaseRuleField.setText(String.valueOf(1));
        addLowerAndUpperCaseRuleField.setPreferredSize(new Dimension(30, 25));

        addLowerAndUpperCaseRuleBox = new JCheckBox();

        addLowerAndUpperCaseRuleButton = new JButton();
        addLowerAndUpperCaseRuleButton.setText("Add lower and upper rule");
        addLowerAndUpperCaseRuleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addLowerAndUpperCaseRule(Integer.valueOf(addLowerAndUpperCaseRuleField.getText()), addLowerAndUpperCaseRuleBox.isSelected());
            }
        });

        deleteSelectedButton = new JButton();
        deleteSelectedButton.setText("Delete selected");
        deleteSelectedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listModel.remove(rulesList.getSelectedIndex());
            }
        });


        rulesList = new JList<>();
        rulesList.setSize(new Dimension(250, 50));
        listModel = new DefaultListModel<>();
        rulesList.setModel(listModel);

        testPasswordField = new JTextField();
        testPasswordField.setPreferredSize(new Dimension(90, 25));
        testPasswordButton = new JButton("Check");
        testPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                passwordRules = testPasswordField.getText();
                boolean result = checkPassword(passwordRules);
                JOptionPane.showMessageDialog(null, "The password check returns " + result);
            }
        });

        this.add(addLowerAndUpperCaseRuleButton);
        this.add(addLowerAndUpperCaseRuleField);
        this.add(addLowerAndUpperCaseRuleBox);
        this.add(rulesList);
        this.add(deleteSelectedButton);
        this.add(new JLabel("Password to test: "));
        this.add(testPasswordField);
        this.add(testPasswordButton);

        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addLowerCaseRule(int length, boolean numbersAllowed){
        String rule;
        if(numbersAllowed){
            rule = "[a-z0-9]{" + length + "}";
        }else{
            rule = "[a-z]{" + length + "}";
        }
        listModel.addElement(rule);
    }

    private void addUpperCaseRule(int length, boolean numbersAllowed){
        String rule;
        if(numbersAllowed){
            rule = "[A-Z0-9]{" + length + "}";
        }else{
            rule = "[A-Z]{" + length + "}";
        }
        listModel.addElement(rule);
    }

    private void addLowerAndUpperCaseRule(int length, boolean numbersAllowed){
        String rule;
        if(numbersAllowed){
            rule = "[aA-zZ0-9]{" + length + "}";
        }else{
            rule = "[aA-zZ]{" + length + "}";
        }
        listModel.addElement(rule);
    }

    private boolean checkPassword(String password){
        StringBuilder rules = new StringBuilder();
        for(int i = 0; i < listModel.size(); i++){
            rules.append(listModel.get(i));
        }
        if (password.matches(rules.toString())) return true;
        return false;
    }

    public static void main(String[] args){
        Test test = new Test();
    }
}