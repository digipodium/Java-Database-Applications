package example;
// POJO plain old java object
public class EmpModel {
    public int id;
    public String name;
    public String designation;
    public float salary;
    public String address;
    public String phone;

    public EmpModel(int id, String name, String designation, float salary, String address, String phone) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return id+". "+name;
    }
}
