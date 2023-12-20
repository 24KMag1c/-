package Manage;

import item.Customer;

import java.util.ArrayList;

public interface M_Customer {
    public abstract ArrayList<Customer> findAll();

    public abstract Customer findById(String custID);

    public abstract int insert(Customer customer);

    public abstract int update(Customer customer);
    public abstract int resvbusandhotel(Customer customer,String Ariv_location,String type);
    public abstract boolean check(Customer customer);
    public abstract int resvflight(Customer customer,String flightNum);
    public abstract String search(Customer customer);
    public abstract String routeout(Customer customer);
}

