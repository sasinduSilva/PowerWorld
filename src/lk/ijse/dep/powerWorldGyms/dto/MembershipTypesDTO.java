package lk.ijse.dep.powerWorldGyms.dto;

public class MembershipTypesDTO {
    private String duration;
    private double price;
    private String branchPrice;
    private String gender;
    private String bmiRanges;
    private String fatRanges;

    public MembershipTypesDTO() {
    }

    public MembershipTypesDTO(String duration, double price, String branchPrice, String gender, String bmiRanges, String fatRanges) {
        this.duration = duration;
        this.price = price;
        this.branchPrice = branchPrice;
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

    public String getBranchPrice() {
        return branchPrice;
    }

    public void setBranchPrice(String branchPrice) {
        this.branchPrice = branchPrice;
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
        return "MembershipTypesDTO{" +
                "duration='" + duration + '\'' +
                ", price=" + price +
                ", branchPrice='" + branchPrice + '\'' +
                ", gender='" + gender + '\'' +
                ", bmiRanges='" + bmiRanges + '\'' +
                ", fatRanges='" + fatRanges + '\'' +
                '}';
    }
}
