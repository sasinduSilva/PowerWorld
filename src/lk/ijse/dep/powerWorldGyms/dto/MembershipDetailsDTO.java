package lk.ijse.dep.powerWorldGyms.dto;

import java.sql.Date;

public class MembershipDetailsDTO {

//    private String membrID;
    private String instructId;
    private String type;
    private Date date;
    private Date expDate;
    private double price;

    public MembershipDetailsDTO() {
    }

    public MembershipDetailsDTO(String instructId, String type, Date date, Date expDate, double price) {


        this.instructId = instructId;
        this.type = type;
        this.date = date;
        this.expDate = expDate;
      this.price = price;
    }





    public String getInstructId() {
        return instructId;
    }

    public void setInstructId(String instructId) {
        this.instructId = instructId;
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
        return "MembershipDetailsDTO{" +
                "instructId='" + instructId + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", expDate=" + expDate +
                '}';
    }



}

