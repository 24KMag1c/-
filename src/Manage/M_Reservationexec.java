package Manage;
import item.Customer;
import item.Reservation;

import java.sql.*;
import java.util.ArrayList;
public class M_Reservationexec implements M_Reservation{
    @Override
    public ArrayList<Reservation> findAll() {

        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<Reservation> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM RESERVATIONS";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String custName = rs.getString("custName");
                Integer resvType = rs.getInt("resvType");
                String resvKey = rs.getString("resvKey");

                Reservation reservation = new Reservation(custName, resvType, resvKey);
                list.add(reservation);

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
    public ArrayList<Reservation> findByCust(String cusName){
        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<Reservation> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM RESERVATIONS WHERE custName = '" +cusName + "' ";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String custName = rs.getString("custName");
                Integer resvType = rs.getInt("resvType");
                String resvKey = rs.getString("resvKey");

                Reservation reservation = new Reservation(custName, resvType, resvKey);
                list.add(reservation);

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
    };
    @Override
    public int AddRes(Reservation reservation){
        Connection com = null;
        Statement stat = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "INSERT INTO RESERVATIONS VALUES ('" + reservation.getCustName() + "','" + reservation.getResvType() + "','" + reservation.getResvKey() + "')";
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
}
