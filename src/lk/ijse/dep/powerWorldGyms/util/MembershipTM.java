package lk.ijse.dep.powerWorldGyms.util;

import java.sql.Date;

public class MembershipTM {
    private String membrID;
    private String name;
    private Date expDate;
    private int schdlNo;

    public MembershipTM() {
    }

    public MembershipTM(String membrID, String name, Date expDate, int schdlNo) {
        this.membrID = membrID;
        this.name = name;
        this.expDate = expDate;
        this.schdlNo = schdlNo;
    }

    public String getMembrID() {
        return membrID;
    }

    public void setMembrID(String membrID) {
        this.membrID = membrID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getSchdlNo() {
        return schdlNo;
    }

    public void setSchdlNo(int schdlNo) {
        this.schdlNo = schdlNo;
    }

    @Override
    public String toString() {
        return "MembershipTM{" +
                "membrID='" + membrID + '\'' +
                ", name='" + name + '\'' +
                ", expDate=" + expDate +
                ", schdlNo=" + schdlNo +
                '}';
    }
}
