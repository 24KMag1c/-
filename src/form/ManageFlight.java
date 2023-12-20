package form;

import Manage.M_Busexec;
import Manage.M_Flightexec;
import item.*;

import javax.swing.*;

public class ManageFlight {
    private JPanel MFPanel;
    private JLabel title;
    private JTextField flightNuminput;
    private JTextField priceinput;
    private JTextField numSeatsinput;
    private JTextField numAvialinput;
    private JTextField FromCityinput;
    private JTextField ArivCityinput;
    private JButton AddButton;
    private JButton UpdateButton;
    private JLabel Result;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ManageFlight");
        frame.setContentPane(new ManageFlight().MFPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public ManageFlight(){
        AddButton.addActionListener(e -> {
            M_Flightexec exec_flight = new M_Flightexec();
            String flightNum = flightNuminput.getText();
            int price = Integer.parseInt(priceinput.getText());
            int numSeats = Integer.parseInt(numSeatsinput.getText());
            int numAvail = Integer.parseInt(numAvialinput.getText());
            String FromCity = FromCityinput.getText();
            String ArivCity = ArivCityinput.getText();
            Flight flight  = new Flight(flightNum,price,numSeats,numAvail,FromCity,ArivCity);
            int res = exec_flight.insert(flight);
            if(res!=0){
                Result.setText("Successful!");
            }else{
                Result.setText("Unsuccessful!");
            }
        });
        UpdateButton.addActionListener(e -> {
            M_Flightexec exec_flight = new M_Flightexec();
            String flightNum = flightNuminput.getText();
            int price = Integer.parseInt(priceinput.getText());
            int numSeats = Integer.parseInt(numSeatsinput.getText());
            int numAvail = Integer.parseInt(numAvialinput.getText());
            String FromCity = FromCityinput.getText();
            String ArivCity = ArivCityinput.getText();
            Flight flight  = new Flight(flightNum,price,numSeats,numAvail,FromCity,ArivCity);
            int res = exec_flight.update(flight);
            if(res!=0){
                Result.setText("Successful!");
            }else{
                Result.setText("Unsuccessful!");
            }
        });
    }
    public JPanel getPanel() {
        return MFPanel;
    }
}
