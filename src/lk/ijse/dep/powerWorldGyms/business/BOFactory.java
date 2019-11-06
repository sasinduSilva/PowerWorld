package lk.ijse.dep.powerWorldGyms.business;

import lk.ijse.dep.powerWorldGyms.business.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance(){
        return (boFactory==null)? (boFactory=new BOFactory()):boFactory;


    }
    public< T extends SuperBO> T getBo(BOTypes boTypes){
        switch (boTypes){
            case ATTENDANCE:
                return (T) new AttendanceBOImpl();
            case EQUIPMENTS:
                return (T) new EquipmentsBOImpl();
            case EXERCISE:
                return (T) new ExerciseBOImpl();
            case INSTRUCTORS:
                return (T) new InstructorsBOImpl();
            case MEMBERSHIP:
                return (T) new MembershipBOImpl();
            case MEMBERSHIP_TYPE:
                return (T) new MembershipTypesBOImpl();
            case SCHEDULES:
                return (T) new SchedulesBOImpl();
            case MANAGER:
                return (T) new ManagerBOImpl();
            default:
                return null;





        }


    }
}
