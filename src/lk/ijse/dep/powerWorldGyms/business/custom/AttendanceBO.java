package lk.ijse.dep.powerWorldGyms.business.custom;

import lk.ijse.dep.powerWorldGyms.business.SuperBO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO02;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface AttendanceBO extends SuperBO {
    boolean saveAttendance(AttendanceDTO attendance) throws Exception;
    boolean updateAttendance(AttendanceDTO attendance) throws Exception;
    boolean deleteAttendance(Date date) throws Exception;
    List<AttendanceDTO> findAllAttendance() throws Exception;
    boolean findAttendacne(String memberId, java.sql.Date date) throws Exception;
    List<AttendanceDTO> findAttendacne(String memberId) throws Exception;
    List<AttendanceDTO02> findAttendanceDetails(String query)throws Exception;
    List<AttendanceDTO02> allAttendForSrch()throws Exception;
    int getDayCountPerSchedule(String memberId,int scheduleNo)throws Exception;
    List<AttendanceDTO> findAllFromExactMember(String memberId) throws Exception;
    boolean updateEndTime(Time endTime, String memberId, java.sql.Date currentDate)throws Exception;
}
