package lk.ijse.dep.powerWorldGyms.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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
import lk.ijse.dep.powerWorldGyms.business.custom.SchedulesBO;
import lk.ijse.dep.powerWorldGyms.dto.ViewScheduleDTO;
import lk.ijse.dep.powerWorldGyms.dto.WorkOutScheduleDTO;
import lk.ijse.dep.powerWorldGyms.dto.WorkoutScheduleDTO02;
import lk.ijse.dep.powerWorldGyms.util.ViewScheduleTM;
import lk.ijse.dep.powerWorldGyms.util.WorkoutScheduleTM;

import java.util.List;

public class ViewScheduleController {
    public AnchorPane root;
    public Button btnBack;
    public Button btnLogout;
    public Button btnAbt;
    public Button btnHlp;
    public Button btnCntct;
    public JFXTextField txtSrch;
    public TableView<ViewScheduleTM> tblSrchSchdle;
    public Button btnPrnt;
    public Label lblMemberId;
    public Label lblNoOfDays;
    public Label lblSheduleNo;

    SchedulesBO schedulesBO = BOFactory.getInstance().getBo(BOTypes.SCHEDULES);



    public void initialize() {
        tblSrchSchdle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bdyPrt"));
        tblSrchSchdle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("ex01"));
        tblSrchSchdle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("ex02"));
        tblSrchSchdle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ex03"));
        tblSrchSchdle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("reps"));
        tblSrchSchdle.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("noOFDays"));

        ObservableList<ViewScheduleTM> tblArray = tblSrchSchdle.getItems();
        try {
            
            List<ViewScheduleDTO> viewScheduleDTOS = schedulesBO.viewSchedules(Integer.parseInt(lblSheduleNo.getText()));
            for (ViewScheduleDTO viewScheduleDTO : viewScheduleDTOS) {
                tblArray.add(new ViewScheduleTM(viewScheduleDTO.getBdyPrt(),
                        viewScheduleDTO.getExercise01(),
                        viewScheduleDTO.getExercise02(),
                        viewScheduleDTO.getExercise03(),
                        viewScheduleDTO.getReps(),
                        viewScheduleDTO.getScheduleNo()));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void navigate(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof Button){
            Button btn = (Button) actionEvent.getSource();
            Parent root = null;
            try {
                switch (btn.getId()){
                    case "btnBack":
                        root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/CreateSchedule.fxml"));
                        break;
                    case "btnLogout":
                        root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/InstructorLoginForm.fxml"));
                        break;


                }
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
    public void setScheduleNo(int scheduleNo){
        lblSheduleNo.setText(String.valueOf(scheduleNo));
    }

    public void btnPrnt_OnAction(ActionEvent actionEvent) {
    }


}
