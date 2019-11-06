package lk.ijse.dep.powerWorldGyms.util;

public class ViewScheduleTM {
    private String bdyPrt;
    private String ex01;
    private String ex02;
    private String ex03;
    private String reps;
    private int noOFDays;

    public ViewScheduleTM() {
    }

    public ViewScheduleTM(String bdyPrt, String ex01, String ex02, String ex03, String reps, int noOFDays) {
        this.bdyPrt = bdyPrt;
        this.ex01 = ex01;
        this.ex02 = ex02;
        this.ex03 = ex03;
        this.reps = reps;
        this.noOFDays = noOFDays;
    }

    public String getBdyPrt() {
        return bdyPrt;
    }

    public void setBdyPrt(String bdyPrt) {
        this.bdyPrt = bdyPrt;
    }

    public String getEx01() {
        return ex01;
    }

    public void setEx01(String ex01) {
        this.ex01 = ex01;
    }

    public String getEx02() {
        return ex02;
    }

    public void setEx02(String ex02) {
        this.ex02 = ex02;
    }

    public String getEx03() {
        return ex03;
    }

    public void setEx03(String ex03) {
        this.ex03 = ex03;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public int getNoOFDays() {
        return noOFDays;
    }

    public void setNoOFDays(int noOFDays) {
        this.noOFDays = noOFDays;
    }

    @Override
    public String toString() {
        return "ViewScheduleTM{" +
                "bdyPrt='" + bdyPrt + '\'' +
                ", ex01='" + ex01 + '\'' +
                ", ex02='" + ex02 + '\'' +
                ", ex03='" + ex03 + '\'' +
                ", reps='" + reps + '\'' +
                ", noOFDays=" + noOFDays +
                '}';
    }
}
