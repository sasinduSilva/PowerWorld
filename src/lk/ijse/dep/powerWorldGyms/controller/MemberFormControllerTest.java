package lk.ijse.dep.powerWorldGyms.controller;


import javafx.scene.control.Alert;
import lk.ijse.dep.powerWorldGyms.business.BOFactory;
import lk.ijse.dep.powerWorldGyms.business.BOTypes;
import lk.ijse.dep.powerWorldGyms.business.custom.AttendanceBO;
import lk.ijse.dep.powerWorldGyms.business.custom.MembershipBO;
import lk.ijse.dep.powerWorldGyms.business.custom.SchedulesBO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO;
import lk.ijse.dep.powerWorldGyms.dto.MainScheduleDTO;
import lk.ijse.dep.powerWorldGyms.dto.SchedulesDTO;

import java.time.LocalDate;
import java.util.List;

class MemberFormControllerTest {

    private MembershipBO membershipBO = BOFactory.getInstance().getBo(BOTypes.MEMBERSHIP);
    private static SchedulesBO schedulesBO = BOFactory.getInstance().getBo(BOTypes.SCHEDULES);
    private static AttendanceBO attendanceBO = BOFactory.getInstance().getBo(BOTypes.ATTENDANCE);

    public static void main(String[] args) {
        btnEndWorkout_OnAction();


    }


    static void btnBeginWrkout_OnAction() {
        SchedulesDTO fixSchdle[]=new SchedulesDTO[9];


        try {
            MainScheduleDTO schedule = schedulesBO.findSchedule(3);

            int i=0;

            for (SchedulesDTO schedulesDTO : schedule.getSchedulesDTOList()) {

                fixSchdle[i]=new SchedulesDTO(schedulesDTO.getShceduleNo(),
                        schedulesDTO.getBodyPary(),
                        schedulesDTO.getExercise01(),
                        schedulesDTO.getExercise02(),
                        schedulesDTO.getExercise03(),
                        schedulesDTO.getReps(),
                        schedulesDTO.getNoOfDays(),
                        schedulesDTO.getMemberId());
                i++;

            }
            System.out.println(fixSchdle[8].getBodyPary());





        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    static void testBtnBeginWrkout_OnAction() {

        try {
            List<AttendanceDTO> attendacne = attendanceBO.findAttendacne("M001");
            System.out.println(attendacne);
            for (AttendanceDTO attendanceDTO : attendacne) {
                if (attendanceDTO.getDate().equals(LocalDate.now())){
                    new Alert(Alert.AlertType.ERROR,"You have already worked out today.").show();
                    return;
                }else {

//                    int scheduleDays = Integer.parseInt(lblNoOfDays.getText());
                    int scheduleDays = 20;

                    int attendedDayCount = attendanceBO.getDayCountPerSchedule("M009", 5);
                    if (attendedDayCount > scheduleDays){
//                        lblNotification.setText("Your Schedule has been Expired." +
//                                "Please collect your new schedule from the Instructor");
                        System.out.println("Expired");

                    }else {
                        System.out.println("this part works");
//                        ObservableList<WorkoutScheduleTM> tblArray = tblWorkout.getItems();
//                        for (WorkoutScheduleTM workoutScheduleTM : tblArray) {
//                            if (workoutScheduleTM.getBodyPart().equals("WarmUps")){
//                                tblWorkout.getSelectionModel().select(workoutScheduleTM);
//                            }
//
//                        }
                    }







                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


   static void btnEndWorkout_OnAction() {




    }
}