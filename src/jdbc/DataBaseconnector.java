package jdbc;
import java.sql.DriverManager;
import java.sql.Connection;

public class DataBaseconnector {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://101.200.84.247:3306/BANK051" , "root", "1234");

    }
}
