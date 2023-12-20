package form;

import Manage.M_Busexec;
import Manage.M_Customerexec;
import item.Bus;
import item.Customer;

import javax.swing.*;

public class ManageCustomer {
    private JPanel MCPanel;
    private JTextField custName;
    private JTextField custID;
    private JButton addButton;
    private JButton updateButton;
    private JLabel Result;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ManageCustomer");
        frame.setContentPane(new ManageCustomer().MCPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ManageCustomer() {
        addButton.addActionListener(e -> {
            M_Customerexec exec_cust = new M_Customerexec();
            String name = custName.getText();
            String ID = custID.getText();
            Customer cust = new Customer(name, ID);
            int res = exec_cust.insert(cust);
            if (res != 0) {
                Result.setText("Successful!");
            } else {
                Result.setText("Unsuccessful!");
            }
        });
        updateButton.addActionListener(e -> {
            M_Customerexec exec_cust = new M_Customerexec();
            String name = custName.getText();
            String ID = custID.getText();
            Customer cust = new Customer(name, ID);
            int res = exec_cust.insert(cust);
            if (res != 0) {
                Result.setText("Successful!");
            } else {
                Result.setText("Unsuccessful!");
            }
        });
    }
    public JPanel getPanel() {
        return MCPanel;
    }
}

