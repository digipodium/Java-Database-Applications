package example;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeApp {
    private JList employeeList;
    private JPanel panel;
    private JTextField editEmpId;
    private JTextField editEmpName;
    private JTextField editEmpDesig;
    private JTextField editEmpAddr;
    private JTextField editEmpPhone;
    private JTextField editEmpSalary;
    private JButton btnAdd;
    private JButton deleteButton;
    private JButton refreshButton;
    private JPanel formPanel;

    public EmployeeApp() {
        DatabaseHelper dbHelper = new DatabaseHelper();
        ResultSet empData = dbHelper.gelEmployees();
        ArrayList<EmpModel> empArrayList = new ArrayList<>();
        try {
            while (empData.next()) {
                int id = empData.getInt(DatabaseHelper.E_ID);
                String name = empData.getString(DatabaseHelper.E_NAME);
                String address = empData.getString(DatabaseHelper.E_ADDR);
                String desig = empData.getString(DatabaseHelper.E_DESIG);
                String phone = empData.getString(DatabaseHelper.E_PHONE);
                float salary = empData.getFloat(DatabaseHelper.E_SALARY);
                empArrayList.add(new EmpModel(id,name,desig,salary,address,phone));
            }
        }catch (Exception e){
            employeeList.setListData(new String[]{"No Data Available"});
        }
        if(empArrayList.size() > 0){
            employeeList.setListData(empArrayList.toArray());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee App");
        frame.setContentPane(new EmployeeApp().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.validate();
        frame.setVisible(true);
    }
}
