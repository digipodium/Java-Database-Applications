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
    5. data insertion method (INSERT QUERY) ✔
    6. data deletion method (DELETE QUERY)  ✔
    7. data update method (UPDATE QUERY)    ✔
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

    public ResultSet gelEmployees() {
        String query = "SELECT * FROM %s".formatted(TABLE_EMP);
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("SELECT query error->" + e.getMessage());
        }
        return null;
    }

    public int addEmployee(String name, String designation, String addr, String phone, float salary) {
        String query = "INSERT INTO %s(name, designation, salary, address, phone) VALUES('%s', '%s', %f, '%s', '%s')".formatted(TABLE_EMP, name, designation, salary, addr, phone);
        System.out.println(query);
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("INSERTION ERROR!!!");
            System.out.println(e.getMessage());
            System.out.println("!!!");
        }
        return -1;  // for informing us that insert failed
    }

    public int deleteEmployee(int empId) {
        String query = "DELETE FROM %s WHERE id = %d".formatted(TABLE_EMP, empId);
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("DELETION ERROR!!!");
            System.out.println(e.getMessage());
            System.out.println("!!!");
        }
        return 0;
    }

    public int updateEmployee(int empId, String name, String designation, String addr, String phone, float salary) {
        String query = "UPDATE %s SET name='%s',designation='%s',address='%s',phone='%s',salary=%f where id=%d".formatted(
                TABLE_EMP, name, designation, addr, phone, salary, empId);
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("UPDATION ERROR!!!");
            System.out.println(e.getMessage());
            System.out.println("!!!");
        }
        return 0;
    }

    public ResultSet getEmployee(int empId) {
        String query = "SELECT * FROM %s WHERE id=%d".formatted(TABLE_EMP, empId);
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("SELECT query error->" + e.getMessage());
        }
        return null;
    }

    public ResultSet getEmployeeFromName(String name) {
        String query = "SELECT * FROM %s WHERE name='%s' ".formatted(TABLE_EMP, name);
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("SELECT query error->" + e.getMessage());
        }
        return null;
    }

}
