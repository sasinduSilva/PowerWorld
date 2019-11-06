package lk.ijse.dep.powerWorldGyms.business.custom;

import lk.ijse.dep.powerWorldGyms.business.SuperBO;
import lk.ijse.dep.powerWorldGyms.dto.MainScheduleDTO;
import lk.ijse.dep.powerWorldGyms.dto.SchedulesDTO;
import lk.ijse.dep.powerWorldGyms.dto.ViewScheduleDTO;
import lk.ijse.dep.powerWorldGyms.dto.WorkoutScheduleDTO02;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface SchedulesBO extends SuperBO {

    boolean saveSchedule(MainScheduleDTO schedulesDTO)throws Exception;
    boolean updateSchedule(SchedulesDTO schedulesDTO)throws Exception;
    boolean deleteSchedule(int scheduleNo)throws Exception;
    MainScheduleDTO findSchedule(int scheduleNo)throws Exception;
    int getLastScheduleNo()throws Exception;
    List<Integer> getScheduleNumbers()throws Exception;
    WorkoutScheduleDTO02 findWorkoutSchedule(int scheduleNo) throws Exception;
    List<ViewScheduleDTO> viewSchedules(int scheduleNo)throws Exception;
//    List<SchedulesDTO> findAll()throws Exception;




}
