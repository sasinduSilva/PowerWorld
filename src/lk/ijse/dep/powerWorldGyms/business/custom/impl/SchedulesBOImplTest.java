package lk.ijse.dep.powerWorldGyms.business.custom.impl;


import javafx.event.ActionEvent;
import lk.ijse.dep.powerWorldGyms.Entity.MainSchedule;
import lk.ijse.dep.powerWorldGyms.Entity.Schedules;
import lk.ijse.dep.powerWorldGyms.controller.CreateScheduleController;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.SchedulesDAO;
import lk.ijse.dep.powerWorldGyms.dto.MainScheduleDTO;
import lk.ijse.dep.powerWorldGyms.dto.SchedulesDTO;

import java.util.ArrayList;
import java.util.List;

public class SchedulesBOImplTest {
    SchedulesDAO schedulesDAO = DAOFactory.getInstance().getDAO(DAOTypes.SCHEDULES);

    public static void main(String[] args) {


    }


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
}