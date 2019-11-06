package lk.ijse.dep.powerWorldGyms.db;

import javafx.scene.control.Alert;
import lk.ijse.dep.crypto.BraavoEncrypt;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static String host;
    private static String port;
    private static String db;
    private static String username;
    private static String password;
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Properties properties = new Properties();
            File file = new File("resources/application.properties");
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
            fis.close();

            String ip = properties.getProperty("powerWorld.ip");
            DBConnection.host = ip;
            String port = properties.getProperty("powerWorld.port");
            DBConnection.port=port;
            String db = properties.getProperty("powerWorld.db");
            DBConnection.db = db;
            String username = BraavoEncrypt.decode(properties.getProperty("powerWorld.user"),"123");
            DBConnection.username = username;
            String password = BraavoEncrypt.decode(properties.getProperty("powerWorld.password"),"123");
            DBConnection.password = password;

            connection = DriverManager.getConnection("jdbc:mysql://"+ ip +":"+ port +"/"+ db +"?createDatabaseIfNotExist=true&allowMultiQueries=true",username,password);
            PreparedStatement pstm = connection.prepareStatement("SHOW TABLES ");
            ResultSet rst = pstm.executeQuery();
            if (!rst.next()){
                File dbScript = new File("pw-db-script.sql");
                if (!dbScript.exists()){
                    new Alert(Alert.AlertType.ERROR,"The Database Script has been removed, contact the developer").show();
                    throw new RuntimeException("Unable to find the DB Script");
                }
                StringBuilder sb = new StringBuilder();
                BufferedReader brDBScript = new BufferedReader(new InputStreamReader(new FileInputStream(dbScript)));
                brDBScript.lines().forEach(s -> sb.append(s));
                brDBScript.close();
                System.out.println(sb.toString());
                PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
                preparedStatement.execute();

            }
        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static DBConnection getInstance(){
        return (dbConnection==null)? (dbConnection=new DBConnection()):dbConnection;


    }

    public Connection getConnection(){

        return connection;

    }
}
