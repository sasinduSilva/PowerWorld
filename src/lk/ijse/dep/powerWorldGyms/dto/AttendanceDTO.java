package lk.ijse.dep.powerWorldGyms.dto;

import java.sql.Date;
import java.sql.Time;

public class AttendanceDTO {

    private String memberId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private int scheduleNo;

    public AttendanceDTO() {
    }

    public AttendanceDTO(String memberId, Date date, Time startTime, Time endTime, int scheduleNo) {
        this.memberId = memberId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduleNo = scheduleNo;
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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(int scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "memberId='" + memberId + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }


}
