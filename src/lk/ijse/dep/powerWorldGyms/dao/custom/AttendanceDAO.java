package lk.ijse.dep.powerWorldGyms.dao.custom;

import lk.ijse.dep.powerWorldGyms.Entity.Attendance;
import lk.ijse.dep.powerWorldGyms.dao.CrudDAO;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AttendanceDAO extends CrudDAO<Attendance,String> {

    int getDayCount(String memberId,int scheduleNo) throws Exception;
    List<Attendance> findAll(String memberId) throws Exception;
    boolean findExactDay(String memberId, Date currentDate) throws Exception;
    Attendance find(String memberId,Date date) throws Exception;
    boolean updateEndTime(Time endTime,String memberId, Date currentDate)throws Exception;


}
