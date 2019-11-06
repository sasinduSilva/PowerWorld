package lk.ijse.dep.powerWorldGyms.business.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.CustomEntityMembers;
import lk.ijse.dep.powerWorldGyms.Entity.MemberShipDetails;
import lk.ijse.dep.powerWorldGyms.Entity.Membership;
import lk.ijse.dep.powerWorldGyms.business.custom.MembershipBO;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.MembershipDAO;
import lk.ijse.dep.powerWorldGyms.dao.custom.MembershipDetailsDAO;
import lk.ijse.dep.powerWorldGyms.dao.custom.QueryDAO;
import lk.ijse.dep.powerWorldGyms.dao.custom.SchedulesDAO;
import lk.ijse.dep.powerWorldGyms.db.DBConnection;
import lk.ijse.dep.powerWorldGyms.dto.MembershipDTO;
import lk.ijse.dep.powerWorldGyms.dto.MembershipDTO02;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MembershipBOImpl implements MembershipBO {

    private MembershipDAO membershipDAO = DAOFactory.getInstance().getDAO(DAOTypes.MEMBERSHIP);
    private MembershipDetailsDAO membershipDetailsDAO = DAOFactory.getInstance().getDAO(DAOTypes.MEMBERSHIP_DETAILS);
    private QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOTypes.QUERY);
    private SchedulesDAO schedulesDAO = DAOFactory.getInstance().getDAO(DAOTypes.SCHEDULES);


    @Override
    public boolean saveMembership(MembershipDTO membershipDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            String mId = membershipDTO.getMembershipId();
            Date expDate = membershipDTO.getMembershipDetailsDTO().getExpDate();

            boolean result = membershipDetailsDAO.save(new MemberShipDetails(mId,
                    membershipDTO.getMembershipDetailsDTO().getInstructId(),
                    membershipDTO.getMembershipDetailsDTO().getType(),
                    new Date(new java.util.Date().getTime()),
                    expDate,
                    membershipDTO.getMembershipDetailsDTO().getPrice()
              ));

            if (!result) {
                connection.rollback();
                throw new RuntimeException("Something went wrong");
            }

            result = membershipDAO.save(new Membership(mId,
                    membershipDTO.getName(),
                    membershipDTO.getContactNo(),
                    membershipDTO.getBmiRange(),
                    membershipDTO.getFatRange(),
                    membershipDTO.getPassword(),
                    membershipDTO.getScheduleNo(),
                    membershipDTO.getNotifications()));
            if (!result) {
                connection.rollback();
                throw new RuntimeException("Something went wrong");
            }
            connection.commit();
            return true;


        } catch (Throwable e) {

            try {
                connection.rollback();
            }catch (Exception e1){
                e1.printStackTrace();

            }
            e.printStackTrace();
            return false;
        }finally {
            try {
                connection.setAutoCommit(true);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean updateMembership(MembershipDTO membershipDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            String mId = membershipDTO.getMembershipId();
            Date expDate = membershipDTO.getMembershipDetailsDTO().getExpDate();

            boolean result = membershipDetailsDAO.update(new MemberShipDetails(mId,
                    membershipDTO.getMembershipDetailsDTO().getInstructId(),
                    membershipDTO.getMembershipDetailsDTO().getType(),
                    new Date(new java.util.Date().getTime()),
                    expDate,
                    membershipDTO.getMembershipDetailsDTO().getPrice()
              ));

            if (!result) {
                connection.rollback();
                throw new RuntimeException("Something went wrong");
            }

            result = membershipDAO.update(new Membership(mId,
                    membershipDTO.getName(),
                    membershipDTO.getContactNo(),
                    membershipDTO.getBmiRange(),
                    membershipDTO.getFatRange(),
                    membershipDTO.getPassword(),
                    membershipDTO.getScheduleNo(),
                    membershipDTO.getNotifications()));
            if (!result) {
                connection.rollback();
                throw new RuntimeException("Something went wrong");
            }
            connection.commit();
            return true;


        } catch (Throwable e) {

            try {
                connection.rollback();
            }catch (Exception e1){
                e1.printStackTrace();

            }
            e.printStackTrace();
            return false;
        }finally {
            try {
                connection.setAutoCommit(true);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean deleteMembership(String memberId) throws Exception {
      return membershipDAO.delete(memberId);

    }

    @Override
    public MembershipDTO findMembership(String memberId) throws Exception {
        Membership membership = membershipDAO.find(memberId);
        MemberShipDetails memberShipDetails = membershipDetailsDAO.find(memberId);

        return new MembershipDTO(memberShipDetails.getInstructId(),
                memberShipDetails.getType(),
                memberShipDetails.getDate(),
                memberShipDetails.getExpDate(),
                membership.getMemberId(),
                membership.getName(),
                membership.getContactNo(),
                membership.getBmiRange(),
                membership.getFatRange(),
                membership.getPassword(),
                membership.getScheduleNo(),
                membership.getNotifications(),
                memberShipDetails.getPrice()
          );

    }

    @Override
    public List<MembershipDTO02> findAllMembers() throws Exception {
        List<MembershipDTO02> srchdMembrs = new ArrayList<>();
        List<CustomEntityMembers> customEntityMembers = queryDAO.searchMemberDetails();
        for (CustomEntityMembers customEntityMember : customEntityMembers) {
            srchdMembrs.add(new MembershipDTO02(customEntityMember.getMemberId(),
                    customEntityMember.getName(),
                    customEntityMember.getExpDate(),
                    customEntityMember.getScheduleNo()));

        }
        return srchdMembrs;
    }

    @Override
    public boolean memberLogin(String memberId,String Pw) throws Exception {
        Membership membership = membershipDAO.find(memberId);
        if (Pw.equals(membership.getPassword())){
            return true;
        }
        return false;

    }

    @Override
    public int getLastMembership() throws Exception {
        String lastMemberId = membershipDAO.getLastMemberId();
        int memberNum = Integer.parseInt(lastMemberId.replace("M",""));
        return memberNum;
    }

    @Override
    public List<MembershipDTO02> searchMemberDetails(String query) throws Exception {
        List<MembershipDTO02> DTO02List = new ArrayList<>();
        List<CustomEntityMembers> customEntityList = queryDAO.searchMemberDetails(query);
        for (CustomEntityMembers customEntityMembers : customEntityList) {
            DTO02List.add(new MembershipDTO02(customEntityMembers.getMemberId(),
                    customEntityMembers.getName(),
                    customEntityMembers.getExpDate(),
                    customEntityMembers.getScheduleNo()));

        }
        return DTO02List;


    }

    @Override
    public boolean deleteNotification(String memberId) throws Exception {
        return membershipDAO.deleteNotification(memberId);
    }


}
