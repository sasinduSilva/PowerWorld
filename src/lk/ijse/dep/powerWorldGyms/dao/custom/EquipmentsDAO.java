package lk.ijse.dep.powerWorldGyms.dao.custom;

import lk.ijse.dep.powerWorldGyms.Entity.Equipments;
import lk.ijse.dep.powerWorldGyms.dao.CrudDAO;

import java.util.List;

public interface EquipmentsDAO extends CrudDAO<Equipments,String> {

    int getUsefulLifeTime(String machineId) throws Exception;
    String getLastMachineID()throws Exception;
    List<Equipments> searchMachine(String query)throws Exception;


}
