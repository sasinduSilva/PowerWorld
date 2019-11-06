package lk.ijse.dep.powerWorldGyms.dto;

public class ExerciseDTO {
    private String bodyPart;
    private String exerciseName;
    private String reps;

    public ExerciseDTO() {
    }

    public ExerciseDTO(String bodyPart, String exerciseName, String reps) {
        this.bodyPart = bodyPart;
        this.exerciseName = exerciseName;
        this.reps = reps;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "ExerciseDTO{" +
                "bodyPart='" + bodyPart + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", reps='" + reps + '\'' +
                '}';
    }
}
