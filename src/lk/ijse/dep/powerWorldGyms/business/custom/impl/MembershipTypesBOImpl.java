package lk.ijse.dep.powerWorldGyms.business.custom.impl;

import lk.ijse.dep.powerWorldGyms.business.custom.MembershipTypesBO;
import lk.ijse.dep.powerWorldGyms.dto.MembershipTypesDTO;

import java.util.List;

public class MembershipTypesBOImpl implements MembershipTypesBO {
    @Override
    public boolean saveMembershiptype(MembershipTypesDTO membershipTypesDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateMembershiptypes(MembershipTypesDTO membershipTypesDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteMembershipTypes(String duration) throws Exception {
        return false;
    }

    @Override
    public MembershipTypesDTO findMembershipType(String duration) throws Exception {
        return null;
    }

    @Override
    public List<MembershipTypesDTO> findAll() throws Exception {
        return null;
    }
}
