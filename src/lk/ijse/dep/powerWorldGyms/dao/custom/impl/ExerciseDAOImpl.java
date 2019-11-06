package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Exercise;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.ExerciseDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDAOImpl implements ExerciseDAO {

    @Override
    public List<Exercise> findAll() throws Exception {
        List<Exercise> array = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM exercise");
        while (rst.next()){
            array.add(new Exercise(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)));

        }
        return array;
    }

    @Override
    public Exercise find(String s) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM exercise where bodyPart=?", s);
        if (rst.next()){
            return new Exercise(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }
        return null;
    }

    @Override
    public boolean save(Exercise exercise) throws Exception {
        return CrudUtil.execute("insert into exercise values (?,?,?)",exercise.getExercisePK().getBodyPart(),
                exercise.getExercisePK().getExercisName(),exercise.getReps());
    }

    @Override
    public boolean update(Exercise exercise) throws Exception {
        return CrudUtil.execute("UPDATE exercise set reps=? where bodyPart=? AND exerciseName=?",exercise.getReps(),
                exercise.getExercisePK().getBodyPart(),
                exercise.getExercisePK().getExercisName());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Exercise find(String bodyPart, String exerciseName) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM exercise WHERE bodyPart=? AND exerciseName=?", bodyPart, exerciseName);
        if (rst.next()){
            return new Exercise(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }
        return null;
    }

    @Override
    public boolean delete(String bodyPart, String exercisName) throws Exception {
        return CrudUtil.execute("DELETE from exercise where bodyPart=? AND exerciseName=?",bodyPart,exercisName);
    }

    @Override
    public List<Exercise> search(String query) throws Exception {
        List<Exercise> arrLst = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM exercise WHERE bodyPart LIKE ? OR exerciseName LIKE ?", query, query);
        while (rst.next()){
            arrLst.add(new Exercise(rst.getString(1),rst.getString(2),rst.getString(3)));

        }
        return arrLst;

    }

    @Override
    public List<String> getAllBodyParts() throws Exception {
        List<String> bdyPrts = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT bodyPart from exercise");
        while (rst.next()){
            bdyPrts.add(rst.getString(1));
        }
        return bdyPrts;

    }

    @Override
    public List<String> getWarmUpExercises() throws Exception {
        List<String> ex = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT exerciseName from exercise where bodyPart='WarmUps'");
        while (rst.next()){
            ex.add(rst.getString(1));
        }
        return ex;
    }

    @Override
    public List<String> getLegExercises() throws Exception {
        List<String> ex = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT exerciseName from exercise where bodyPart='Legs'");
        while (rst.next()){
            ex.add(rst.getString(1));
        }
        return ex;
    }

    @Override
    public List<String> getChestExercises() throws Exception {
        List<String> ex = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT exerciseName from exercise where bodyPart='Chest'");
        while (rst.next()){
            ex.add(rst.getString(1));
        }
        return ex;
    }

    @Override
    public List<String> getShoulderExercises() throws Exception {
        List<String> ex = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT exerciseName from exercise where bodyPart='Shoulders'");
        while (rst.next()){
            ex.add(rst.getString(1));
        }
        return ex;
    }

    @Override
    public List<String> getBicepExercises() throws Exception {
        List<String> ex = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT exerciseName from exercise where bodyPart='Bicep Curl'");
        while (rst.next()){
            ex.add(rst.getString(1));
        }
        return ex;
    }

    @Override
    public List<String> getTricepExercises() throws Exception {
        List<String> ex = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT exerciseName from exercise where bodyPart='Tricep Curls'");
        while (rst.next()){
            ex.add(rst.getString(1));
        }
        return ex;
    }

    @Override
    public List<String> getForearmExercises() throws Exception {
        List<String> ex = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT exerciseName from exercise where bodyPart='Forearms'");
        while (rst.next()){
            ex.add(rst.getString(1));
        }
        return ex;
    }

    @Override
    public List<String> getSixPAckUpExercises() throws Exception {
        return null;
    }

    @Override
    public List<String> findAllExercises() throws Exception {
        List<String> ex = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT exerciseName from exercise ");
        while (rst.next()){
            ex.add(rst.getString(1));
        }
        return ex;

    }

    @Override
    public List<String> findAllReps() throws Exception {
        List<String> repsArray = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT reps from exercise");
        while (rst.next()){
            repsArray.add(rst.getString(1));
        }
        return repsArray;
    }
}
