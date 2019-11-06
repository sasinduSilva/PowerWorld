package lk.ijse.dep.powerWorldGyms.Entity;

import java.sql.Date;

public class AttendancePK {
    private String memberId;
    private Date date;

    public AttendancePK() {
    }

    public AttendancePK(String memberId, Date date) {
        this.memberId = memberId;
        this.date = date;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AttendancePK{" +
                "memberId='" + memberId + '\'' +
                ", date=" + date +
                '}';
    }
}
