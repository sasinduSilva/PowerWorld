package lk.ijse.dep.powerWorldGyms.business.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.*;
import lk.ijse.dep.powerWorldGyms.business.custom.SchedulesBO;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.SchedulesDAO;
import lk.ijse.dep.powerWorldGyms.dto.*;

import java.util.ArrayList;
import java.util.List;

public class SchedulesBOImpl implements SchedulesBO {
    private SchedulesDAO schedulesDAO = DAOFactory.getInstance().getDAO(DAOTypes.SCHEDULES);

    @Override
    public boolean saveSchedule(MainScheduleDTO schedulesDTO) throws Exception {
        List<Schedules> arr01 = new ArrayList<>();
        boolean isSaved = false;
        for (SchedulesDTO dto : schedulesDTO.getSchedulesDTOList()) {
            arr01.add(new Schedules(dto.getShceduleNo(),
                    dto.getBodyPary(),
                    dto.getExercise01(),
                    dto.getExercise02(),
                    dto.getExercise03(),
                    dto.getReps(),
                    dto.getNoOfDays(),
                    dto.getMemberId()));
        }



        isSaved = schedulesDAO.save(new MainSchedule(arr01));


        System.out.println(arr01);
        return isSaved;

    }

    @Override
    public boolean updateSchedule(SchedulesDTO schedulesDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteSchedule(int scheduleNo) throws Exception {
        return false;
    }

    @Override
    public MainScheduleDTO findSchedule(int scheduleNo) throws Exception {
        List<SchedulesDTO> lis01 = new ArrayList<>();
        MainSchedule mainSchedule = schedulesDAO.find(scheduleNo);
        for (Schedules schedules : mainSchedule.getSchedulesArray()) {
            lis01.add(new SchedulesDTO(schedules.getSchedulesPK().getScheduleNo(),
                    schedules.getSchedulesPK().getBodyPart(),
                    schedules.getExercise01(),
                    schedules.getExercise02(),
                    schedules.getExercise03(),
                    schedules.getReps(),
                    schedules.getNoOfDays(),
                    schedules.getMemberId()));


        }
        return new MainScheduleDTO(lis01);


    }

    @Override
    public int getLastScheduleNo() throws Exception {
        return schedulesDAO.getLastScheduleNumber();
    }

    @Override
    public List<Integer> getScheduleNumbers() throws Exception {
        return schedulesDAO.getScheduleNumbers();
    }

    @Override
    public WorkoutScheduleDTO02 findWorkoutSchedule(int scheduleNo) throws Exception {
        List<WorkOutScheduleDTO> list01 = new ArrayList<>();
        CustomEntityWorkOutSchedule02 workoutSchedule = schedulesDAO.findWorkoutSchedule(scheduleNo);

        for (CustomEntityWorkOutSchedule customEntityWorkOutSchedule : workoutSchedule.getCustomEntity()) {
            list01.add(new WorkOutScheduleDTO(customEntityWorkOutSchedule.getBodyPart(),
                    customEntityWorkOutSchedule.getExercise01(),
                    customEntityWorkOutSchedule.getExercise02(),
                    customEntityWorkOutSchedule.getExercise03(),
                    customEntityWorkOutSchedule.getReps(),
                    customEntityWorkOutSchedule.getNoOfDays()));

        }
        return new WorkoutScheduleDTO02(list01);
    }

    @Override
    public List<ViewScheduleDTO> viewSchedules(int scheduleNo) throws Exception {
        List<ViewScheduleDTO> list01 = new ArrayList<>();
        List<CustomEntityViewSchedule> viewSchedules = schedulesDAO.viewSchedule(scheduleNo);
        for (CustomEntityViewSchedule viewSchedule : viewSchedules) {
            list01.add(new ViewScheduleDTO(viewSchedule.getBdyPrt(),
                    viewSchedule.getExercise01(),
                    viewSchedule.getExercise02(),
                    viewSchedule.getExercise03(),
                    viewSchedule.getReps(),
                    viewSchedule.getNoOfDays()));

        }
        return list01;
    }
}
