package lk.ijse.dep.powerWorldGyms.dto;

import java.util.List;

public class WorkoutScheduleDTO02 {
    private List<WorkOutScheduleDTO> workoutSchedule;

    public WorkoutScheduleDTO02() {
    }

    public WorkoutScheduleDTO02(List<WorkOutScheduleDTO> workoutSchedule) {
        this.workoutSchedule = workoutSchedule;
    }

    public List<WorkOutScheduleDTO> getWorkoutSchedule() {
        return workoutSchedule;
    }

    public void setWorkoutSchedule(List<WorkOutScheduleDTO> workoutSchedule) {
        this.workoutSchedule = workoutSchedule;
    }
}
