package lk.ijse.dep.powerWorldGyms.business.custom;

import lk.ijse.dep.powerWorldGyms.business.SuperBO;
import lk.ijse.dep.powerWorldGyms.dto.EquipmentDTO;

import java.sql.Date;
import java.util.List;

public interface EquipmentsBO extends SuperBO {
    boolean saveEquipment(EquipmentDTO equipmentDTO) throws Exception;
    boolean updateEquipment(EquipmentDTO equipmentDTO)throws Exception;
    boolean deleteEquipment(String machingId)throws Exception;
    EquipmentDTO findEquipment(String machineId)throws Exception;
    int getUsefulLifetime(double buyingPrice, Date buyingDate) throws Exception;
    List<EquipmentDTO> findAllEquips()throws Exception;
    int getLastEquipId()throws Exception;
    List<EquipmentDTO> searchMachin(String query)throws Exception;
}
