package lk.ijse.dep.powerWorldGyms.Entity;

public class Exercise implements SuperEntity {

    private ExercisePK exercisePK;
    private String reps;

    public Exercise() {
    }

    public Exercise(ExercisePK exercisePK, String reps) {
        this.exercisePK = exercisePK;
        this.reps = reps;
    }

    public Exercise(String bodyPart,String exerciseName, String reps) {
        this.exercisePK = new ExercisePK(bodyPart,exerciseName);
        this.reps = reps;
    }

    public ExercisePK getExercisePK() {
        return exercisePK;
    }

    public void setExercisePK(ExercisePK exercisePK) {
        this.exercisePK = exercisePK;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exercisePK=" + exercisePK +
                ", reps='" + reps + '\'' +
                '}';
    }
}
