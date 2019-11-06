package lk.ijse.dep.powerWorldGyms.dao.custom;

import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityAttendance;
import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityMembers;
import lk.ijse.dep.powerWorldGyms.dao.SuperDAO;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    //need a join query to count the days for the attendance table.

    List<CustomEntityAttendance> findAttendanceDetails(String query)throws Exception;
    List<CustomEntityAttendance> findAllAttendance()throws Exception;
    List<CustomEntityMembers> searchMemberDetails()throws Exception;
    List<CustomEntityMembers> searchMemberDetails(String query)throws Exception;
}
