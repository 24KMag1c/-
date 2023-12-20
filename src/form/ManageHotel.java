package form;

import Manage.*;
import item.*;

import javax.swing.*;

public class ManageHotel {
    private JPanel MHPanel;
    private JTextField locationinput;
    private JTextField priceinput;
    private JTextField numRoominput;
    private JTextField numAvailinput;
    private JButton addButton;
    private JButton updateButton;
    private JLabel Result;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ManageHotel");
        frame.setContentPane(new ManageHotel().MHPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public ManageHotel(){
        addButton.addActionListener(e -> {
            M_Hotelexec exec_hotel = new M_Hotelexec();
            String location = locationinput.getText();
            int price = Integer.parseInt(priceinput.getText());
            int numRooms = Integer.parseInt(numRoominput.getText());
            int numAvail = Integer.parseInt(numAvailinput.getText());
            Hotel hotel  = new Hotel(location,price,numRooms,numAvail);
            int res = exec_hotel.insert(hotel);
            if(res!=0){
                Result.setText("Successful!");
            }else{
                Result.setText("Unsuccessful!");
            }
        });
        updateButton.addActionListener(e -> {
            M_Hotelexec exec_hotel = new M_Hotelexec();
            String location = locationinput.getText();
            int price = Integer.parseInt(priceinput.getText());
            int numRooms = Integer.parseInt(numRoominput.getText());
            int numAvail = Integer.parseInt(numAvailinput.getText());
            Hotel hotel  = new Hotel(location,price,numRooms,numAvail);
            int res = exec_hotel.insert(hotel);
            if(res!=0){
                Result.setText("Successful!");
            }else{
                Result.setText("Unsuccessful!");
            }
        });
    }
    public JPanel getPanel() {
        return MHPanel;
    }
}
