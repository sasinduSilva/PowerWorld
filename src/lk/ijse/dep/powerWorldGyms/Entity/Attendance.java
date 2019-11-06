package lk.ijse.dep.powerWorldGyms.Entity;

import java.sql.Date;
import java.sql.Time;

public class Attendance implements SuperEntity {
    private AttendancePK attendancePK;
    private Time startTime;
    private Time endTime;
    private int scheduleNo;


    public Attendance() {
    }

    public Attendance(AttendancePK attendancePK, Time startTime, Time endTime, int scheduleNo) {
        this.attendancePK = attendancePK;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduleNo = scheduleNo;
    }

    public Attendance(String memberId, Date date, Time startTime, Time endTime, int scheduleNo) {
        this.scheduleNo = scheduleNo;
        this.attendancePK = new AttendancePK(memberId,date);
        this.startTime = startTime;
        this.endTime = endTime;
    }



    public AttendancePK getAttendancePK() {
        return attendancePK;
    }

    public void setAttendancePK(AttendancePK attendancePK) {
        this.attendancePK = attendancePK;
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
        return "Attendance{" +
                "attendancePK=" + attendancePK +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", scheduleNo='" + scheduleNo + '\'' +
                '}';

    }
}
