package lk.ijse.dep.powerWorldGyms.Entity;

import java.sql.Date;

public class CustomEntityMembers implements SuperEntity {
    private String memberId;
    private String name;
    private Date expDate;
    private int scheduleNo;

    public CustomEntityMembers() {
    }

    public CustomEntityMembers(String memberId, String name, Date expDate, int scheduleNo) {
        this.memberId = memberId;
        this.name = name;
        this.expDate = expDate;
        this.scheduleNo = scheduleNo;
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

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(int scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    @Override
    public String toString() {
        return "CustomEntityMembers{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", expDate=" + expDate +
                ", scheduleNo=" + scheduleNo +
                '}';
    }
}
