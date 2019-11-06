package lk.ijse.dep.powerWorldGyms.dao.custom;

import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityViewSchedule;
import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityWorkOutSchedule02;
import lk.ijse.dep.powerWorldGyms.Entity.MainSchedule;
import lk.ijse.dep.powerWorldGyms.Entity.Schedules;
import lk.ijse.dep.powerWorldGyms.dao.CrudDAO;

import java.util.List;

public interface SchedulesDAO extends CrudDAO<MainSchedule,Integer> {
    int getLastScheduleNumber() throws Exception;
    List<Integer> getScheduleNumbers()throws Exception;
    CustomEntityWorkOutSchedule02 findWorkoutSchedule(Integer integer) throws Exception;
    List<CustomEntityViewSchedule> viewSchedule(Integer integer)throws Exception;
}
