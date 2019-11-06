package lk.ijse.dep.powerWorldGyms.Entity;

import sun.security.util.Password;

import java.net.PasswordAuthentication;

public class Membership implements SuperEntity {

    private String memberId;
    private String name;
    private String contactNo;
    private String bmiRange;
    private String fatRange;
    private String password;
    private int scheduleNo;
    private String notifications;

    public Membership() {
    }

    public Membership(String memberId, String name, String contactNo, String bmiRange, String fatRange, String password, int scheduleNo, String notifications) {
        this.memberId = memberId;
        this.name = name;
        this.contactNo = contactNo;
        this.bmiRange = bmiRange;
        this.fatRange = fatRange;
        this.password = password;
        this.scheduleNo = scheduleNo;
        this.notifications = notifications;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getBmiRange() {
        return bmiRange;
    }

    public void setBmiRange(String bmiRange) {
        this.bmiRange = bmiRange;
    }

    public String getFatRange() {
        return fatRange;
    }

    public void setFatRange(String fatRange) {
        this.fatRange = fatRange;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(int scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", bmiRange='" + bmiRange + '\'' +
                ", fatRange='" + fatRange + '\'' +
                ", password='" + password + '\'' +
                ", scheduleNo=" + scheduleNo +
                ", notifications='" + notifications + '\'' +
                '}';
    }
}
