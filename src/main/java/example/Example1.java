package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example1 {
    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root";
        String database = "example1";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url+database,user,password);
            if (conn!=null){
                System.out.println("connected to Mysql database");
            }
        }catch (SQLException e){
            System.out.println("Sql error: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("error: "+e.getMessage());
        }
    }
}
