package lk.ijse.dep.powerWorldGyms.Entity;

public class MemberShipTypes implements SuperEntity {
    private String duration;
    private double price;
    private String branchName;
    private String gender;
    private String bmiRanges;
    private String fatRanges;

    public MemberShipTypes() {
    }

    public MemberShipTypes(String duration, double price, String branchName, String gender, String bmiRanges, String fatRanges) {
        this.duration = duration;
        this.price = price;
        this.branchName = branchName;
        this.gender = gender;
        this.bmiRanges = bmiRanges;
        this.fatRanges = fatRanges;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBmiRanges() {
        return bmiRanges;
    }

    public void setBmiRanges(String bmiRanges) {
        this.bmiRanges = bmiRanges;
    }

    public String getFatRanges() {
        return fatRanges;
    }

    public void setFatRanges(String fatRanges) {
        this.fatRanges = fatRanges;
    }

    @Override
    public String toString() {
        return "MemberShipTypes{" +
                "duration='" + duration + '\'' +
                ", price=" + price +
                ", branchName='" + branchName + '\'' +
                ", gender='" + gender + '\'' +
                ", bmiRanges='" + bmiRanges + '\'' +
                ", fatRanges='" + fatRanges + '\'' +
                '}';
    }
}
