package lk.ijse.dep.powerWorldGyms.business.custom.impl;


import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityAttendance;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.QueryDAO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO02;

import java.util.ArrayList;
import java.util.List;

class AttendanceBOImplTest {
    static QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOTypes.QUERY);

    public static void main(String[] args) throws Exception {
        List<AttendanceDTO02> attendanceDetails = findAttendanceDetails("M001" + "%");
//        System.out.println(attendanceDetails);
        for (AttendanceDTO02 attendanceDetail : attendanceDetails) {
            System.out.println(attendanceDetail.getMemberId());

        }
    }



    static List<AttendanceDTO02> findAttendanceDetails(String query) throws Exception {
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
}