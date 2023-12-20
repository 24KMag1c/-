package form;

import Manage.M_Busexec;
import item.Bus;

import javax.swing.*;

public class ManageBus {


    private JPanel MBPanel;
    private JLabel Title;
    private JTextField locationinput;
    private JTextField priceinput;
    private JTextField numBusinput;
    private JTextField numAvailinput;
    private JButton addButton;
    private JButton updateButton;
    private JLabel Result;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ManageBus");
        frame.setContentPane(new ManageBus().MBPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public ManageBus(){
        addButton.addActionListener(e -> {
            M_Busexec exec_bus = new M_Busexec();
            String location = locationinput.getText();
            int price = Integer.parseInt(priceinput.getText());
            int numBus = Integer.parseInt(numBusinput.getText());
            int numAvail = Integer.parseInt(numAvailinput.getText());
            Bus bus  = new Bus(location,price,numBus,numAvail);
            int res = exec_bus.insert(bus);
            if(res!=0){
                Result.setText("Successful!");
            }else{
                Result.setText("Unsuccessful!");
            }
        });
        updateButton.addActionListener(e -> {
            M_Busexec exec_bus = new M_Busexec();
            String location = locationinput.getText();
            int price = Integer.parseInt(priceinput.getText());
            int numBus = Integer.parseInt(numBusinput.getText());
            int numAvail = Integer.parseInt(numAvailinput.getText());
            Bus bus  = new Bus(location,price,numBus,numAvail);
            int res = exec_bus.update(bus);
            if(res!=0){
                Result.setText("Successful!");
            }else{
                Result.setText("Unsuccessful!");
            }
        });
    }
    public JPanel getPanel() {
        return MBPanel;
    }

}
