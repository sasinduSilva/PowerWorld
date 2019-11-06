package lk.ijse.dep.powerWorldGyms.dao;

import lk.ijse.dep.powerWorldGyms.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance(){

        return (daoFactory==null)? (daoFactory=new DAOFactory()) : daoFactory;

    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case ATTENDANCE:
                return (T) new AttendanceDAOImpl();
            case EQUIPMENTS:
                return (T) new EquipmentDAOImpl();
            case EXERCISES:
                return (T) new ExerciseDAOImpl();
            case INSTRUCTORS:
                return (T) new InstructorDAOImpl();
            case MEMBERSHIP:
                return (T) new MembershipDAOImpl();
            case MEMBERSHIP_DETAILS:
                return (T) new MembershipDetailsDAOImpl();
            case MEMBERSHIP_TYPES:
                return (T) new MembershipTypeDAOImpl();
            case SCHEDULES:
                return (T) new ScheduleDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case MANAGER:
                return (T) new ManagerDAOImpl();
            default:
                return null;






        }


    }
}
