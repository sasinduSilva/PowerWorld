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
import lk.ijse.dep.crypto.BraavoEncrypt;
import lk.ijse.dep.powerWorldGyms.business.BOFactory;
import lk.ijse.dep.powerWorldGyms.business.BOTypes;
import lk.ijse.dep.powerWorldGyms.business.custom.MembershipBO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberLoginCotroller implements Initializable {
    public AnchorPane root;
    public Button btnHome;
    public Button btnAbout;
    public Button btnHelp;
    public Button btnContact;
    public JFXTextField txtMemberID;
    public JFXPasswordField txtPw;
    public JFXButton btnLogin;
    public JFXButton btnCancel;

    private MembershipBO membershipBO = BOFactory.getInstance().getBo(BOTypes.MEMBERSHIP);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void navigate(ActionEvent actionEvent) {
       try {
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
        String pw = BraavoEncrypt.encode(txtPw.getText(),txtMemberID.getText());

        try {
            boolean loggin = membershipBO.memberLogin(txtMemberID.getText(),pw);
            if (loggin==true){
                URL resource = this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/MemberForm.fxml");
                FXMLLoader fxmlLoader = new FXMLLoader(resource);
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();
                primaryStage.show();

                MemberFormController membrCon = fxmlLoader.getController();
                membrCon.settingTheMemberId(txtMemberID.getText());
                membrCon.initialize();
                membrCon.addDataToTbl();








            }else {
                new Alert(Alert.AlertType.ERROR,"User name or password incorrect").show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnCancel_OnAction(ActionEvent actionEvent) {
    }


    public void txtPw_OnAction(ActionEvent actionEvent) {
        btnLogin_OnAction(actionEvent);
    }
}
