package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Equipments;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.EquipmentsDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAOImpl implements EquipmentsDAO {
    @Override
    public int getUsefulLifeTime(String machineId) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT lifeTime from equipments where equipId=?", machineId);
        if (rst.next()){
            return rst.getInt(1);
        }
        return 0;
    }

  @Override
  public String getLastMachineID() throws Exception {
    ResultSet rst = CrudUtil.execute("SELECT equipId from equipments order by equipId DESC LIMIT 1");
    if (rst.next()){
      return rst.getString(1);
    }
    return null;
  }

  @Override
  public List<Equipments> searchMachine(String query) throws Exception {
      List<Equipments> equpArray = new ArrayList<>();
      ResultSet rst = CrudUtil.execute("SELECT * FROM equipments WHERE equipId LIKE ? OR equipName LIKE ?", query, query);
    while (rst.next()){
      equpArray.add(new Equipments(rst.getString(1),
        rst.getString(2),
        rst.getDouble(3),
        rst.getDate(4),
        rst.getString(5),
        rst.getInt(6)));
    }
    return equpArray;
  }


  @Override
    public List<Equipments> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * from equipments");
        List<Equipments> machines = new ArrayList<>();
        while (rst.next()){
            machines.add(new Equipments(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getDate(4),rst.getString(5),rst.getInt(6))) ;

        }
        return machines;
    }

    @Override
    public Equipments find(String s) throws Exception {
        ResultSet rst = CrudUtil.execute("select * from equipments where equipId=?", s);
        if (rst.next()){
            return new Equipments(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getDate(4),rst.getString(5),rst.getInt(6));
        }
       return null;
    }

    @Override
    public boolean save(Equipments equipments) throws Exception {
        return CrudUtil.execute("insert into equipments values (?,?,?,?,?,?)",equipments.getEquipId(),equipments.getEquipName(),equipments.getBuyingPrice(),equipments.getBuyingDate(),equipments.getWarrantyPeriod(),equipments.getLifeTime());
    }

    @Override
    public boolean update(Equipments equipments) throws Exception {
        return CrudUtil.execute("update equipments set equipName=?,buyingPrice=?,buyingDate=?,warrantyPeriod=?,lifeTime=? where equipId=?",equipments.getEquipName(),equipments.getBuyingPrice(),equipments.getBuyingDate(),equipments.getWarrantyPeriod(),equipments.getLifeTime(),equipments.getEquipId());

    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete from equipments where equipId=?",s);
    }
}
