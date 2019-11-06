package lk.ijse.dep.powerWorldGyms.Entity;

public class SchedulesPK {
    private int scheduleNo;
    private String bodyPart;


    public SchedulesPK() {
    }

    public SchedulesPK(int scheduleNo, String bodyPart) {
        this.scheduleNo = scheduleNo;
        this.bodyPart = bodyPart;
    }

    public int getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(int scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return "SchedulesPK{" +
                "scheduleNo=" + scheduleNo +
                ", bodyPart='" + bodyPart + '\'' +
                '}';
    }
}
