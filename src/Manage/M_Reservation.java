package Manage;

import item.Hotel;
import item.Reservation;
import item.Customer;

import java.util.ArrayList;
public interface M_Reservation {
    public abstract ArrayList<Reservation> findAll();

    public abstract ArrayList<Reservation> findByCust(String cusName);
    public abstract int AddRes(Reservation reservation);
}
