package lk.ijse.dep.powerWorldGyms.business.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Attendance;
import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityAttendance;
import lk.ijse.dep.powerWorldGyms.business.custom.AttendanceBO;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.AttendanceDAO;
import lk.ijse.dep.powerWorldGyms.dao.custom.QueryDAO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO02;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceBOImpl implements AttendanceBO {
    private AttendanceDAO attendanceDAO = DAOFactory.getInstance().getDAO(DAOTypes.ATTENDANCE);
    private QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOTypes.QUERY);

    @Override
    public boolean saveAttendance(AttendanceDTO attendance) throws Exception {
        return attendanceDAO.save(new Attendance(attendance.getMemberId(),
                attendance.getDate(),
                attendance.getStartTime(),
                attendance.getEndTime(),
                attendance.getScheduleNo()));
    }

    @Override
    public boolean updateAttendance(AttendanceDTO attendance) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAttendance(Date date) throws Exception {
        return false;
    }

    @Override
    public List<AttendanceDTO> findAllAttendance() throws Exception {
        List<AttendanceDTO> attendanceDTOS = new ArrayList<>();
        List<Attendance> all = attendanceDAO.findAll();
        for (Attendance attendance : all) {
            attendanceDTOS.add(new AttendanceDTO(attendance.getAttendancePK().getMemberId(),
                    attendance.getAttendancePK().getDate(),
                    attendance.getStartTime(),
                    attendance.getEndTime(),
                    attendance.getScheduleNo()));

        }
        return attendanceDTOS;
    }

    @Override
    public boolean findAttendacne(String memberId, java.sql.Date date) throws Exception {
        boolean isExist = attendanceDAO.findExactDay(memberId, date);
        if (isExist==true){
            return true;
        }
        return false;
    }

    @Override
    public List<AttendanceDTO> findAttendacne(String memberId) throws Exception {
        List<AttendanceDTO> attendDTO = new ArrayList<>();
        List<Attendance> allAttend = attendanceDAO.findAll(memberId);
        for (Attendance attendance : allAttend) {
            attendDTO.add(new AttendanceDTO(attendance.getAttendancePK().getMemberId(),
                    attendance.getAttendancePK().getDate(),
                    attendance.getStartTime(),
                    attendance.getEndTime(),
                    attendance.getScheduleNo()));

        }
        return attendDTO;
    }

    @Override
    public List<AttendanceDTO02> findAttendanceDetails(String query) throws Exception {
        List<AttendanceDTO02> attendDtoList = new ArrayList<>();
        List<CustomEntityAttendance> attendanceDetails = queryDAO.findAttendanceDetails(query);
        for (CustomEntityAttendance attendanceDetail : attendanceDetails) {
            String date = String.valueOf(attendanceDetail.getDate());
            String startTime = String.valueOf(attendanceDetail.getStartTime());
            String endTime = String.valueOf(attendanceDetail.getEndTime());
            attendDtoList.add(new AttendanceDTO02(attendanceDetail.getMemberID(),
                    attendanceDetail.getName(),
                    date,
                    attendanceDetail.getScheduleNo(),
                    startTime,
                    endTime));


        }
        return attendDtoList;
    }

    @Override
    public List<AttendanceDTO02> allAttendForSrch() throws Exception {
        List<AttendanceDTO02> allAttndDTO = new ArrayList<>();
        List<CustomEntityAttendance> allAttendance = queryDAO.findAllAttendance();
        for (CustomEntityAttendance customEntityAttendance : allAttendance) {
            String date = String.valueOf(customEntityAttendance.getDate());
            String startTime = String.valueOf(customEntityAttendance.getStartTime());
            String endTime = String.valueOf(customEntityAttendance.getEndTime());
            allAttndDTO.add(new AttendanceDTO02(customEntityAttendance.getMemberID(),
                    customEntityAttendance.getName(),
                    date,
                    customEntityAttendance.getScheduleNo(),
                    startTime,
                    endTime));

        }
        return allAttndDTO;
    }

    @Override
    public int getDayCountPerSchedule(String memberId, int scheduleNo) throws Exception {
        return attendanceDAO.getDayCount(memberId, scheduleNo);
    }

    @Override
    public List<AttendanceDTO> findAllFromExactMember(String memberId) throws Exception {
        List<AttendanceDTO> allDTO = new ArrayList<>();
        List<Attendance> all = attendanceDAO.findAll(memberId);
        for (Attendance attendance : all) {
            allDTO.add(new AttendanceDTO(attendance.getAttendancePK().getMemberId(),
                    attendance.getAttendancePK().getDate(),
                    attendance.getStartTime(),
                    attendance.getEndTime(),
                    attendance.getScheduleNo()));

        }
        return allDTO;
    }

    @Override
    public boolean updateEndTime(Time endTime, String memberId, java.sql.Date currentDate) throws Exception {
         return attendanceDAO.updateEndTime(endTime,memberId,currentDate);
    }
}
