package example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        updateEmpList(dbHelper);
        btnAdd.addActionListener(e -> addNewEmployee(dbHelper, e));
    }

    private void addNewEmployee(DatabaseHelper dbHelper, ActionEvent e) {
        String name = editEmpName.getText();
        String addr = editEmpAddr.getText();
        String desig = editEmpDesig.getText();
        String phone = editEmpPhone.getText();
        String salary = editEmpSalary.getText();
        // if the form has data
        if (name.length() > 0 && addr.length() > 0
                && desig.length() > 0 && phone.length() > 0 && salary.length() > 0) {
            try {
                float salaryNum = Float.parseFloat(salary);
                int status = dbHelper.addEmployee(name, desig, addr, phone, salaryNum);
                if (status != -1) {
                    System.out.println("data added");
                    updateEmpList(dbHelper);
                    clearForm();
                }
            } catch (Exception e1) {
                System.out.println("error" + e1.getMessage());
            }
        }else{
            // todo show a alert dialog
        }
    }

    private void clearForm() {
        editEmpName.setText(""); // this makes the input box empty
        // todo clearForm() clear the form when this method is called
    }

    private void updateEmpList(DatabaseHelper dbHelper) {
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
                empArrayList.add(new EmpModel(id, name, desig, salary, address, phone));
            }
        } catch (Exception e) {
            employeeList.setListData(new String[]{"No Data Available"});
        }
        if (empArrayList.size() > 0) {

            employeeList.setListData(empArrayList.toArray());
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Employee App");
        frame.setContentPane(new EmployeeApp().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.validate();
        frame.setVisible(true);
    }
}
