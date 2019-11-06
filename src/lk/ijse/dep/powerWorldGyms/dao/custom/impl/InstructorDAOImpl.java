package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.Instructors;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.InstructorsDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAOImpl implements InstructorsDAO {
    @Override
    public String getLastEmpID() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT empId from instructors ORDER BY empId DESC LIMIT 1");
        if (rst.next()){
            return rst.getString(1);
        }
        return null;
    }

  @Override
  public List<Instructors> searchEmp(String query) throws Exception {
    List<Instructors> list01 = new ArrayList<>();
      ResultSet rst = CrudUtil.execute("SELECT * FROM instructors where name LIKE ? OR empId LIKE ?", query, query);
      while (rst.next()){
        list01.add(new Instructors(rst.getString(1),
          rst.getString(2),
          rst.getString(3),
          rst.getString(4),
          rst.getString(5)));
      }
      return list01;
  }

  @Override
    public List<Instructors> findAll() throws Exception {
        List<Instructors> instructorsArray = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * from instructors");
        while (rst.next()){

            instructorsArray.add(new Instructors(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)));
        }
        return instructorsArray;
    }

    @Override
    public Instructors find(String s) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM instructors where empId=?", s);
        if (rst.next()){

            return new Instructors(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5));
        }
        return null;
    }

    @Override
    public boolean save(Instructors instructors) throws Exception {
        return CrudUtil.execute("insert into instructors values (?,?,?,?,?)",instructors.getEmpId(),instructors.getName(),instructors.getShift(),instructors.getContactNo(),instructors.getPassword());
    }

    @Override
    public boolean update(Instructors instructors) throws Exception {
        return CrudUtil.execute("update instructors set name=?,shift=?,contactNo=?, password=? where empId=? ",instructors.getName(),instructors.getShift(),instructors.getContactNo(),instructors.getEmpId(),instructors.getPassword());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE from instructors where empId=?",s);
    }
}
