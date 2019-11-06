package lk.ijse.dep.powerWorldGyms.Entity;

import java.util.List;

public class MainSchedule implements SuperEntity {
    private List<Schedules> schedulesArray;

    public MainSchedule(List<Schedules> schedulesArray) {
        this.schedulesArray = schedulesArray;
    }
    public MainSchedule(int scheduleNo,String bodyPart,String ex01,String ex02,String ex03,String reps,int noOfDays,String memberId ) {
        this.schedulesArray.add(new Schedules(scheduleNo,bodyPart,ex01,ex02,ex03,reps,noOfDays,memberId));
    }


    public MainSchedule() {
    }


    public List<Schedules> getSchedulesArray() {
        return schedulesArray;
    }

    public void setSchedulesArray(List<Schedules> schedulesArray) {
        this.schedulesArray = schedulesArray;
    }
}
