package Manage;

import item.Flight;

import java.sql.*;
import java.util.ArrayList;
public class M_Flightexec implements M_Flight {
    @Override
    public ArrayList<Flight> findAll() {

        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<Flight> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM FLIGHTS";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String flightNum = rs.getString("flightNum");
                Integer price = rs.getInt("price");
                Integer numSeats = rs.getInt("numSeats");
                Integer numAvail = rs.getInt("numAvail");
                String FromCity = rs.getString("FromCity");
                String ArivCity = rs.getString("ArivCity");

                Flight flight = new Flight(flightNum, price, numSeats, numAvail,FromCity,ArivCity);
                list.add(flight);

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
    public Flight findByflNum(String flightNum) {
        Flight flight = new Flight();
        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        // ArrayList<Flight> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM FLIGHTS WHERE flightNum = '"+flightNum+"' ";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String FlightNum= rs.getString("flightNum");
                Integer price = rs.getInt("price");
                Integer numSeats = rs.getInt("numSeats");
                Integer numAvail = rs.getInt("numAvail");
                String Fromcity = rs.getString("Fromcity");
                String ArivCity = rs.getString("ArivCity");

                flight.setFlightNum(FlightNum);
                flight.setPrice(price);
                flight.setNumSeats(numSeats);
                flight.setNumAvail(numAvail);
                flight.setFromCity(Fromcity);
                flight.setArivCity(ArivCity);
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
        return flight;
    }

    @Override
    public int insert(Flight flight) {
        Connection com = null;
        Statement stat = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();

            String sql = "INSERT INTO FLIGHTS VALUES ('" + flight.getFlightNum() + "','" + flight.getPrice() + "','" + flight.getNumSeats() + "','" + flight.getNumAvail() + flight.getFromCity() + flight.getArivCity() + "')";
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
    public int update(Flight flight) {
        Connection com = null;
        Statement stat = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "UPDATE FLIGHTS SET price = '" + flight.getPrice() + "', numSeats = '" + flight.getNumSeats() + "', numAvail = '" + flight.getNumAvail() + "' WHERE flightNum = '" + flight.getFlightNum() + "'";
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
    public ArrayList<Flight> findByCity(String FromCity,String ArivCity){
        Connection com = null;
        Statement stat = null;
        ResultSet rs = null;

        ArrayList<Flight> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/TRAVEL", "root", "1234");
            stat = com.createStatement();
            String sql = "SELECT * FROM FLIGHTS WHERE FromCity = '" + FromCity +"' AND ArivCity = '" + ArivCity +"'";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));

                String flightNum = rs.getString("flightNum");
                Integer price = rs.getInt("price");
                Integer numSeats = rs.getInt("numSeats");
                Integer numAvail = rs.getInt("numAvail");
                String From_City = rs.getString("FromCity");
                String Ariv_City = rs.getString("ArivCity");

                Flight flight = new Flight(flightNum, price, numSeats, numAvail,From_City,Ariv_City);
                list.add(flight);

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
}
