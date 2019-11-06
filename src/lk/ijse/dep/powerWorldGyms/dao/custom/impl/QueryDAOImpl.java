package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityAttendance;
import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityMembers;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.QueryDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<CustomEntityAttendance> findAttendanceDetails(String query) throws Exception {
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

    @Override
    public List<CustomEntityAttendance> findAllAttendance() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT a.memberId,m.name, a.date,m.scheduleNo, a.startTime,a.endTime from attendance a INNER JOIN membership m ON a.memberId=m.memberID ");
        List<CustomEntityAttendance> customList= new ArrayList<>();
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

    @Override
    public List<CustomEntityMembers> searchMemberDetails() throws Exception {
        List<CustomEntityMembers> memberships = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT a.memberID,a.name,b.expDate,a.scheduleNo FROM membership a INNER JOIN membershipDetails b ON a.memberID = b.memberID");
        while (rst.next()){
            memberships.add(new CustomEntityMembers(rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getInt(4)));
        }
        return memberships;
    }

    @Override
    public List<CustomEntityMembers> searchMemberDetails(String query) throws Exception {
        List<CustomEntityMembers> srchList = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT a.memberID,a.name,b.expDate,a.scheduleNo FROM membership a INNER JOIN membershipDetails b ON a.memberID = b.memberID where a.memberID LIKE ? OR a.name LIKE ?", query, query);
        while (rst.next()){
            srchList.add(new CustomEntityMembers(rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getInt(4)));
        }
        return srchList;
    }
}
