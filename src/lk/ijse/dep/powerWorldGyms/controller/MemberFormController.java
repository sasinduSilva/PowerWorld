package lk.ijse.dep.powerWorldGyms.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.powerWorldGyms.business.BOFactory;
import lk.ijse.dep.powerWorldGyms.business.BOTypes;
import lk.ijse.dep.powerWorldGyms.business.custom.AttendanceBO;
import lk.ijse.dep.powerWorldGyms.business.custom.MembershipBO;
import lk.ijse.dep.powerWorldGyms.business.custom.SchedulesBO;
import lk.ijse.dep.powerWorldGyms.dto.*;
import lk.ijse.dep.powerWorldGyms.util.WorkoutScheduleTM;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberFormController {

    public AnchorPane root;
    public Button btnLogout;
    public Button btnAbout;
    public Button btnHelp;
    public Button btnContact;
    public Label lblMembrID;
    public Button btnDone;
    public Button btnSkip;
    public Button btnBeginWrkout;
    public Label lblScheduleNo;
    public Label lblExrcsNme;
    public Label lblReps;
    public TableView<WorkoutScheduleTM> tblWorkout;
    public Label lblNoOfDays;
    public Label lblNotification;
    public Button btnEndWorkout;


    private MembershipBO membershipBO = BOFactory.getInstance().getBo(BOTypes.MEMBERSHIP);
    private SchedulesBO schedulesBO = BOFactory.getInstance().getBo(BOTypes.SCHEDULES);
    private AttendanceBO attendanceBO = BOFactory.getInstance().getBo(BOTypes.ATTENDANCE);
    SchedulesDTO fixSchdle[]=new SchedulesDTO[9];






    public void initialize() {

        btnDone.setDisable(true);
        tblWorkout.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bodyPart"));
        tblWorkout.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("exercise01"));
        tblWorkout.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("exercise02"));
        tblWorkout.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("exercise03"));
        tblWorkout.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("reps"));

//        List<WorkoutScheduleTM> list01 = new ArrayList<>();
//        try {
//            WorkoutScheduleDTO02 workoutSchedule = schedulesBO.findWorkoutSchedule(Integer.parseInt(lblScheduleNo.getText()));
//            System.out.println(lblScheduleNo.getText());
//
//            for (WorkOutScheduleDTO workOutScheduleDTO : workoutSchedule.getWorkoutSchedule()) {
//                list01.add(new WorkoutScheduleTM(workOutScheduleDTO.getBodyPart(),
//                        workOutScheduleDTO.getExercise01(),
//                        workOutScheduleDTO.getExercise02(),
//                        workOutScheduleDTO.getExercise03(),
//                        workOutScheduleDTO.getReps()));
//
//                lblNoOfDays.setText(String.valueOf(workOutScheduleDTO.getNoOfDays()));
//
//            }
//            ObservableList<WorkoutScheduleTM> workoutScheduleTMS = FXCollections.observableList(list01);
//            tblWorkout.setItems(workoutScheduleTMS);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        tblWorkout.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WorkoutScheduleTM>() {
            @Override
            public void changed(ObservableValue<? extends WorkoutScheduleTM> observable, WorkoutScheduleTM oldValue, WorkoutScheduleTM newValue) {
                WorkoutScheduleTM selectedItem = tblWorkout.getSelectionModel().getSelectedItem();
                if (selectedItem!=null){
                    btnDone.setDisable(false);
                }
                if (selectedItem.getBodyPart().equals("WarmDown")){
                    new Alert(Alert.AlertType.INFORMATION,"Great Job. Please end the workout!").show();
                }
            }
        });
        MembershipDTO membership = null;
        try {
            System.out.println(lblMembrID.getText());
            try {
                MembershipDTO membership1 = membershipBO.findMembership(lblMembrID.getText());
                if (membership1.getNotifications().equals("")){
                    lblNotification.setVisible(false);
                }else {
                    lblNotification.setVisible(true);
                    lblNotification.setText(membership1.getNotifications());
                }
                lblScheduleNo.setText(String.valueOf(membership1.getScheduleNo()));
            }catch (NullPointerException e){

            }
            } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void addDataToTbl(){
        List<WorkoutScheduleTM> list01 = new ArrayList<>();
        try {
            WorkoutScheduleDTO02 workoutSchedule = schedulesBO.findWorkoutSchedule(Integer.parseInt(lblScheduleNo.getText()));
            System.out.println(lblScheduleNo.getText());

            for (WorkOutScheduleDTO workOutScheduleDTO : workoutSchedule.getWorkoutSchedule()) {
                list01.add(new WorkoutScheduleTM(workOutScheduleDTO.getBodyPart(),
                        workOutScheduleDTO.getExercise01(),
                        workOutScheduleDTO.getExercise02(),
                        workOutScheduleDTO.getExercise03(),
                        workOutScheduleDTO.getReps()));

                lblNoOfDays.setText(String.valueOf(workOutScheduleDTO.getScheduleNo()));

            }
            ObservableList<WorkoutScheduleTM> workoutScheduleTMS = FXCollections.observableList(list01);
            tblWorkout.setItems(workoutScheduleTMS);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void navigate(ActionEvent actionEvent) {
        try{
            if (actionEvent.getSource() instanceof  Button){
                Button btn = (Button) actionEvent.getSource();
                Parent root = null;

                switch (btn.getId()){
                    case "btnLogout" :
                        root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/MemberLoginForm.fxml"));
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

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnDone_OnAction(ActionEvent actionEvent) {
        WorkoutScheduleTM selectedItem = tblWorkout.getSelectionModel().getSelectedItem();
        if (selectedItem!=null){
            switch (selectedItem.getBodyPart()){
                case "WarmUps":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Legs")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;

                case "Legs":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Chest")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Chest":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Shoulders")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Shoulders":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Bicep Curl")){
                            tblWorkout.getSelectionModel().select(item);

                        }

                    }
                    break;
                case "Bicep Curl":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Tricep Curls")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Tricep Curls":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Forearms")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Forearms":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Six Pack")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Six Pack":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("WarmDown")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }


            }
        }
    }

    public void btnSkip_OnAction(ActionEvent actionEvent) {
        WorkoutScheduleTM selectedItem = tblWorkout.getSelectionModel().getSelectedItem();
        if (selectedItem!=null){
            switch (selectedItem.getBodyPart()){
                case "WarmUps":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Legs")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;

                case "Legs":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Chest")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Chest":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Shoulders")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Shoulders":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Bicep Curl")){
                            tblWorkout.getSelectionModel().select(item);

                        }

                    }
                    break;
                case "Bicep Curl":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Tricep Curls")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Tricep Curls":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Forearms")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Forearms":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("Six Pack")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }
                    break;
                case "Six Pack":
                    for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                        if (item.getBodyPart().equals("WarmDown")){
                            tblWorkout.getSelectionModel().select(item);
                        }

                    }


            }
        }
    }

    public void btnBeginWrkout_OnAction(ActionEvent actionEvent) {

        try {
            int actualDayCountForSchedule = Integer.parseInt(lblNoOfDays.getText());
            int dayCountSpentOnSchedule = attendanceBO.getDayCountPerSchedule(lblMembrID.getText(),
                    Integer.parseInt(lblScheduleNo.getText()));
            System.out.println("spent count "+dayCountSpentOnSchedule);
            System.out.println("actual count "+actualDayCountForSchedule);
            if (dayCountSpentOnSchedule>=actualDayCountForSchedule){
                new Alert(Alert.AlertType.INFORMATION,"Schedule Expired. Please collect your new Schedule").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Date currentDate = Date.valueOf(LocalDate.now());
       Time beginTime = Time.valueOf(LocalTime.now());
       Time endTime = Time.valueOf("00:00:00");
        try {
            boolean isExist = attendanceBO.findAttendacne(lblMembrID.getText(), currentDate);
            System.out.println(isExist);
            if (isExist!=true){
                boolean isMarked = attendanceBO.saveAttendance(new AttendanceDTO(lblMembrID.getText(),
                        currentDate,
                        beginTime,
                        endTime,
                        Integer.parseInt(lblScheduleNo.getText())));
                if (isMarked==true){
                    new Alert(Alert.AlertType.INFORMATION,"Have a happy workout. You're almost there").show();
                }
            }else {
                new Alert(Alert.AlertType.INFORMATION,"You've already worked out today").show();
            }

            for (WorkoutScheduleTM item : tblWorkout.getItems()) {
                if (item.getBodyPart().equals("WarmUps")){
                    tblWorkout.getSelectionModel().select(item);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }




    public void settingTheMemberId(String memberId){

        lblMembrID.setText(memberId);
        try {
            MembershipDTO membership = membershipBO.findMembership(lblMembrID.getText());
            lblScheduleNo.setText(String.valueOf(membership.getScheduleNo()));
//            SchedulesDTO schedule = schedulesBO.findSchedule(membership.getScheduleNo());
//            if (schedule.get)


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void lblNotification_OnClicked(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, lblNotification.getText(), ButtonType.OK);
        Optional<ButtonType> btnType = alert.showAndWait();
        if (btnType.get()==ButtonType.OK){
            try {
                boolean isRead = membershipBO.deleteNotification(lblMembrID.getText());
                if (isRead==true){
                    lblNotification.setText("");
                    lblNotification.setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void btnEndWorkout_OnAction(ActionEvent actionEvent) {
        Date currentDate = Date.valueOf(LocalDate.now());
        Time currentTime = Time.valueOf(LocalTime.now());
        Time expectedEndTime = Time.valueOf("00:00:00");
        try {
            List<AttendanceDTO> allFromExactMember = attendanceBO.findAllFromExactMember(lblMembrID.getText());
            for (AttendanceDTO attendanceDTO : allFromExactMember) {
                Date objDate = attendanceDTO.getDate();
                Time objEndTime = attendanceDTO.getEndTime();
                System.out.println("We came here");
                System.out.println(objDate);
                System.out.println(objEndTime);
                System.out.println(currentDate);
//                System.out.println(objDate.equals(currentDate));
                System.out.println(objEndTime.equals(expectedEndTime));
                if (objDate.equals(currentDate)){

                    if (objEndTime.equals(expectedEndTime)){
                        boolean isUpdated = attendanceBO.updateEndTime(currentTime,
                                lblMembrID.getText(),
                                currentDate);

                        if (isUpdated==true){
                            new Alert(Alert.AlertType.INFORMATION,"Great Workout! See you next time").show();
                        }else {
                            System.out.println("We failled");
                        }

                    }

                }else {
                    System.out.println("dates dont match");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
