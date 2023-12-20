package form;

import Manage.*;
import item.*;

import javax.swing.*;
import java.util.ArrayList;

public class QueryPage {
    private JPanel queryPanel;
    private JTextField Buslocation;
    private JButton queryBus;
    private JButton queryHotel;
    private JButton queryFlight;
    private JButton queryCustomer;
    private JTextField Hotellocation;
    private JTextField CustomerID;
    private JLabel Busout;
    private JLabel Hotelout;
    private JTextArea Flightout;
    private JTextArea Customerout;
    private JTextField FromCityinput;
    private JTextField ArivCityinput;

    public static void main(String[] args) {
        JFrame frame = new JFrame("QueryPage");
        frame.setContentPane(new QueryPage().queryPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public QueryPage(){
        Buslocation.setText("Input the location");
        queryBus.addActionListener(e -> {
            M_Busexec exec_bus = new M_Busexec();
            String query = Buslocation.getText();
            Bus bus = exec_bus.findByLocation(query);
            Busout.setText("location:"+bus.getLocation()+", numBus:"+bus.getNumBus()+", Price:"+bus.getPrice()+", numAvail:"+bus.getNumAvail());
        });
        Hotellocation.setText("Input the location");
        queryHotel.addActionListener(e -> {
            M_Hotelexec exec_hotel = new M_Hotelexec();
            String query = Hotellocation.getText();
            Hotel hotel = exec_hotel.findByLocation(query);
            Hotelout.setText("location:"+hotel.getLocation()+", numRooms:"+hotel.getNumRooms()+", Price:"+hotel.getPrice()+", numAvail:"+hotel.getNumAvail());
        });
        queryFlight.addActionListener(e -> {
            M_Flightexec exec_flight = new M_Flightexec();
            String queryfrom = FromCityinput.getText();
            String queryAriv = ArivCityinput.getText();
            ArrayList<Flight> list_flight = exec_flight.findByCity(queryfrom,queryAriv);
            String result = "";
            for(Flight  fli : list_flight){
                String res = "num:"+fli.getFlightNum()+" Price:"+fli.getPrice()+" numAvial: "+fli.getNumAvail();
                result+=res+"\n";
            }
            Flightout.setText(result);
        });
        CustomerID.setText("Input your ID");
        queryCustomer.addActionListener(e -> {
            M_Customerexec exec_customer = new M_Customerexec();
            M_Reservationexec exec_resv = new M_Reservationexec();
            String query = CustomerID.getText();
            Customer customer = exec_customer.findById(query);
            String str = customer.getCustName();
            ArrayList<Reservation> list = exec_resv.findByCust(str);
            String result = "";
            for (Reservation resv : list){
                String res = String.valueOf(resv.getResvType());
                result +=resv.getCustName()+","+res+","+resv.getResvKey()+"\n";
            }
            Customerout.setText(result);
        });
    }
    public JPanel getPanel(){
        return queryPanel;
    }
}
