package lk.ijse.dep.powerWorldGyms.Entity;

public class ExercisePK {

    private String bodyPart;
    private String exercisName;

    public ExercisePK() {
    }

    public ExercisePK(String bodyPart, String exercisName) {
        this.bodyPart = bodyPart;
        this.exercisName = exercisName;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getExercisName() {
        return exercisName;
    }

    public void setExercisName(String exercisName) {
        this.exercisName = exercisName;
    }

    @Override
    public String toString() {
        return "ExercisePK{" +
                "bodyPart='" + bodyPart + '\'' +
                ", exercisName='" + exercisName + '\'' +
                '}';
    }
}
