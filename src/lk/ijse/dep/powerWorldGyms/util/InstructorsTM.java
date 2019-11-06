package lk.ijse.dep.powerWorldGyms.util;

public class InstructorsTM {
  private String id;
  private String name;
  private String shift;
  private String contactNo;

  public InstructorsTM() {
  }

  public InstructorsTM(String id, String name, String shift, String contactNo) {
    this.id = id;
    this.name = name;
    this.shift = shift;
    this.contactNo = contactNo;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
}
