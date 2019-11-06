package lk.ijse.dep.powerWorldGyms.Entity;

import java.util.List;

public class CustomEntityWorkOutSchedule02 implements SuperEntity {
    private List<CustomEntityWorkOutSchedule> customEntity;

    public CustomEntityWorkOutSchedule02() {
    }

    public CustomEntityWorkOutSchedule02(List<CustomEntityWorkOutSchedule> customEntity) {
        this.customEntity = customEntity;
    }

    public List<CustomEntityWorkOutSchedule> getCustomEntity() {
        return customEntity;
    }

    public void setCustomEntity(List<CustomEntityWorkOutSchedule> customEntity) {
        this.customEntity = customEntity;
    }
}
