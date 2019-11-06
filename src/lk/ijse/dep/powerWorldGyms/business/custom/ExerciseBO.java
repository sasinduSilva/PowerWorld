package lk.ijse.dep.powerWorldGyms.business.custom;

import lk.ijse.dep.powerWorldGyms.business.SuperBO;
import lk.ijse.dep.powerWorldGyms.dto.ExerciseDTO;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ExerciseBO extends SuperBO {
    boolean saveExercise(ExerciseDTO exerciseDTO)throws Exception;
    boolean updateExercise(ExerciseDTO exerciseDTO)throws Exception;
    boolean deleteExercise(String bodyPart,String exerciseName)throws Exception;
    ExerciseDTO findExercise(String bodyPart,String exerciseName)throws Exception;
    ExerciseDTO findExercise(String bodyPart)throws Exception;
    List<ExerciseDTO> findAllExercises()throws Exception;
    List<ExerciseDTO> search(String query) throws Exception;
    List<String> getAllBodyPartys() throws Exception;
    List<String> getWarmUpExercises()throws Exception;
    List<String> getLegExercises()throws Exception;
    List<String> getChestExercises()throws Exception;
    List<String> getShoulderExercises()throws Exception;
    List<String> getBicepExercises()throws Exception;
    List<String> getTricepExercises()throws Exception;
    List<String> getForearmExercises()throws Exception;
    List<String> getSixPAckUpExercises()throws Exception;
    List<String> findAllExerciseNames()throws Exception;
    List<String> findAllReps()throws Exception;
}
