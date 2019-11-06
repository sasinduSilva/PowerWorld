package lk.ijse.dep.powerWorldGyms.dao.custom.impl;


import lk.ijse.dep.powerWorldGyms.dao.CrudUtil;

class MembershipDAOImplTest {
  public static void main(String[] args) throws Exception {
    System.out.println(delete("M010"));

  }


 static boolean delete(String s) throws Exception {

    return CrudUtil.execute("delete from membership where memberID=?",s);

  }
}
