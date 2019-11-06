package lk.ijse.dep.powerWorldGyms.dao.custom;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import lk.ijse.dep.powerWorldGyms.Entity.Exercise;
import lk.ijse.dep.powerWorldGyms.dao.CrudDAO;

import java.util.List;

public interface ExerciseDAO extends CrudDAO<Exercise,String> {
    Exercise find(String bodyPart,String exerciseName)throws Exception;
    boolean delete(String bodyPart,String exercisName)throws Exception;
    List<Exercise> search(String query)throws Exception;
    List<String> getAllBodyParts()throws Exception;
    List<String> getWarmUpExercises()throws Exception;
    List<String> getLegExercises()throws Exception;
    List<String> getChestExercises()throws Exception;
    List<String> getShoulderExercises()throws Exception;
    List<String> getBicepExercises()throws Exception;
    List<String> getTricepExercises()throws Exception;
    List<String> getForearmExercises()throws Exception;
    List<String> getSixPAckUpExercises()throws Exception;
    List<String> findAllExercises()throws Exception;
    List<String> findAllReps()throws Exception;



}
