package form;

import Manage.M_Busexec;
import Manage.*;
import item.Bus;
import item.Customer;

import javax.swing.*;

public class BookPage {
    private JPanel bookPanel;
    private JTextField businput;
    private JTextField hotelinput;
    private JTextField flightinput;
    private JButton bookbus;
    private JButton bookhotel;
    private JButton bookflight;
    private JLabel Bus;
    private JLabel Hotel;
    private JLabel Flight;
    private JTextField inputYourIDTextField;
    private JLabel Result;
    private JLabel titleresult;

    public static void main(String[] args) {
        JFrame frame = new JFrame("BookPage");
        frame.setContentPane(new BookPage().bookPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public JPanel getPanel(){
        return bookPanel;
    }
    public BookPage() {
        bookbus.addActionListener(e -> {
            M_Customerexec exec_cust = new M_Customerexec();
            Customer cust = exec_cust.findById(inputYourIDTextField.getText());
            int result = exec_cust.resvbusandhotel(cust, businput.getText(), "bus");
            if (result != 0) {
                Result.setText("Successful!");
            } else {
                Result.setText("Unsuccessful!");
            }
        });
        bookhotel.addActionListener(e -> {
            M_Customerexec exec_cust = new M_Customerexec();
            Customer cust = exec_cust.findById(inputYourIDTextField.getText());
            int result = exec_cust.resvbusandhotel(cust, businput.getText(), "hotel");
            if (result != 0) {
                Result.setText("Successful!");
            } else {
                Result.setText("Unsuccessful!");
            }
        });
        bookflight.addActionListener(e -> {
            M_Customerexec exec_cust = new M_Customerexec();
            Customer cust = exec_cust.findById(inputYourIDTextField.getText());
            int result = exec_cust.resvflight(cust, flightinput.getText());
            if (result != 0) {
                Result.setText("Successful!");
            } else {
                Result.setText("Unsuccessful!");
            }
        });
    }
}
