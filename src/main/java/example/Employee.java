package example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

    public static void main(String[] args) {
        DatabaseHelper db = new DatabaseHelper();
        ResultSet employees = db.gelEmployees();
        /* displaying the data*/
        System.out.println("Company Employee list:");
        try {
            while (employees.next()) {
                int id = employees.getInt(DatabaseHelper.E_ID);
                String name = employees.getString(DatabaseHelper.E_NAME);
                String address = employees.getString(DatabaseHelper.E_ADDR);
                String desig = employees.getString(DatabaseHelper.E_DESIG);
                String phone = employees.getString(DatabaseHelper.E_PHONE);
                float salary = employees.getFloat(DatabaseHelper.E_SALARY);
                System.out.println("-----------------------------");
                System.out.println("id: " + id);
                System.out.println("name: " + name);
                System.out.println("address: " + address);
                System.out.println("designation: " + desig);
                System.out.println("phone: " + phone);
                System.out.println("salary: " + salary);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("DATA ERROR->" + e.getMessage());
        }
        db.close();
    }
}
