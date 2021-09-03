package example;

import java.sql.*;

public class DatabaseHelper {

    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final String DATABASE_NAME = "example1";

    /* TABLE EMP constants*/
    public static final String TABLE_EMP = "emp";
    public static final String E_ID = "id";
    public static final String E_NAME = "name";
    public static final String E_DESIG = "designation";
    public static final String E_SALARY = "salary";
    public static final String E_ADDR = "address";
    public static final String E_PHONE = "phone";

    public Connection conn = null;

    /*
    1. constructor ✔
    2. connection open method ✔
    3. connection closing method ✔
    4. data retrieval method (SELECT QUERY) ✔
    5. data insertion method (INSERT QUERY)
    6. data deletion method (DELETE QUERY)
    7. data updation method (UPDATE QUERY)
    and search methods (SELECT QUERY with WHERE clause)
    */

    public DatabaseHelper() {
        conn = connect();
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Sql error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("error: " + e.getMessage());
        }
        return null;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("closing error->" + e.getMessage());
        }
    }

    public ResultSet gelEmployees(){
        String query = "SELECT * FROM %s".formatted(TABLE_EMP);
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("SELECT query error->"+e.getMessage());
        }
        return null;
    }
}
