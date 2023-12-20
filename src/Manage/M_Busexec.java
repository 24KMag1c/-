package Manage;
import item.Bus;

import java.sql.*;
import java.util.ArrayList;

public class M_Busexec implements M_Bus {

    @Override
    public ArrayList<Bus> findAll() {

        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<Bus> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM BUS";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String location = rs.getString("location");
                Integer price = rs.getInt("price");
                Integer numBus = rs.getInt("numBus");
                Integer numAvail = rs.getInt("numAvail");

                Bus bus = new Bus(location, price, numBus, numAvail);
                list.add(bus);

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
    public Bus findByLocation(String Location) {
        Bus bus = new Bus();
        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        //ArrayList<Bus> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM BUS WHERE location = '"+Location+"' ";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String location = rs.getString("location");
                Integer price = rs.getInt("price");
                Integer numbus = rs.getInt("numBus");
                Integer numAvail = rs.getInt("numAvail");

                bus.setLocation(location);
                bus.setPrice(price);
                bus.setNumBus(numbus);
                bus.setNumAvail(numAvail);
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
        return bus;
    }

    @Override
    public int insert(Bus bus) {
        Connection com = null;
        Statement stat = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();

            String sql = "INSERT INTO BUS VALUES ('" + bus.getLocation() + "','" + bus.getPrice() + "','" + bus.getNumBus() + "','" + bus.getNumAvail() + "')";
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
    public int update(Bus bus) {
        Connection com = null;
        Statement stat = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "UPDATE BUS SET price = '" + bus.getPrice() + "', numBus = '" + bus.getNumBus() + "', numAvail = '" + bus.getNumAvail() + "' WHERE location = '" + bus.getLocation() + "'";
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