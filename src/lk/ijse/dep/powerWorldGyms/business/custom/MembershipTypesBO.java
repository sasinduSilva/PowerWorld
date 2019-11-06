package lk.ijse.dep.powerWorldGyms.business.custom;

import lk.ijse.dep.powerWorldGyms.business.SuperBO;
import lk.ijse.dep.powerWorldGyms.dto.MembershipTypesDTO;

import java.util.List;

public interface MembershipTypesBO extends SuperBO {
    boolean saveMembershiptype(MembershipTypesDTO membershipTypesDTO)throws Exception;
    boolean updateMembershiptypes(MembershipTypesDTO membershipTypesDTO)throws Exception;
    boolean deleteMembershipTypes(String duration) throws Exception;
    MembershipTypesDTO findMembershipType(String duration) throws Exception;
    List<MembershipTypesDTO> findAll()throws Exception;
}
