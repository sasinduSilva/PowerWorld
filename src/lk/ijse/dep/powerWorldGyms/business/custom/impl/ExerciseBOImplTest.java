package lk.ijse.dep.powerWorldGyms.business.custom.impl;


import lk.ijse.dep.powerWorldGyms.Entity.Exercise;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.ExerciseDAO;
import lk.ijse.dep.powerWorldGyms.dto.ExerciseDTO;

class ExerciseBOImplTest {
   static ExerciseDAO exerciseDAO = DAOFactory.getInstance().getDAO(DAOTypes.EXERCISES);

    public static void main(String[] args) throws Exception {
        deleteExercise("Bicep Curl","Dumbell Curl");

    }


   static void updateExercise(ExerciseDTO exerciseDTO) {
        try {
            System.out.println(exerciseDAO.update(new Exercise(exerciseDTO.getBodyPart(), exerciseDTO.getExerciseName(), exerciseDTO.getReps())));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    static boolean deleteExercise(String bodyPart,String exerciseName) throws Exception {
        return exerciseDAO.delete(bodyPart,exerciseName);
    }
}