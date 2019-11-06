package lk.ijse.dep.powerWorldGyms.dao.custom.impl;


import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityAttendance;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

class QueryDAOImplTest {
    public static void main(String[] args) throws Exception {
        List<CustomEntityAttendance> attendanceDetails = findAttendanceDetails("Ishara" + "%");
        for (CustomEntityAttendance attendanceDetail : attendanceDetails) {
            System.out.println(attendanceDetail.getName());
            System.out.println(attendanceDetail.getStartTime());

        }
    }


    static List<CustomEntityAttendance> findAttendanceDetails(String query) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT a.memberId,m.name, a.date,m.scheduleNo, a.startTime,a.endTime from attendance a INNER JOIN membership m ON a.memberId=m.memberID where m.memberID LIKE ? OR m.name LIKE ?", query, query);
        List<CustomEntityAttendance> customList = new ArrayList<>();
        while (rst.next()){
            customList.add(new CustomEntityAttendance(rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getInt(4),
                    rst.getString(5),
                    rst.getString(6)));
        }

        return customList;
    }
}