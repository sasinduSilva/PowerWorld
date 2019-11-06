package lk.ijse.dep.powerWorldGyms.dao.custom.impl;

import lk.ijse.dep.powerWorldGyms.Entity.MemberShipDetails;
import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;
import lk.ijse.dep.powerWorldGyms.dao.custom.MembershipDetailsDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MembershipDetailsDAOImpl implements MembershipDetailsDAO {
    @Override
    public List<MemberShipDetails> findAll() throws Exception {
        List<MemberShipDetails> memberShipDetails = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * from membershipDetails");
        while (rst.next()){
            memberShipDetails.add(new MemberShipDetails(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDate(4),
                    rst.getDate(5),
                    rst.getDouble(6)));
        }
        return memberShipDetails;
    }

    @Override
    public MemberShipDetails find(String s) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * from membershipDetails where memberID=?", s);
        if (rst.next()){
            return new MemberShipDetails(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDate(4),
                    rst.getDate(5),
                    rst.getDouble(6)
              );
        }
        return null;
    }

    @Override
    public boolean save(MemberShipDetails memberShipDetails ) throws Exception {
        return CrudUtil.execute("insert into membershipDetails values (?,?,?,?,?,?)",memberShipDetails.getMemberID(),
                memberShipDetails.getInstructId(),
                memberShipDetails.getType(),
                memberShipDetails.getDate(),
                memberShipDetails.getExpDate(),
                memberShipDetails.getPrice());
    }

    @Override
    public boolean update(MemberShipDetails memberShipDetails) throws Exception {
        return CrudUtil.execute("update membershipDetails set date=?,expDate=?, price=? where memberID=?",
                memberShipDetails.getDate(),
                memberShipDetails.getExpDate(),
                memberShipDetails.getPrice(),
                memberShipDetails.getMemberID()

          );
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete from membershipDetails where memberID=?",s);
    }
}
