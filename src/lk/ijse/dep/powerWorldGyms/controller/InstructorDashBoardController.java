package lk.ijse.dep.powerWorldGyms.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.powerWorldGyms.business.BOFactory;
import lk.ijse.dep.powerWorldGyms.business.BOTypes;
import lk.ijse.dep.powerWorldGyms.business.custom.AttendanceBO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO;
import lk.ijse.dep.powerWorldGyms.dto.AttendanceDTO02;
import lk.ijse.dep.powerWorldGyms.util.AttendanceTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InstructorDashBoardController {
    public Button btnLogout;
    public Button btnAbout;
    public Button btnHelp;
    public Button btnContact;
    public Button btnIssueMbrshi;
    public Button btnCrteSchdle;
    public JFXTextField txtSearch;
    public TableView<AttendanceTM> tblAttendance;
    public Button btnCrteExrcs;
    public Button btnViewExrcise;
    public AnchorPane root;
    public Label lblInstructId;

    private AttendanceBO attendanceBO = BOFactory.getInstance().getBo(BOTypes.ATTENDANCE);



    public void initialize() {
        tblAttendance.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("memberId"));
        tblAttendance.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblAttendance.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblAttendance.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("scheduleNo"));
        tblAttendance.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("startTime"));
        tblAttendance.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("endTime"));

        try {
            List<AttendanceDTO02> attendanceDTO02s = attendanceBO.allAttendForSrch();
            List<AttendanceTM> tblList = new ArrayList<>();
            for (AttendanceDTO02 attendanceDTO02 : attendanceDTO02s) {
                tblList.add(new AttendanceTM(attendanceDTO02.getMemberId(),
                        attendanceDTO02.getName(),
                        attendanceDTO02.getDate(),
                        attendanceDTO02.getScheduleNo(),
                        attendanceDTO02.getStartTime(),
                        attendanceDTO02.getEndTime()));

            }
            ObservableList<AttendanceTM> attendanceTMS = FXCollections.observableList(tblList);
            tblAttendance.setItems(attendanceTMS);


        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<AttendanceTM> tblArray = tblAttendance.getItems();
        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tblArray.clear();
                try {
                    List<AttendanceDTO02> attendanceDetails = attendanceBO.findAttendanceDetails(newValue + "%");
                    for (AttendanceDTO02 attendanceDetail : attendanceDetails) {
                        tblArray.add(new AttendanceTM(attendanceDetail.getMemberId(),
                                attendanceDetail.getName(),
                                attendanceDetail.getDate(),
                                attendanceDetail.getScheduleNo(),
                                attendanceDetail.getStartTime(),
                                attendanceDetail.getEndTime()));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void navigate(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof Button){
            Button btn = (Button) actionEvent.getSource();
            URL resource = null;

           try{
               switch (btn.getId()){
                   case "btnLogout":
                       resource = this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/InstructorLoginForm.fxml");
                       break;
//                   case "btnCrteExrcs":
//                       resource = this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/CreateExercise.fxml");
//                       break;
                       
               }
               FXMLLoader fxmlLoader = new FXMLLoader(resource);
               Parent root = fxmlLoader.load();
               Scene scene = new Scene(root);
               Stage primaryStage = (Stage) this.root.getScene().getWindow();
               primaryStage.setScene(scene);
               primaryStage.centerOnScreen();
               primaryStage.show();





               

           }catch (Exception e){
               e.printStackTrace();
           }
        }
    }

    public void setTheInstructID(String instructID){
        lblInstructId.setText(instructID);


    }


    public void btnCrteSchdle_OnAction(ActionEvent actionEvent) {
       try{

           URL resource = this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/CreateSchedule.fxml");
           FXMLLoader fxmlLoader = new FXMLLoader(resource);
           Parent root = fxmlLoader.load();
           Scene scene = new Scene(root);
           Stage primaryStage = (Stage) this.root.getScene().getWindow();
           primaryStage.setScene(scene);
           primaryStage.centerOnScreen();
//           primaryStage.setResizable(false);
           primaryStage.show();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public void btnCrteExrcs_OnAction(ActionEvent actionEvent) {
      try{
          URL resource = this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/CreateExercise.fxml");
          FXMLLoader fxmlLoader = new FXMLLoader(resource);
          Parent root = fxmlLoader.load();
          Scene scene = new Scene(root);
          Stage primaryStage = (Stage) this.root.getScene().getWindow();
          primaryStage.setScene(scene);
          primaryStage.centerOnScreen();
          primaryStage.show();

      }catch (Exception e){
          e.printStackTrace();
      }
    }

    public void btnViewExrcise_OnAction(ActionEvent actionEvent) {

    }

    public void btnIssueMbrshi_OnAction(ActionEvent actionEvent) {
        try{
            URL resource = this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/IssueMembership.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader(resource);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();


            IssueMembershipController issueMembershipController = fxmlLoader.getController();
            issueMembershipController.lblInstructId.setText(lblInstructId.getText());
        }catch (Exception e){}

    }
}
