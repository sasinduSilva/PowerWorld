package lk.ijse.dep.powerWorldGyms.dto;

import java.sql.Date;

public class EquipmentDTO {
    private String equipId;
    private String equipName;
    private double buyingPrice;
    private Date buyingDate;
    private String warrantyPeriod;
    private int lifeTime;

    public EquipmentDTO() {
    }

    public EquipmentDTO(String equipId, String equipName, double buyingPrice, Date buyingDate, String warrantyPeriod, int lifeTime) {
        this.equipId = equipId;
        this.equipName = equipName;
        this.buyingPrice = buyingPrice;
        this.buyingDate = buyingDate;
        this.warrantyPeriod = warrantyPeriod;
        this.lifeTime = lifeTime;
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    @Override
    public String toString() {
        return "EquipmentDTO{" +
                "equipId='" + equipId + '\'' +
                ", equipName='" + equipName + '\'' +
                ", buyingPrice=" + buyingPrice +
                ", buyingDate=" + buyingDate +
                ", warrantyPeriod='" + warrantyPeriod + '\'' +
                ", lifeTime=" + lifeTime +
                '}';
    }
}
