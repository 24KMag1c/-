package Manage;

import item.Customer;
import item.Flight;
import item.Reservation;
import Manage.M_Reservationexec;
import Manage.M_Reservation;
import java.util.*;

import java.sql.*;
import java.util.ArrayList;

public class M_Customerexec implements M_Customer{
    int fflag=0;
    int bflag=0;
    int hflag=0;
    @Override
    public ArrayList<Customer> findAll() {

        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<Customer> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM CUSTOMERS";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String custName = rs.getString("custName");
                String custID = rs.getString("custID");

                Customer customer = new Customer(custName,custID);
                list.add(customer);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (com != null) {
                try {
                    com.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public Customer findById(String custID) {
        Customer customer = new Customer();
        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        //ArrayList<Customer> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM CUSTOMERS WHERE custID = '"+custID+"' ";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String custName = rs.getString("custName");
                String CustID = rs.getString("custID");

                customer.setCustName(custName);
                customer.setCustID(CustID);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (com != null) {
                try {
                    com.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return customer;
    }

    @Override
    public int insert(Customer customer) {
        Connection com = null;
        Statement stat = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();

            String sql = "INSERT INTO CUSTOMERS VALUES ('" + customer.getCustName() + "','" + customer.getCustID() + "')";
            result = stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (com != null) {
                try {
                    com.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int update(Customer customer) {
        Connection com = null;
        Statement stat = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "UPDATE CUSTOMERS SET custName = '" + customer.getCustName() + "', custID = '" + customer.getCustID() + "' WHERE custName = '" + customer.getCustName() + "'";
            result = stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (com != null) {
                try {
                    com.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    @Override
    public int resvbusandhotel(Customer customer,String Ariv_location,String type) {
        Connection com = null;
        Statement stat = null;
        Reservation reservation = new Reservation();
        M_Reservation exec_res = new M_Reservationexec();
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "";
            if (type == "bus") {
                sql = "UPDATE BUS SET numAvail = numAvail-1 WHERE location = '" + Ariv_location + "'";
                reservation.setCustName(customer.getCustName());
                reservation.setResvType(3);
                String str = "bus" + bflag;
                reservation.setResvKey(customer.getCustID() + str + Ariv_location);
                bflag++;
                exec_res.AddRes(reservation);
            }
            else if (type == "hotel") {
                sql = "UPDATE HOTELS SET numAvail = numAvail-1 WHERE location = '" + Ariv_location + "'";
                reservation.setCustName(customer.getCustName());
                reservation.setResvType(2);
                String str = "hotel" + hflag;
                reservation.setResvKey(customer.getCustID() + str + Ariv_location);
                hflag++;
                exec_res.AddRes(reservation);
            }
            result = stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (com != null) {
                try {
                    com.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    };
    @Override
    public boolean check(Customer customer){
        M_Customerexec exec_cust = new M_Customerexec();
        String str = exec_cust.search(customer);
        Map<String,String> map = new HashMap<>();
        String[] trips = str.split("\n");
        Set<String> cities  = new HashSet<>();
        for(String trip : trips) {
            String[] parts = trip.trim().split(" to ");
            map.put(parts[0],parts[1]);
            cities.add(parts[0]);
        }
        if(map.size()!=cities.size()){
            return false;
        }
        String start = cities.iterator().next();
        String current = start;
        List<String> sortedTrips = new ArrayList<>();
        for(int i=0; i<cities.size(); i++){
            if(!map.containsKey(current)){
                return false;
            }
            String next = map.get(current);
            sortedTrips.add(current + " to " + next);
            current = next;
        }
        if(!current.equals(start)){
            return false;
        }
        String result="";
        for(String trip : sortedTrips){
            result+=trip+"\n";
        }
        return true;
    };
    @Override
    public int resvflight(Customer customer,String flightNum){
        Connection com = null;
        Statement stat = null;
        Reservation reservation = new Reservation();
        M_Reservation exec_res = new M_Reservationexec();
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "UPDATE FLIGHTS SET numAvail = numAvail-1 WHERE flightNum = '" + flightNum + "'";
            reservation.setCustName(customer.getCustName());
            reservation.setResvType(1);
            reservation.setResvKey(customer.getCustID() + "-" + flightNum);
            exec_res.AddRes(reservation);
            result = stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (com != null) {
                try {
                    com.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    };
    @Override
    public String search(Customer customer){
        Connection com = null;
        Statement stat = null;
        String str="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT DISTINCT F.FromCity, F.ArivCity FROM RESERVATIONS R INNER JOIN FLIGHTS F ON F.flightNum = SUBSTRING_INDEX(R.resvKey, '-', -1) WHERE R.custName = '" + customer.getCustName() + "' AND R.resvType = 1";
            ResultSet rs = stat.executeQuery(sql);
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                String fromCity = rs.getString("FromCity");
                String arivCity = rs.getString("ArivCity");
                sb.append(fromCity).append(" to ").append(arivCity);
            }
            str = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (com != null) {
                try {
                    com.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    };
    public String routeout(Customer customer){
        M_Customerexec exec_cust = new M_Customerexec();
        String str = exec_cust.search(customer);
        Map<String,String> map = new HashMap<>();
        String[] trips = str.split("\n");
        Set<String> cities  = new HashSet<>();
        for(String trip : trips) {
            String[] parts = trip.trim().split(" to ");
            map.put(parts[0],parts[1]);
            cities.add(parts[0]);
        }
        String start = cities.iterator().next();
        String current = start;
        List<String> sortedTrips = new ArrayList<>();
        for(int i=0; i<cities.size(); i++){
            String next = map.get(current);
            sortedTrips.add(current + " to " + next);
            current = next;
        }
        String result="";
        for(String trip : sortedTrips){
            result+=trip+"\n";
        }
        return result;
    }
}
