package lk.ijse.dep.powerWorldGyms.dao.custom;

import lk.ijse.dep.powerWorldGyms.Entity.Instructors;
import lk.ijse.dep.powerWorldGyms.dao.CrudDAO;

import java.util.List;

public interface InstructorsDAO extends CrudDAO<Instructors,String> {
    String getLastEmpID()throws Exception;
    List<Instructors> searchEmp(String query)throws Exception;
}
