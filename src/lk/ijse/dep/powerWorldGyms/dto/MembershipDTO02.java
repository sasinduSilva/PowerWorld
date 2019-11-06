package lk.ijse.dep.powerWorldGyms.dto;

import java.sql.Date;

public class MembershipDTO02 {
    private String memberId;
    private String name;
    private Date date;
    private int schdlNo;

    public MembershipDTO02() {
    }

    public MembershipDTO02(String memberId, String name, Date date, int schdlNo) {
        this.memberId = memberId;
        this.name = name;
        this.date = date;
        this.schdlNo = schdlNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSchdlNo() {
        return schdlNo;
    }

    public void setSchdlNo(int schdlNo) {
        this.schdlNo = schdlNo;
    }

    @Override
    public String toString() {
        return "MembershipDTO02{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", schdlNo=" + schdlNo +
                '}';
    }
}
