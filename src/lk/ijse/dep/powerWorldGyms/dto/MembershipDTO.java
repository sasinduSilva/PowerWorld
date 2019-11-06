package lk.ijse.dep.powerWorldGyms.dto;

import java.sql.Date;

public class MembershipDTO {
    private String membershipId;
    private String name;
    private String contactNo;
    private String bmiRange;
    private String fatRange;
    private String password;
    private int scheduleNo;
    private String notifications;
    private MembershipDetailsDTO membershipDetailsDTO;

    public MembershipDTO() {
    }

    public MembershipDTO(String membershipId, String name, String contactNo, String bmiRange, String fatRange, String password, int scheduleNo, String notifications, MembershipDetailsDTO membershipDetailsDTO) {
        this.membershipId = membershipId;
        this.name = name;
        this.contactNo = contactNo;
        this.bmiRange = bmiRange;
        this.fatRange = fatRange;
        this.password = password;
        this.scheduleNo = scheduleNo;
        this.notifications = notifications;
        this.membershipDetailsDTO = membershipDetailsDTO;
    }
    public MembershipDTO(String instructId, String type, Date date,Date expDate,String membershipId,String name, String contactNo, String bmiRange, String fatRange, String password, int scheduleNo, String notifications,double price) {
        this.membershipId = membershipId;
        this.name = name;
        this.contactNo = contactNo;
        this.bmiRange = bmiRange;
        this.fatRange = fatRange;
        this.password = password;
        this.scheduleNo = scheduleNo;
        this.notifications = notifications;
        this.membershipDetailsDTO = new MembershipDetailsDTO( instructId,type,date,expDate, price);
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
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

    public MembershipDetailsDTO getMembershipDetailsDTO() {
        return membershipDetailsDTO;
    }

    public void setMembershipDetailsDTO(MembershipDetailsDTO membershipDetailsDTO) {
        this.membershipDetailsDTO = membershipDetailsDTO;
    }

    @Override
    public String toString() {
        return "MembershipDTO{" +
                "membershipId='" + membershipId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", bmiRange='" + bmiRange + '\'' +
                ", fatRange='" + fatRange + '\'' +
                ", password='" + password + '\'' +
                ", scheduleNo=" + scheduleNo +
                ", notifications='" + notifications + '\'' +
                ", membershipDetailsDTO=" + membershipDetailsDTO +
                '}';
    }
}
