package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.MemberShipTypes;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.MemberShipTypesDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MembershipTypeDAOImpl implements MemberShipTypesDAO {
    @Override
    public List<MemberShipTypes> findAll() throws Exception {
        List<MemberShipTypes> memberShipTypes = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("select * from membershipTypes");
        while (rst.next()){
            memberShipTypes.add(new MemberShipTypes(rst.getString(1),
                    rst.getDouble(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)));
        }
        return memberShipTypes;
    }

    @Override
    public MemberShipTypes find(String s) throws Exception {
        ResultSet rst = CrudUtil.execute("select * from membershipTypes where duration=?", s);
        if (rst.next()){
            return new MemberShipTypes(rst.getString(1),
                    rst.getDouble(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6));
        }
        return null;
    }

    @Override
    public boolean save(MemberShipTypes memberShipTypes) throws Exception {
        return CrudUtil.execute("insert into membershipTypes values (?,?,?,?,?,?)",memberShipTypes.getDuration(),
                memberShipTypes.getPrice(),
                memberShipTypes.getBranchName(),
                memberShipTypes.getGender(),
                memberShipTypes.getBmiRanges(),
                memberShipTypes.getFatRanges());
    }

    @Override
    public boolean update(MemberShipTypes memberShipTypes) throws Exception {
        return CrudUtil.execute("update membershipTypes set price=?,branchName=?,gender=?,bmiRanges=?,fatRanges=? where duration=?",memberShipTypes.getPrice(),
                memberShipTypes.getBranchName(),
                memberShipTypes.getGender(),
                memberShipTypes.getBmiRanges(),
                memberShipTypes.getFatRanges(),
                memberShipTypes.getDuration()

                );
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete from membershipTypes where duration=?",s);
    }
}
