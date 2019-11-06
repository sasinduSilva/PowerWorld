package lk.ijse.dep.powerWorldGyms.dto;

import java.util.List;

public class MainScheduleDTO {
    private List<SchedulesDTO> schedulesDTOList;

    public MainScheduleDTO() {
    }

    public MainScheduleDTO(List<SchedulesDTO> schedulesDTOList) {
        this.schedulesDTOList = schedulesDTOList;
    }
    public MainScheduleDTO(int scheduleNo,String bodyPart,String ex01,String ex02,String ex03,String reps,int noOfDays,String memberId) {
        this.schedulesDTOList.add(new SchedulesDTO(scheduleNo,
                bodyPart,ex01,ex02,ex03,reps,noOfDays,memberId));
    }

    public List<SchedulesDTO> getSchedulesDTOList() {
        return schedulesDTOList;
    }

    public void setSchedulesDTOList(List<SchedulesDTO> schedulesDTOList) {
        this.schedulesDTOList = schedulesDTOList;
    }
}
