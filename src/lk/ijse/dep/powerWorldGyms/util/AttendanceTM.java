package lk.ijse.dep.powerWorldGyms.util;

public class AttendanceTM {
    private String memberId;
    private String name;
    private String date;
    private int scheduleNo;
    private String startTime;
    private String endTime;

    public AttendanceTM() {
    }

    public AttendanceTM(String memberId, String name, String date, int scheduleNo, String startTime, String endTime) {
        this.memberId = memberId;
        this.name = name;
        this.date = date;
        this.scheduleNo = scheduleNo;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
