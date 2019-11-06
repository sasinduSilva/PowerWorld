package lk.ijse.dep.powerWorldGyms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
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
import lk.ijse.dep.powerWorldGyms.business.custom.AttendanceBO;
import lk.ijse.dep.powerWorldGyms.business.custom.InstructorsBO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO02;
import lk.ijse.dep.powerWorldGyms.dto.InstructorsDTO;
import lk.ijse.dep.powerWorldGyms.util.AttendanceTM;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InstructorLoginController implements Initializable {
    public AnchorPane root;
    public JFXTextField txtUsernam;
    public JFXPasswordField txtPw;
    public JFXButton btnLogin;
    public JFXButton btnCancel;
    public Button btnHome;
    public Button btnAbt;
    public Button btnHlp;
    public Button btnCntct;

    private InstructorsBO instructorsBO = BOFactory.getInstance().getBo(BOTypes.INSTRUCTORS);
    private AttendanceBO attendanceBO = BOFactory.getInstance().getBo(BOTypes.ATTENDANCE);

    public void btnLoginOnAction(ActionEvent actionEvent) {
        String pw= BraavoEncrypt.encode(txtPw.getText(),txtUsernam.getText());
        try {
            boolean loging = instructorsBO.instructorLogin(txtUsernam.getText(), txtPw.getText());
            if (loging==true){

                URL resource = this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/InstructorDashBoard.fxml");
                FXMLLoader fxmlLoader = new FXMLLoader(resource);
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();
                primaryStage.show();

                InstructorDashBoardController insDBController = fxmlLoader.getController();
                insDBController.setTheInstructID(txtUsernam.getText());


            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid Usernam or password").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnCancel_OnAction(ActionEvent actionEvent) {
        txtUsernam.clear();
        txtPw.clear();
        txtUsernam.requestFocus();
    }

    public void navigate(ActionEvent actionEvent) {
        try {
            if (actionEvent.getSource() instanceof Button){
                Button btn = (Button) actionEvent.getSource();
                Parent root = null;
                switch (btn.getId()){
                    case "btnHome":
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtUsernam.requestFocus();

    }

    public void txtPw_OnAction(ActionEvent actionEvent) {
        btnLoginOnAction(actionEvent);

    }
}
