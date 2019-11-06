package lk.ijse.dep.powerWorldGyms.Entity;

public class Schedules implements SuperEntity {
private SchedulesPK schedulesPK;
private String exercise01;
private String exercise02;
private String exercise03;
private String reps;
private int noOfDays;
private String memberId;


    public Schedules() {
    }

    public Schedules(SchedulesPK schedulesPK, String exercise01, String exercise02, String exercise03, String reps, int noOfDays, String memberId) {
        this.schedulesPK = schedulesPK;
        this.exercise01 = exercise01;
        this.exercise02 = exercise02;
        this.exercise03 = exercise03;
        this.reps = reps;
        this.noOfDays = noOfDays;
        this.memberId = memberId;
    }

    public Schedules(int scheduleNo,String bodyPart, String exercise01, String exercise02, String exercise03, String reps, int noOfDays, String memberId) {
        this.schedulesPK = new SchedulesPK(scheduleNo,bodyPart);
        this.exercise01 = exercise01;
        this.exercise02 = exercise02;
        this.exercise03 = exercise03;
        this.reps = reps;
        this.noOfDays = noOfDays;
        this.memberId = memberId;
    }

    public SchedulesPK getSchedulesPK() {
        return schedulesPK;
    }

    public void setSchedulesPK(SchedulesPK schedulesPK) {
        this.schedulesPK = schedulesPK;
    }

    public String getExercise01() {
        return exercise01;
    }

    public void setExercise01(String exercise01) {
        this.exercise01 = exercise01;
    }

    public String getExercise02() {
        return exercise02;
    }

    public void setExercise02(String exercise02) {
        this.exercise02 = exercise02;
    }

    public String getExercise03() {
        return exercise03;
    }

    public void setExercise03(String exercise03) {
        this.exercise03 = exercise03;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Schedules{" +
                "schedulesPK=" + schedulesPK +
                ", exercise01='" + exercise01 + '\'' +
                ", exercise02='" + exercise02 + '\'' +
                ", exercise03='" + exercise03 + '\'' +
                ", reps='" + reps + '\'' +
                ", noOfDays=" + noOfDays +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
