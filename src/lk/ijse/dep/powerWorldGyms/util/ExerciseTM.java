package lk.ijse.dep.powerWorldGyms.util;

public class ExerciseTM {
    private String name;
    private String bodyPart;
    private String reps;

    public ExerciseTM() {
    }

    public ExerciseTM(String name, String bodyPart, String reps) {
        this.name = name;
        this.bodyPart = bodyPart;
        this.reps = reps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "ExerciseTM{" +
                "name='" + name + '\'' +
                ", bodyPart='" + bodyPart + '\'' +
                ", reps='" + reps + '\'' +
                '}';
    }
}
