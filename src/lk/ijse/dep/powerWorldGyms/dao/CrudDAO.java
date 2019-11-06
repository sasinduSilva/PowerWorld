package lk.ijse.dep.powerWorldGyms.dao;

import lk.ijse.dep.powerWorldGyms.Entity.SuperEntity;

import java.util.List;

public interface CrudDAO<T extends SuperEntity,ID> extends SuperDAO {

    List<T> findAll() throws Exception;
    T find(ID id) throws Exception;
    boolean save(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(ID id) throws Exception;
}
