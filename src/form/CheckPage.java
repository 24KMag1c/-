package form;

import javax.swing.*;

import Manage.M_Customerexec;
import item.*;

public class CheckPage {
    private JPanel checkPanel;
    private JTextField ID;
    private JButton checkButton;
    private JLabel outtext;
    private JTextArea route;

    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckPage");
        frame.setContentPane(new CheckPage().checkPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public CheckPage() {
        M_Customerexec exec_cust = new M_Customerexec();
        checkButton.addActionListener(e -> {
            String id = ID.getText();
            Customer customer = exec_cust.findById(id);
            route.setText(exec_cust.routeout(customer));
            boolean flag = exec_cust.check(customer);
            if(flag==true){
                outtext.setText("Completed!");
            }
            else outtext.setText("Uncompleted!");
        });
    }
    public JPanel getPanel() {
        return checkPanel;
    }
}
