package Manage;
import item.Hotel;

import java.sql.*;
import java.util.ArrayList;
public class M_Hotelexec implements M_Hotel{
    @Override
    public ArrayList<Hotel> findAll() {

        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<Hotel> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM HOTELS";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String location = rs.getString("location");
                Integer price = rs.getInt("price");
                Integer numRooms = rs.getInt("numRooms");
                Integer numAvail = rs.getInt("numAvail");

                Hotel hotel = new Hotel(location, price, numRooms, numAvail);
                list.add(hotel);

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
    public Hotel findByLocation(String location) {
        Hotel hotel = new Hotel();
        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<Hotel> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM HOTELS WHERE location = '"+location+"' ";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String  Location = rs.getString("location");
                Integer price = rs.getInt("price");
                Integer numRooms = rs.getInt("numRooms");
                Integer numAvail = rs.getInt("numAvail");

                hotel.setLocation(Location);
                hotel.setPrice(price);
                hotel.setNumRooms(numRooms);
                hotel.setNumAvail(numAvail);
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
        return hotel;
    }

    @Override
    public int insert(Hotel hotel) {
        Connection com = null;
        Statement stat = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();

            String sql = "INSERT INTO HOTELS VALUES ('" + hotel.getLocation() + "','" + hotel.getPrice() + "','" + hotel.getNumRooms() + "','" + hotel.getNumAvail() + "')";
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
    public int update(Hotel hotel) {
        Connection com = null;
        Statement stat = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "UPDATE HOTELS SET price = '" + hotel.getPrice() + "', numRooms = '" + hotel.getNumRooms() + "', numAvail = '" + hotel.getNumAvail() + "' WHERE location = '" + hotel.getLocation() + "'";
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
