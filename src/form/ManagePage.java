package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagePage {
    private JPanel managePanel;
    private JButton Bus;
    private JButton Hotel;
    private JButton Flight;
    private JButton Customer;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ManagePage");
        frame.setContentPane(new ManagePage().managePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public JPanel getPanel(){
        return managePanel;
    }
    public ManagePage(){
        Bus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开预订界面
                JFrame bookFrame = new JFrame("ManageBus");
                bookFrame.setContentPane(new ManageBus().getPanel());
                bookFrame.pack();
                bookFrame.setVisible(true);
            }
        });

        Hotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开查询界面
                JFrame queryFrame = new JFrame("ManageHotel");
                queryFrame.setContentPane(new ManageHotel().getPanel());
                queryFrame.pack();
                queryFrame.setVisible(true);
            }
        });
        Flight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开查询界面
                JFrame queryFrame = new JFrame("ManageFlight");
                queryFrame.setContentPane(new ManageFlight().getPanel());
                queryFrame.pack();
                queryFrame.setVisible(true);
            }
        });
        Customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开查询界面
                JFrame queryFrame = new JFrame("ManageCustomer");
                queryFrame.setContentPane(new ManageCustomer().getPanel());
                queryFrame.pack();
                queryFrame.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
