package lk.ijse.dep.powerWorldGyms.business.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Equipments;
import lk.ijse.dep.powerWorldGyms.business.custom.EquipmentsBO;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.EquipmentsDAO;
import lk.ijse.dep.powerWorldGyms.dto.EquipmentDTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EquipmentsBOImpl implements EquipmentsBO {
  private EquipmentsDAO equipmentsDAO = DAOFactory.getInstance().getDAO(DAOTypes.EQUIPMENTS);

  @Override
  public boolean saveEquipment(EquipmentDTO equipmentDTO) throws Exception {
    return equipmentsDAO.save(new Equipments(equipmentDTO.getEquipId(),
      equipmentDTO.getEquipName(),
      equipmentDTO.getBuyingPrice(),
      equipmentDTO.getBuyingDate(),
      equipmentDTO.getWarrantyPeriod(),
      equipmentDTO.getLifeTime()));
  }

  @Override
  public boolean updateEquipment(EquipmentDTO equipmentDTO) throws Exception {
    return equipmentsDAO.update(new Equipments(equipmentDTO.getEquipId(),
      equipmentDTO.getEquipName(),
      equipmentDTO.getBuyingPrice(),
      equipmentDTO.getBuyingDate(),
      equipmentDTO.getWarrantyPeriod(),
      equipmentDTO.getLifeTime()));
  }

  @Override
  public boolean deleteEquipment(String machingId) throws Exception {
    return equipmentsDAO.delete(machingId);
  }

  @Override
  public EquipmentDTO findEquipment(String machineId) throws Exception {
    Equipments equipments = equipmentsDAO.find(machineId);
    return new EquipmentDTO(equipments.getEquipId(),
      equipments.getEquipName(),
      equipments.getBuyingPrice(),
      equipments.getBuyingDate(),
      equipments.getWarrantyPeriod(),
      equipments.getLifeTime());
  }

  @Override
  public int getUsefulLifetime(double buyingPrice, Date buyingDate) throws Exception {
    return 0;
  }

  @Override
  public List<EquipmentDTO> findAllEquips() throws Exception {
    List<EquipmentDTO> dtoList = new ArrayList<>();
    List<Equipments> all = equipmentsDAO.findAll();
    for (Equipments equipments : all) {
      dtoList.add(new EquipmentDTO(equipments.getEquipId(),
        equipments.getEquipName(),
        equipments.getBuyingPrice(),
        equipments.getBuyingDate(),
        equipments.getWarrantyPeriod(),
        equipments.getLifeTime()));

    }
    return dtoList;
  }

  @Override
  public int getLastEquipId() throws Exception {
    String lastMachineID = equipmentsDAO.getLastMachineID();
    int eqNo = Integer.parseInt(lastMachineID.replace("EQ", ""));
    return eqNo;
  }

  @Override
  public List<EquipmentDTO> searchMachin(String query) throws Exception {
    List<EquipmentDTO> equpListDTO = new ArrayList<>();
    List<Equipments> equipments = equipmentsDAO.searchMachine(query);
    for (Equipments equipment : equipments) {
      equpListDTO.add(new EquipmentDTO(equipment.getEquipId(),
        equipment.getEquipName(),
        equipment.getBuyingPrice(),
        equipment.getBuyingDate(),
        equipment.getWarrantyPeriod(),
        equipment.getLifeTime()));

    }
    return equpListDTO;
  }
}
