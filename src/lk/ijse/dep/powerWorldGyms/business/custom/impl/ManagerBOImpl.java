package lk.ijse.dep.powerWorldGyms.business.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Instructors;
import lk.ijse.dep.powerWorldGyms.Entity.ManagerData;
import lk.ijse.dep.powerWorldGyms.business.custom.ManagerBO;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.ManagerDAO;
import lk.ijse.dep.powerWorldGyms.dto.ManagerDataDTO;

import java.util.ArrayList;
import java.util.List;

public class ManagerBOImpl implements ManagerBO {
    private boolean test01;
    private ManagerDAO managerDAO = DAOFactory.getInstance().getDAO(DAOTypes.MANAGER);
    @Override
    public List<ManagerDataDTO> findAll() throws Exception {
        List<ManagerDataDTO> managerDTO = new ArrayList<>();
        List<ManagerData> allManagers = managerDAO.findAll();
        for (ManagerData allManager : allManagers) {
            managerDTO.add(new ManagerDataDTO(allManager.getName(),
                    allManager.getId(),
                    allManager.getPassword()));

        }
        return managerDTO;
    }

    @Override
    public ManagerDataDTO find(String Id) throws Exception {
        ManagerData managerData = managerDAO.find(Id);
        return new ManagerDataDTO(managerData.getName(),
                managerData.getId(),
                managerData.getPassword());
    }

    @Override
    public boolean ManagerLogin(String Id, String Pw) throws Exception {
        ManagerData managerData = managerDAO.find(Id);
        if (Pw.equals(managerData.getPassword())){

            return true;
        }
        return false;
    }
}
