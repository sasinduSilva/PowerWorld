package lk.ijse.dep.powerWorldGyms.dao.custom;

import lk.ijse.dep.powerWorldGyms.Entity.Membership;
import lk.ijse.dep.powerWorldGyms.dao.CrudDAO;

public interface MembershipDAO extends CrudDAO<Membership,String> {

    String getLastMemberId() throws Exception;
    String getNotifications(String memberId) throws Exception;
    boolean logIn(String memberId,String password)throws Exception;
    boolean deleteNotification(String memberId) throws Exception;



}
