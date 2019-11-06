package lk.ijse.dep.powerWorldGyms.db;



class DBConnectionTest {
    public static void main(String[] args) {
        getInstance();
    }


    static void getInstance() {
        DBConnection.getInstance().getConnection();
    }


    void getConnection() {
    }
}