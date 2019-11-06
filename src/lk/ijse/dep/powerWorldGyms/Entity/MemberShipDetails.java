package lk.ijse.dep.powerWorldGyms.Entity;

import java.sql.Date;

public class MemberShipDetails implements SuperEntity {

    private String memberID;
    private String instructId;
    private String type;
    private Date date;
    private Date expDate;
    private double price;

    public MemberShipDetails() {
    }

    public MemberShipDetails(String memberID, String instructId, String type, Date date, Date expDate, double price) {
        this.memberID = memberID;
        this.instructId = instructId;
        this.type = type;
        this.date = date;
        this.expDate = expDate;
      this.price = price;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getInstructId() {
        return instructId;
    }

    public void setInstructId(String instructName) {
        this.instructId = instructName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

    @Override
    public String toString() {
        return "MemberShipDetails{" +
                "memberID='" + memberID + '\'' +
                ", instructId='" + instructId + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", expDate=" + expDate +
                '}';
    }


}
