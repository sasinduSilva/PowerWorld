package lk.ijse.dep.powerWorldGyms.business.custom;

import lk.ijse.dep.powerWorldGyms.business.SuperBO;
import lk.ijse.dep.powerWorldGyms.dto.MembershipDTO;
import lk.ijse.dep.powerWorldGyms.dto.MembershipDTO02;
import org.omg.IOP.ExceptionDetailMessage;

import java.util.List;

public interface MembershipBO extends SuperBO {
    boolean saveMembership(MembershipDTO membershipDTO)throws Exception;
    boolean updateMembership(MembershipDTO membershipDTO)throws Exception;
    boolean deleteMembership(String memberId)throws Exception;
    MembershipDTO findMembership(String memberId)throws Exception;
    List<MembershipDTO02> findAllMembers()throws Exception;
    boolean memberLogin(String memberId,String pw)throws Exception;
    int getLastMembership()throws Exception;
    List<MembershipDTO02> searchMemberDetails(String query)throws Exception;
    boolean deleteNotification(String memberId) throws Exception;


}
