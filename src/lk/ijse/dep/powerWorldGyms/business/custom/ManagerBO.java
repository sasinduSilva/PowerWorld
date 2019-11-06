package lk.ijse.dep.powerWorldGyms.business.custom;

import jdk.nashorn.internal.runtime.ECMAException;
import lk.ijse.dep.powerWorldGyms.business.SuperBO;
import lk.ijse.dep.powerWorldGyms.dto.ManagerDataDTO;

import java.util.List;

public interface ManagerBO extends SuperBO {
    List<ManagerDataDTO> findAll()throws Exception;
    ManagerDataDTO find(String id)throws Exception;
    boolean ManagerLogin(String id,String pw)throws Exception;
}
