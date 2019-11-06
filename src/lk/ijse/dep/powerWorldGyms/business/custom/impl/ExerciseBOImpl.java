package lk.ijse.dep.powerWorldGyms.business.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Exercise;
import lk.ijse.dep.powerWorldGyms.business.custom.ExerciseBO;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.ExerciseDAO;
import lk.ijse.dep.powerWorldGyms.dto.ExerciseDTO;

import java.util.ArrayList;
import java.util.List;

public class ExerciseBOImpl implements ExerciseBO {
    private ExerciseDAO exerciseDAO = DAOFactory.getInstance().getDAO(DAOTypes.EXERCISES);
    @Override
    public boolean saveExercise(ExerciseDTO exerciseDTO) throws Exception {
        return exerciseDAO.save(new Exercise(exerciseDTO.getBodyPart(),exerciseDTO.getExerciseName(),exerciseDTO.getReps()));
    }

    @Override
    public boolean updateExercise(ExerciseDTO exerciseDTO) throws Exception {
        return exerciseDAO.update(new Exercise(exerciseDTO.getBodyPart(),exerciseDTO.getExerciseName(),exerciseDTO.getReps()));
    }

    @Override
    public boolean deleteExercise(String bodyPart, String exerciseName) throws Exception {
        return exerciseDAO.delete(bodyPart,exerciseName);
    }

    @Override
    public ExerciseDTO findExercise(String bodyPart, String exerciseName) throws Exception {
        Exercise exercise = exerciseDAO.find(bodyPart, exerciseName);
        return new ExerciseDTO(exercise.getExercisePK().getBodyPart(),
                exercise.getExercisePK().getExercisName(),
                exercise.getReps());
    }

    @Override
    public ExerciseDTO findExercise(String bodyPart) throws Exception {
        Exercise exercise = exerciseDAO.find(bodyPart);
        return new ExerciseDTO(exercise.getExercisePK().getBodyPart(),
                exercise.getExercisePK().getExercisName(),
                exercise.getReps());
    }

    @Override
    public List<ExerciseDTO> findAllExercises() throws Exception {
        List<ExerciseDTO> array = new ArrayList<>();
        List<Exercise> allExercise = exerciseDAO.findAll();
        for (Exercise exercise : allExercise) {
            array.add(new ExerciseDTO(exercise.getExercisePK().getBodyPart(),
                    exercise.getExercisePK().getExercisName(),
                    exercise.getReps()));

        }
        return array;
    }

    @Override
    public List<ExerciseDTO> search(String query) throws Exception {
        List<ExerciseDTO> lstDTO = new ArrayList<>();
        List<Exercise> searchLst = exerciseDAO.search(query);
        for (Exercise exercise : searchLst) {
            lstDTO.add(new ExerciseDTO(exercise.getExercisePK().getBodyPart(),exercise.getExercisePK().getExercisName(),exercise.getReps()));

        }
        return lstDTO;

    }

    @Override
    public List<String> getAllBodyPartys() throws Exception {
        return exerciseDAO.getAllBodyParts();

    }

    @Override
    public List<String> getWarmUpExercises() throws Exception {
        return exerciseDAO.getWarmUpExercises();
    }

    @Override
    public List<String> getLegExercises() throws Exception {
        return exerciseDAO.getLegExercises();
    }

    @Override
    public List<String> getChestExercises() throws Exception {
        return exerciseDAO.getChestExercises();
    }

    @Override
    public List<String> getShoulderExercises() throws Exception {
        return exerciseDAO.getShoulderExercises();
    }

    @Override
    public List<String> getBicepExercises() throws Exception {
        return exerciseDAO.getBicepExercises();
    }

    @Override
    public List<String> getTricepExercises() throws Exception {
        return exerciseDAO.getTricepExercises();
    }

    @Override
    public List<String> getForearmExercises() throws Exception {
        return exerciseDAO.getForearmExercises();
    }

    @Override
    public List<String> getSixPAckUpExercises() throws Exception {
        return exerciseDAO.getSixPAckUpExercises();
    }

    @Override
    public List<String> findAllExerciseNames() throws Exception {
       return exerciseDAO.findAllExercises();
    }

    @Override
    public List<String> findAllReps() throws Exception {
         return exerciseDAO.findAllReps();
    }
}
