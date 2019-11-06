package lk.ijse.dep.powerWorldGyms.util;

import java.sql.Date;

public class EquipmentTM {
  private String equipId;
  private String name;
  private double price;
  private String warrantyPriod;
  private Date baughtDate;
  private int lifeTime;

  public EquipmentTM() {
  }

  public EquipmentTM(String equipId, String name, double price, String warrantyPriod, Date baughtDate, int lifeTime) {
    this.equipId = equipId;
    this.name = name;
    this.price = price;
    this.warrantyPriod = warrantyPriod;
    this.baughtDate = baughtDate;
    this.lifeTime = lifeTime;
  }

  public String getEquipId() {
    return equipId;
  }

  public void setEquipId(String equipId) {
    this.equipId = equipId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getWarrantyPriod() {
    return warrantyPriod;
  }

  public void setWarrantyPriod(String warrantyPriod) {
    this.warrantyPriod = warrantyPriod;
  }

  public Date getBaughtDate() {
    return baughtDate;
  }

  public void setBaughtDate(Date baughtDate) {
    this.baughtDate = baughtDate;
  }

  public int getLifeTime() {
    return lifeTime;
  }

  public void setLifeTime(int lifeTime) {
    this.lifeTime = lifeTime;
  }
}
