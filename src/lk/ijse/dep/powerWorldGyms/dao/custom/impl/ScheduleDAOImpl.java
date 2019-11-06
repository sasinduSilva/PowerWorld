package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.*;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.SchedulesDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements SchedulesDAO {


    @Override
    public int getLastScheduleNumber() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT scheduleNo from schedules order by scheduleNo DESC LIMIT 1");
        if (rst.next()){
            return rst.getInt(1);
        }else {
            return 0;
        }
    }

    @Override
    public List<Integer> getScheduleNumbers() throws Exception {
        List<Integer> intArray = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT distinct scheduleNo from schedules ");
        while (rst.next()){
            intArray.add(new Integer(rst.getInt(1)));
        }
        return intArray;
    }

    @Override
    public CustomEntityWorkOutSchedule02 findWorkoutSchedule(Integer integer) throws Exception {
        List<CustomEntityWorkOutSchedule> list01 = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT bodyPart,exercise01,exercise02,exercise03,reps,noOfDays from schedules where scheduleNo=?", integer);
        while (rst.next()){

            list01.add(new CustomEntityWorkOutSchedule(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getInt(6)));
        }
        return new CustomEntityWorkOutSchedule02(list01);

    }

    @Override
    public List<CustomEntityViewSchedule> viewSchedule(Integer integer) throws Exception {
        List<CustomEntityViewSchedule> viewSchedules = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT bodyPart,exercise01,exercise02,exercise03,reps,noOfDays FROM schedules where scheduleNo=?", integer);
        while (rst.next()){
            viewSchedules.add(new CustomEntityViewSchedule(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getInt(6)));


        }
        return viewSchedules;

    }

    @Override
    public List<MainSchedule> findAll() throws Exception {
        return null;
    }

    @Override
    public MainSchedule find(Integer integer) throws Exception {
        List<Schedules> lis01 = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM schedules where scheduleNo=?", integer);
        while (rst.next()){

            lis01.add(new Schedules(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getInt(7),
                    rst.getString(8)));

        }
        return new MainSchedule(lis01);
    }

    @Override
    public boolean save(MainSchedule mainSchedule) throws Exception {
        boolean isSaved = false;

        for (Schedules schedules : mainSchedule.getSchedulesArray()) {
            int scheduleNo = schedules.getSchedulesPK().getScheduleNo();
            String bodyPart =schedules.getSchedulesPK().getBodyPart();

            isSaved= CrudUtil.execute("INSERT into schedules values (?,?,?,?,?,?,?,?)",scheduleNo,
                    bodyPart,
                    schedules.getExercise01(),
                    schedules.getExercise02(),
                    schedules.getExercise03(),
                    schedules.getReps(),
                    schedules.getNoOfDays(),
                    schedules.getMemberId()
            );

        }
        return isSaved;

    }

    @Override
    public boolean update(MainSchedule mainSchedule) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        return false;
    }
}
