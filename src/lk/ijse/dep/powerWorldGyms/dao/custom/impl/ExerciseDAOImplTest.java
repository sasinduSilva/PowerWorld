package lk.ijse.dep.powerWorldGyms.dao.custom.impl;


import javafx.scene.control.Alert;
import lk.ijse.dep.crypto.BraavoEncrypt;
import lk.ijse.dep.powerWorldGyms.Entity.Exercise;
import lk.ijse.dep.powerWorldGyms.business.exception.AlreadyExistScheduleException;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

class ExerciseDAOImplTest {
    public static void main(String[] args) throws Exception {
        delete("Bicep Curl","Dumbell Curl");

    }


    static List<Exercise> findAll() throws Exception {

         List<Exercise> array = new ArrayList<>();
         ResultSet rst = CrudUtil.execute("SELECT * FROM exercise");
         while (rst.next()){
             array.add(new Exercise(rst.getString(1),
                     rst.getString(2),
                     rst.getString(3)));

         }
         return array;


    }


    static void update(Exercise exercise) throws Exception {
        boolean updated = CrudUtil.execute("UPDATE exercise set reps=? where bodyPart=? AND exerciseName=?", exercise.getReps(),
                exercise.getExercisePK().getBodyPart(),
                exercise.getExercisePK().getExercisName());
        if (updated==true){
            System.out.println("Passed");
        }else {
            System.out.println("Failled");
        }
    }


    static List<String> getAllBodyParts() throws Exception {

            List<String> bdyPrts = new ArrayList<>();
            ResultSet rst = CrudUtil.execute("SELECT bodyPart from exercise");
            while (rst.next()) {
                bdyPrts.add(rst.getString(1));
            }
            return bdyPrts;

    }


    static void delete(String bodyPart, String exercisName) {

        BraavoEncrypt.encode(bodyPart, exercisName);

//        try {
//            boolean isDeleted = CrudUtil.execute("DELETE from exercise where bodyPart=? AND exerciseName=?",bodyPart,exercisName);
//
//        } catch (AlreadyExistScheduleException e) {
//            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
//
//        }catch (Exception e1){
//            e1.printStackTrace();
//        }

    }
}