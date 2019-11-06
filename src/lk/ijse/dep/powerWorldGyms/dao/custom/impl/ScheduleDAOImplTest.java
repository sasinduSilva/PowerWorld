package lk.ijse.dep.powerWorldGyms.dao.custom.impl;


import lk.ijse.dep.powerWorldGyms.Entity.MainSchedule;
import lk.ijse.dep.powerWorldGyms.Entity.Schedules;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class ScheduleDAOImplTest {
    public static void main(String[] args) throws Exception {
        List<Schedules> array = new ArrayList<>();
        int schdlNo = 2;
        String bdyPrt1="WarmUps";
        String bdyPrt2="Legs";
        String bdyPrt3="Chest";

        String ex1_1 = "Tredmil";
        String ex1_2 = null;
        String ex1_3= null;
        String ex1_reps="20 mints";

        String ex2_1 = "Leg Extension";
        String ex2_2= "Leg Curls";
        String ex2_3= null;
        String ex2_reps = "10x4";

        String ex3_1="Bench Press mchine";
        String ex3_2="Bench Press";
        String ex3_3="Incline Press";
        String ex3_reps = "10x4";

        String[] justStrings = new String[15];
//        justStrings.add(String.valueOf(schdlNo));
        justStrings[0]=bdyPrt1;
        justStrings[1]=ex1_1;
        justStrings[2]=ex1_2;
        justStrings[3]=ex1_3;
        justStrings[4]=ex1_reps;
//        justStrings.add(String.valueOf(20));
//        justStrings.add(String.valueOf(schdlNo));

        justStrings[5]=bdyPrt2;
        justStrings[6]=ex2_1;
        justStrings[7]=ex2_2;
        justStrings[8]=ex2_3;
        justStrings[9]=ex2_reps;

        justStrings[10]=bdyPrt3;
        justStrings[11]=ex3_1;
        justStrings[12]=ex3_2;
        justStrings[13]=ex3_3;
        justStrings[14]=ex3_reps;

        Schedules schedules = new Schedules();



        int noOfDays = 20;
        String memberId = "M002";
        List<Schedules> array2 = new ArrayList<>();
        array.add(new Schedules(2,"WarmUps","Tredmil",null,null,"20 mints",20,"M002"));
        array.add(new Schedules(2,"Legs","Leg Extension","Leg Curls",null,"10x4",20,"M002"));
        array.add(new Schedules(2,"Chest","Bench Press mchine","Bench ",null,"10x4",20,"M002"));

        save(array);



    }

   static boolean save(List<Schedules> mainSchedule) throws Exception {
       boolean isSaved = false;
       for (Schedules schedules : mainSchedule) {
           isSaved = CrudUtil.execute("INSERT into schedules values (?,?,?,?,?,?,?,?)", schedules.getSchedulesPK().getScheduleNo(),
                   schedules.getSchedulesPK().getBodyPart(),
                   schedules.getExercise01(),
                   schedules.getExercise02(),
                   schedules.getExercise03(),
                   schedules.getReps(),
                   schedules.getNoOfDays(),
                   schedules.getMemberId());

       }
       return isSaved;
   }

//        for (Schedules schedules : mainSchedule.getSchedulesArray()) {
//            int scheduleNo = schedules.getSchedulesPK().getScheduleNo();
//            String bodyPart =schedules.getSchedulesPK().getBodyPart();
//
//            isSaved= CrudUtil.execute("INSERT into schedules values (?,?,?,?,?,?,?,?)",scheduleNo,
//                    bodyPart,
//                    schedules.getExercise01(),
//                    schedules.getExercise02(),
//                    schedules.getExercise03(),
//                    schedules.getReps(),
//                    schedules.getNoOfDays(),
//                    schedules.getMemberId()
//            );
//
//        }
//        return isSaved;

}