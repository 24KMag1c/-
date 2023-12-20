package Manage;

import item.Flight;

import java.util.ArrayList;

public interface M_Flight {
    public abstract ArrayList<Flight> findAll();

    public abstract Flight findByflNum(String flightNum);
    public abstract ArrayList<Flight> findByCity(String FromCity,String ArivCity);

    public abstract int insert(Flight flight);

    public abstract int update(Flight flight);

}

