package lk.ijse.dep.powerWorldGyms.Entity;

public class Instructors implements SuperEntity {

    private String empId;
    private String name;
    private String shift;
    private String contactNo;
    private String password;

    public Instructors() {
    }

    public Instructors(String empId, String name, String shift, String contactNo, String password) {
        this.empId = empId;
        this.name = name;
        this.shift = shift;
        this.contactNo = contactNo;
        this.password = password;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Instructors{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", shift='" + shift + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
