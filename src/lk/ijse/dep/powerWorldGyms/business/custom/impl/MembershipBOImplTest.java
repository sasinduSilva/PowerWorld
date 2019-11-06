package lk.ijse.dep.powerWorldGyms.business.custom.impl;


import lk.ijse.dep.powerWorldGyms.Entity.MemberShipDetails;
import lk.ijse.dep.powerWorldGyms.Entity.Membership;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.MembershipDAO;
import lk.ijse.dep.powerWorldGyms.dao.custom.MembershipDetailsDAO;
import lk.ijse.dep.powerWorldGyms.db.DBConnection;
import lk.ijse.dep.powerWorldGyms.dto.MembershipDTO;

import java.sql.Connection;
import java.sql.Date;

class MembershipBOImplTest {
    private MembershipDAO membershipDAO = DAOFactory.getInstance().getDAO(DAOTypes.MEMBERSHIP);
    private MembershipDetailsDAO membershipDetailsDAO = DAOFactory.getInstance().getDAO(DAOTypes.MEMBERSHIP_DETAILS);

    public boolean saveMembership(MembershipDTO membershipDTO) {
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
}
