package lk.ijse.dep.powerWorldGyms.business.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Instructors;
import lk.ijse.dep.powerWorldGyms.business.custom.InstructorsBO;
import lk.ijse.dep.powerWorldGyms.dao.DAOFactory;
import lk.ijse.dep.powerWorldGyms.dao.DAOTypes;
import lk.ijse.dep.powerWorldGyms.dao.custom.InstructorsDAO;
import lk.ijse.dep.powerWorldGyms.dto.InstructorsDTO;

import java.util.ArrayList;
import java.util.List;

public class InstructorsBOImpl implements InstructorsBO {
    private InstructorsDAO instructorsDAO = DAOFactory.getInstance().getDAO(DAOTypes.INSTRUCTORS);
    @Override
    public boolean saveInstructor(InstructorsDTO instructorsDTO) throws Exception {
        return instructorsDAO.save(new Instructors(instructorsDTO.getEmpId(),
                instructorsDTO.getName(),
                instructorsDTO.getShift(),
                instructorsDTO.getContactNo(),
                instructorsDTO.getPassword()));
    }

    @Override
    public boolean updateInstructor(InstructorsDTO instructorsDTO) throws Exception {
        return instructorsDAO.update(new Instructors(instructorsDTO.getEmpId(),
                instructorsDTO.getName(),
                instructorsDTO.getShift(),
                instructorsDTO.getContactNo(),
                instructorsDTO.getPassword()));
    }

    @Override
    public boolean deleteInstructor(String empId) throws Exception {
        return instructorsDAO.delete(empId);
    }

    @Override
    public List<InstructorsDTO> findAllInstructors() throws Exception {
        List<InstructorsDTO> allArray = new ArrayList<>();
        List<Instructors> all = instructorsDAO.findAll();
        for (Instructors instructors : all) {
            allArray.add(new InstructorsDTO(instructors.getEmpId(),
                    instructors.getName(),
                    instructors.getShift(),
                    instructors.getContactNo(),
                    instructors.getPassword()));

        }
        return allArray;

    }

    @Override
    public InstructorsDTO findInstructor(String empId) throws Exception {
        Instructors instructors = instructorsDAO.find(empId);
        return new InstructorsDTO(instructors.getEmpId(),
                instructors.getName(),
                instructors.getShift(),
                instructors.getContactNo(),
                instructors.getPassword());
    }

    @Override
    public boolean instructorLogin(String empId, String Pw) throws Exception {
        Instructors instructors = instructorsDAO.find(empId);
        if (Pw.equals(instructors.getPassword())){

            return true;
        }
        return false;
    }

  @Override
  public List<InstructorsDTO> searchEmp(String query) throws Exception {
    List<InstructorsDTO> list = new ArrayList<>();
      List<Instructors> instructors = instructorsDAO.searchEmp(query);
    for (Instructors instructor : instructors) {
      list.add(new InstructorsDTO(instructor.getEmpId(),
        instructor.getName(),
        instructor.getShift(),
        instructor.getContactNo(),
        instructor.getPassword()));

    }
    return list;
  }

  @Override
  public int getLastEmpId() throws Exception {
    String lastEmpID = instructorsDAO.getLastEmpID();
    return Integer.parseInt(lastEmpID.replace("EMP",""));
  }
}
