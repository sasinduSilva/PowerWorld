package lk.ijse.dep.powerWorldGyms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.powerWorldGyms.business.BOFactory;
import lk.ijse.dep.powerWorldGyms.business.BOTypes;
import lk.ijse.dep.powerWorldGyms.business.custom.ManagerBO;
import lk.ijse.dep.powerWorldGyms.dto.ManagerDataDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerLoginController implements Initializable {
    public AnchorPane root;
    public Button btnHome;
    public Button btnAbout;
    public Button btnHelp;
    public Button btnContact;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPw;
    public JFXButton btnLogin;
    public JFXButton btnCancel;

    private ManagerBO managerBO = BOFactory.getInstance().getBo(BOTypes.MANAGER);


    public void navigate(ActionEvent actionEvent) {
       try{
           if (actionEvent.getSource() instanceof Button){
               Button btn = (Button) actionEvent.getSource();

               Parent root = null;
               switch (btn.getId()){
                   case "btnHome" :
                       root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/MainDashboard.fxml"));
                       break;



               }
               if (root!=null){
                   Scene scene = new Scene(root);
                   Stage primaryStage = (Stage) this.root.getScene().getWindow();
                   primaryStage.setScene(scene);
                   primaryStage.centerOnScreen();
                   primaryStage.show();

               }


           }




       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public void btnLogin_OnAction(ActionEvent actionEvent) {

        try {
            boolean login = managerBO.ManagerLogin(txtUserName.getText(), txtPw.getText());
            if (login==true){


                URL resource = this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/ManagerPanel.fxml");
                FXMLLoader fxmlLoader = new FXMLLoader(resource);
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();
                primaryStage.show();

                ManagerPanelController managerPnl = new ManagerPanelController();
            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid Usernam Or Password").show();
            }






        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnCancel_OnAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
