package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Attendance;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.AttendanceDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {
    @Override
    public int getDayCount(String memberId,int scheduleNo) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT count(date) from attendance where memberId=? AND scheduleNo=?", memberId,scheduleNo);
        if (rst.next()){
            return rst.getInt(1);
        }
        return 0;
    }

    @Override
    public List<Attendance> findAll(String memberId) throws Exception {
        List<Attendance> list01 = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM attendance where memberId=?", memberId);
        while (rst.next()){
            list01.add(new Attendance(rst.getString(1),
                    rst.getDate(2),
                    rst.getTime(3),
                    rst.getTime(4),
                    rst.getInt(5)));
        }
        return list01;

    }

    @Override
    public boolean findExactDay(String memberId, Date currentDate) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM attendance where memberId=? AND date=?", memberId, currentDate);
        if (rst.next()){
            return true;

        }
        return false;
    }

    @Override
    public List<Attendance> findAll() throws Exception {
        List<Attendance> Attendance = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * from attendance;");
        while (rst.next()){
            Attendance.add(new Attendance(rst.getString(1),
                    rst.getDate(2),
                    rst.getTime(3),
                    rst.getTime(4),
                    rst.getInt(5)));
        }
        return Attendance;

    }

    @Override
    public Attendance find(String s) throws Exception {
        return null;
    }

    @Override
    public Attendance find(String s,Date date) throws Exception {
        return null;
    }

    @Override
    public boolean updateEndTime(Time endTime,String memberId, Date currentDate) throws Exception {

         return CrudUtil.execute("UPDATE attendance set endTime=? where memberId=? AND attendance.date=?",endTime,memberId,currentDate);
    }

    @Override
    public boolean save(Attendance attendance) throws Exception {
        return CrudUtil.execute("insert into attendance values (?,?,?,?,?)", attendance.getAttendancePK().getMemberId(), attendance.getAttendancePK().getDate(), attendance.getStartTime(), attendance.getEndTime(),attendance.getScheduleNo());
    }

    @Override
    public boolean update(Attendance attendance) throws Exception {
        return CrudUtil.execute("update attendance set startTime=?,endTime=?",  attendance.getStartTime(), attendance.getEndTime());

    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete from attendance where memberId=?",s);
    }
}
