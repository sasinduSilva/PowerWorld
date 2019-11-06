package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.ManagerData;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.ManagerDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAOImpl implements ManagerDAO {
    @Override
    public List<ManagerData> findAll() throws Exception {
        List<ManagerData> managerList = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM manager");
        while (rst.next()){
            managerList.add(new ManagerData(rst.getString("name"),
                    rst.getString("ID"),
                    rst.getString("Password")));
        }
        return managerList;
    }

    @Override
    public ManagerData find(String s) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM manager WHERE ID=?",s);
//        System.out.println(rst.getString(1));
        if (rst.next()){
            return new ManagerData(rst.getString("name"),
                    rst.getString("ID"),
                    rst.getString("Password"));
        }
        return null;
    }

    @Override
    public boolean save(ManagerData managerData) throws Exception {
        return false;
    }

    @Override
    public boolean update(ManagerData managerData) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }
}
