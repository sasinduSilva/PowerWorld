package lk.ijse.dep.powerWorldGyms.business.custom;

import lk.ijse.dep.powerWorldGyms.business.SuperBO;
import lk.ijse.dep.powerWorldGyms.dto.InstructorsDTO;

import java.util.List;

public interface InstructorsBO extends SuperBO {
    boolean saveInstructor(InstructorsDTO instructorsDTO)throws Exception;
    boolean updateInstructor(InstructorsDTO instructorsDTO)throws Exception;
    boolean deleteInstructor(String empId)throws Exception;
    List<InstructorsDTO> findAllInstructors()throws Exception;
    InstructorsDTO findInstructor(String empId)throws Exception;
    boolean instructorLogin(String empId,String Pw)throws Exception;
    List<InstructorsDTO> searchEmp(String query)throws Exception;
    int getLastEmpId()throws Exception;
}
