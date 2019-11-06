package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Membership;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.MembershipDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public String getLastMemberId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT memberId from membership order by memberID DESC LIMIT 1");
        if (rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public String getNotifications(String memberId) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT notifications from membership where memberID=? ORDER BY memberID LIMIT 1");
        if (rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public boolean logIn(String memberId,String password) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT password from membership where memberID=? AND password=?", memberId, password);
        if (rst.next()){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteNotification(String memberId) throws Exception {
        return CrudUtil.execute("update membership set  notifications=null where memberID=?", memberId);


    }


    @Override
    public List<Membership> findAll() throws Exception {
        List<Membership> memberships = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * from membership");
        while (rst.next()){
            memberships.add(new Membership(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getInt(7),
                    rst.getString(8)));
        }
        return memberships;
    }

    @Override
    public Membership find(String s) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * from membership where memberID=?", s);
        if (rst.next()){
            return new Membership(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getInt(7),
                    rst.getString(8));
        }
        return null;
    }

    @Override
    public boolean save(Membership membership) throws Exception {
        return CrudUtil.execute("insert  into membership values (?,?,?,?,?,?,?,?)",membership.getMemberId(),
                membership.getName(),
                membership.getContactNo(),
                membership.getBmiRange(),
                membership.getFatRange(),
                membership.getPassword(),
                membership.getScheduleNo(),
                membership.getNotifications());
    }

    @Override
    public boolean update(Membership membership) throws Exception {
        return CrudUtil.execute("update membership set  name=?, contactNo=?,bmiRange=?,fatRange=?,password=?,scheduleNo=?,notifications=? where memberID=?",
                membership.getName(),
                membership.getContactNo(),
                membership.getBmiRange(),
                membership.getFatRange(),
                membership.getPassword(),
                membership.getScheduleNo(),
                membership.getNotifications(),
                membership.getMemberId()

                );
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete from membership where memberID=?",s);
    }
}
