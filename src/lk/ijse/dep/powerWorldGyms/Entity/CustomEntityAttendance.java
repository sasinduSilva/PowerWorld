package lk.ijse.dep.powerWorldGyms.Entity;

import java.sql.Date;

public class CustomEntityAttendance implements SuperEntity {
    private String memberID;
    private String name;
    private Date date;
    private int scheduleNo;
    private String startTime;
    private String endTime;

    public CustomEntityAttendance() {
    }

    public CustomEntityAttendance(String memberID, String name, Date date, int scheduleNo, String startTime, String endTime) {
        this.memberID = memberID;
        this.name = name;
        this.date = date;
        this.scheduleNo = scheduleNo;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
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

    public int getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(int scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
