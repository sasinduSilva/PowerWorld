package lk.ijse.dep.powerWorldGyms.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.powerWorldGyms.business.BOFactory;
import lk.ijse.dep.powerWorldGyms.business.BOTypes;
import lk.ijse.dep.powerWorldGyms.business.custom.ExerciseBO;
import lk.ijse.dep.powerWorldGyms.business.custom.SchedulesBO;
import lk.ijse.dep.powerWorldGyms.business.custom.impl.SchedulesBOImplTest;
import lk.ijse.dep.powerWorldGyms.dto.MainScheduleDTO;
import lk.ijse.dep.powerWorldGyms.dto.SchedulesDTO;
import net.sf.jasperreports.extensions.SpringExtensionsRegistry;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateScheduleController {
    public Button btnBack;
    public Button btnLogout;
    public Button btnAbt;
    public Button btnHlp;
    public Button btnCntct;
    public Button btnNwSchdle;
    public Label lblSchdleNbr;
    public ComboBox<String> cmbBdyPrt01;
    public ComboBox<String> cmbReps01;
    public ComboBox<String> cmbBdyPrt02;
    public ComboBox<String> cmbBdyPrt03;
    public ComboBox<String> cmbBdyPrt04;
    public ComboBox<String> cmbBdyPrt06;
    public ComboBox<String> cmbBdyPrt07;
    public ComboBox<String> cmbBdyPrt05;
    public ComboBox<String> cmbBdyPrt08;
    public ComboBox<String> cmbReps08;
    public ComboBox<String> cmbBdyPrt09;
    public Button btnSave;
    public Button btnPrnt;
    public Button btnView;
    public ComboBox<String> cmbReps02;
    public ComboBox<String> cmbReps03;
    public ComboBox<String> cmbReps04;
    public ComboBox<String> cmbReps05;
    public ComboBox<String> cmbReps06;
    public ComboBox<String> cmbReps07;
    public ComboBox<String> cmbReps09;
    public ComboBox<String> exercise01_cmb01;
    public ComboBox<String> exercise02_cmb01;
    public ComboBox<String> exercise03_cmb01;
    public ComboBox<String> exercise01_cmb02;
    public ComboBox<String> exercise01_cmb03;
    public ComboBox<String> exercise01_cmb04;
    public ComboBox<String> exercise01_cmb05;
    public ComboBox<String> exercise01_cmb06;
    public ComboBox<String> exercise01_cmb07;
    public ComboBox<String> exercise01_cmb08;
    public ComboBox<String> exercise01_cmb09;
    public ComboBox<String> exercise02_cmb02;
    public ComboBox<String> exercise02_cmb03;
    public ComboBox<String> exercise02_cmb04;
    public ComboBox<String> exercise02_cmb05;
    public ComboBox<String> exercise02_cmb06;
    public ComboBox<String> exercise02_cmb07;
    public ComboBox<String> exercise02_cmb08;
    public ComboBox<String> exercise02_cmb09;
    public ComboBox<String> exercise03_cmb02;
    public ComboBox<String> exercise03_cmb03;
    public ComboBox<String> exercise03_cmb04;
    public ComboBox<String> exercise03_cmb05;
    public ComboBox<String> exercise03_cmb06;
    public ComboBox<String> exercise03_cmb07;
    public ComboBox<String> exercise03_cmb08;
    public ComboBox<String> exercise03_cmb09;
    public JFXTextField txtMembrId;
    public AnchorPane root;
    public ComboBox<Integer> cmbNoOfDays;

    private ExerciseBO exerciseBO = BOFactory.getInstance().getBo(BOTypes.EXERCISE);
    private SchedulesBO schedulesBO = BOFactory.getInstance().getBo(BOTypes.SCHEDULES);



    public void initialize() {
        cmbNoOfDays.getItems().add(24);
        cmbNoOfDays.getItems().add(36);
        cmbNoOfDays.getItems().add(48);



        try {
            List<String> allBodyPartys = exerciseBO.getAllBodyPartys();
            ObservableList<String> bdyPrts = FXCollections.observableList(allBodyPartys);
            cmbBdyPrt01.setItems(bdyPrts);
            cmbBdyPrt02.setItems(bdyPrts);
            cmbBdyPrt03.setItems(bdyPrts);
            cmbBdyPrt04.setItems(bdyPrts);
            cmbBdyPrt05.setItems(bdyPrts);
            cmbBdyPrt06.setItems(bdyPrts);
            cmbBdyPrt07.setItems(bdyPrts);
            cmbBdyPrt08.setItems(bdyPrts);
            cmbBdyPrt09.setItems(bdyPrts);


            List<String> allExerciseNames = exerciseBO.findAllExerciseNames();
            ObservableList<String> exerciseNames = FXCollections.observableList(allExerciseNames);
            exercise01_cmb01.setItems(exerciseNames);
            exercise01_cmb02.setItems(exerciseNames);
            exercise01_cmb03.setItems(exerciseNames);
            exercise01_cmb04.setItems(exerciseNames);
            exercise01_cmb05.setItems(exerciseNames);
            exercise01_cmb06.setItems(exerciseNames);
            exercise01_cmb07.setItems(exerciseNames);
            exercise01_cmb08.setItems(exerciseNames);
            exercise01_cmb09.setItems(exerciseNames);

            exercise02_cmb01.setItems(exerciseNames);
            exercise02_cmb02.setItems(exerciseNames);
            exercise02_cmb03.setItems(exerciseNames);
            exercise02_cmb04.setItems(exerciseNames);
            exercise02_cmb05.setItems(exerciseNames);
            exercise02_cmb06.setItems(exerciseNames);
            exercise02_cmb07.setItems(exerciseNames);
            exercise02_cmb08.setItems(exerciseNames);
            exercise02_cmb09.setItems(exerciseNames);

            exercise03_cmb01.setItems(exerciseNames);
            exercise03_cmb02.setItems(exerciseNames);
            exercise03_cmb03.setItems(exerciseNames);
            exercise03_cmb04.setItems(exerciseNames);
            exercise03_cmb05.setItems(exerciseNames);
            exercise03_cmb06.setItems(exerciseNames);
            exercise03_cmb07.setItems(exerciseNames);
            exercise03_cmb08.setItems(exerciseNames);
            exercise03_cmb09.setItems(exerciseNames);

            List<String> allReps = exerciseBO.findAllReps();
            ObservableList<String> reps = FXCollections.observableList(allReps);
            cmbReps01.setItems(reps);
            cmbReps02.setItems(reps);
            cmbReps03.setItems(reps);
            cmbReps04.setItems(reps);
            cmbReps05.setItems(reps);
            cmbReps06.setItems(reps);
            cmbReps07.setItems(reps);
            cmbReps08.setItems(reps);
            cmbReps09.setItems(reps);


        } catch (Exception e) {
            e.printStackTrace();
        }
        setScheduleNo();
//        cmbBdyPrt01.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String selectedItem = String.valueOf(cmbBdyPrt01.getSelectionModel().getSelectedItem());
//
//
//
//                try{
//                    if (selectedItem.equals("WarmUps")){
//                        List<String> warmUpExercises = exerciseBO.getWarmUpExercises();
//                        ObservableList<String> warmUps = FXCollections.observableList(warmUpExercises);
//                        exercise01_cmb01.setItems(warmUps);
//                        exercise02_cmb01.setItems(warmUps);
//                        exercise03_cmb01.setItems(warmUps);
//                    }else if (selectedItem.equals("Legs")){
//                        List<String> legExercises = exerciseBO.getLegExercises();
//                        ObservableList<String> Legs = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Legs);
//                        exercise02_cmb01.setItems(Legs);
//                        exercise03_cmb01.setItems(Legs);
//
//
//
//                    }else if (selectedItem.equals("Chest")){
//                        List<String> legExercises = exerciseBO.getChestExercises();
//                        ObservableList<String> Chest = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Chest);
//                        exercise02_cmb01.setItems(Chest);
//                        exercise03_cmb01.setItems(Chest);
//
//
//                    }else if (selectedItem.equals("Shoulders")){
//                        List<String> legExercises = exerciseBO.getShoulderExercises();
//                        ObservableList<String> Shoulders = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Shoulders);
//                        exercise02_cmb01.setItems(Shoulders);
//                        exercise03_cmb01.setItems(Shoulders);
//
//
//                    }else if (selectedItem.equals("Bicep Curl")){
//                        List<String> legExercises = exerciseBO.getBicepExercises();
//                        ObservableList<String> bicep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(bicep);
//                        exercise02_cmb01.setItems(bicep);
//                        exercise03_cmb01.setItems(bicep);
//
//
//                    }else if (selectedItem.equals("Tricep Curls")){
//                        List<String> legExercises = exerciseBO.getTricepExercises();
//                        ObservableList<String> tricep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(tricep);
//                        exercise02_cmb01.setItems(tricep);
//                        exercise03_cmb01.setItems(tricep);
//
//                    }else if (selectedItem.equals("Forearms")){
//                        List<String> legExercises = exerciseBO.getForearmExercises();
//                        ObservableList<String> forearms = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(forearms);
//                        exercise02_cmb01.setItems(forearms);
//                        exercise03_cmb01.setItems(forearms);
//
//                    }else {
//                        List<String> legExercises = exerciseBO.getSixPAckUpExercises();
//                        ObservableList<String> sixPack = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(sixPack);
//                        exercise02_cmb01.setItems(sixPack);
//                        exercise03_cmb01.setItems(sixPack);
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        cmbBdyPrt02.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String selectedItem = String.valueOf(cmbBdyPrt02.getSelectionModel().getSelectedItem());
//
//
//
//                try{
//                    if (selectedItem.equals("WarmUps")){
//                        List<String> warmUpExercises2 = exerciseBO.getWarmUpExercises();
//                        ObservableList<String> warmUps2 = FXCollections.observableList(warmUpExercises2);
//                        exercise01_cmb01.setItems(warmUps2);
//                        exercise02_cmb01.setItems(warmUps2);
//                        exercise03_cmb01.setItems(warmUps2);
//                    }else if (selectedItem.equals("Legs")){
//                        List<String> legExercises2 = exerciseBO.getLegExercises();
//                        ObservableList<String> Legs2 = FXCollections.observableList(legExercises2);
//                        exercise01_cmb01.setItems(Legs2);
//                        exercise02_cmb01.setItems(Legs2);
//                        exercise03_cmb01.setItems(Legs2);
//
//
//
//                    }else if (selectedItem.equals("Chest")){
//                        List<String> legExercises2 = exerciseBO.getChestExercises();
//                        ObservableList<String> Chest2 = FXCollections.observableList(legExercises2);
//                        exercise01_cmb01.setItems(Chest2);
//                        exercise02_cmb01.setItems(Chest2);
//                        exercise03_cmb01.setItems(Chest2);
//
//
//                    }else if (selectedItem.equals("Shoulders")){
//                        List<String> legExercises2 = exerciseBO.getShoulderExercises();
//                        ObservableList<String> Shoulders2 = FXCollections.observableList(legExercises2);
//                        exercise01_cmb01.setItems(Shoulders2);
//                        exercise02_cmb01.setItems(Shoulders2);
//                        exercise03_cmb01.setItems(Shoulders2);
//
//
//                    }else if (selectedItem.equals("Bicep Curl")){
//                        List<String> legExercises2 = exerciseBO.getBicepExercises();
//                        ObservableList<String> bicep2 = FXCollections.observableList(legExercises2);
//                        exercise01_cmb01.setItems(bicep2);
//                        exercise02_cmb01.setItems(bicep2);
//                        exercise03_cmb01.setItems(bicep2);
//
//
//                    }else if (selectedItem.equals("Tricep Curls")){
//                        List<String> legExercises2 = exerciseBO.getTricepExercises();
//                        ObservableList<String> tricep2 = FXCollections.observableList(legExercises2);
//                        exercise01_cmb01.setItems(tricep2);
//                        exercise02_cmb01.setItems(tricep2);
//                        exercise03_cmb01.setItems(tricep2);
//
//                    }else if (selectedItem.equals("Forearms")){
//                        List<String> legExercises2 = exerciseBO.getForearmExercises();
//                        ObservableList<String> forearms2 = FXCollections.observableList(legExercises2);
//                        exercise01_cmb01.setItems(forearms2);
//                        exercise02_cmb01.setItems(forearms2);
//                        exercise03_cmb01.setItems(forearms2);
//
//                    }else {
//                        List<String> legExercises2 = exerciseBO.getSixPAckUpExercises();
//                        ObservableList<String> sixPack2 = FXCollections.observableList(legExercises2);
//                        exercise01_cmb01.setItems(sixPack2);
//                        exercise02_cmb01.setItems(sixPack2);
//                        exercise03_cmb01.setItems(sixPack2);
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//        cmbBdyPrt03.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String selectedItem = String.valueOf(cmbBdyPrt03.getSelectionModel().getSelectedItem());
//
//
//
//                try{
//                    if (selectedItem.equals("WarmUps")){
//                        List<String> warmUpExercises = exerciseBO.getWarmUpExercises();
//                        ObservableList<String> warmUps = FXCollections.observableList(warmUpExercises);
//                        exercise01_cmb01.setItems(warmUps);
//                        exercise02_cmb01.setItems(warmUps);
//                        exercise03_cmb01.setItems(warmUps);
//                    }else if (selectedItem.equals("Legs")){
//                        List<String> legExercises = exerciseBO.getLegExercises();
//                        ObservableList<String> Legs = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Legs);
//                        exercise02_cmb01.setItems(Legs);
//                        exercise03_cmb01.setItems(Legs);
//
//
//
//                    }else if (selectedItem.equals("Chest")){
//                        List<String> legExercises = exerciseBO.getChestExercises();
//                        ObservableList<String> Chest = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Chest);
//                        exercise02_cmb01.setItems(Chest);
//                        exercise03_cmb01.setItems(Chest);
//
//
//                    }else if (selectedItem.equals("Shoulders")){
//                        List<String> legExercises = exerciseBO.getShoulderExercises();
//                        ObservableList<String> Shoulders = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Shoulders);
//                        exercise02_cmb01.setItems(Shoulders);
//                        exercise03_cmb01.setItems(Shoulders);
//
//
//                    }else if (selectedItem.equals("Bicep Curl")){
//                        List<String> legExercises = exerciseBO.getBicepExercises();
//                        ObservableList<String> bicep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(bicep);
//                        exercise02_cmb01.setItems(bicep);
//                        exercise03_cmb01.setItems(bicep);
//
//
//                    }else if (selectedItem.equals("Tricep Curls")){
//                        List<String> legExercises = exerciseBO.getTricepExercises();
//                        ObservableList<String> tricep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(tricep);
//                        exercise02_cmb01.setItems(tricep);
//                        exercise03_cmb01.setItems(tricep);
//
//                    }else if (selectedItem.equals("Forearms")){
//                        List<String> legExercises = exerciseBO.getForearmExercises();
//                        ObservableList<String> forearms = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(forearms);
//                        exercise02_cmb01.setItems(forearms);
//                        exercise03_cmb01.setItems(forearms);
//
//                    }else {
//                        List<String> legExercises = exerciseBO.getSixPAckUpExercises();
//                        ObservableList<String> sixPack = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(sixPack);
//                        exercise02_cmb01.setItems(sixPack);
//                        exercise03_cmb01.setItems(sixPack);
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//        cmbBdyPrt04.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String selectedItem = String.valueOf(cmbBdyPrt04.getSelectionModel().getSelectedItem());
//
//
//
//                try{
//                    if (selectedItem.equals("WarmUps")){
//                        List<String> warmUpExercises = exerciseBO.getWarmUpExercises();
//                        ObservableList<String> warmUps = FXCollections.observableList(warmUpExercises);
//                        exercise01_cmb01.setItems(warmUps);
//                        exercise02_cmb01.setItems(warmUps);
//                        exercise03_cmb01.setItems(warmUps);
//                    }else if (selectedItem.equals("Legs")){
//                        List<String> legExercises = exerciseBO.getLegExercises();
//                        ObservableList<String> Legs = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Legs);
//                        exercise02_cmb01.setItems(Legs);
//                        exercise03_cmb01.setItems(Legs);
//
//
//
//                    }else if (selectedItem.equals("Chest")){
//                        List<String> legExercises = exerciseBO.getChestExercises();
//                        ObservableList<String> Chest = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Chest);
//                        exercise02_cmb01.setItems(Chest);
//                        exercise03_cmb01.setItems(Chest);
//
//
//                    }else if (selectedItem.equals("Shoulders")){
//                        List<String> legExercises = exerciseBO.getShoulderExercises();
//                        ObservableList<String> Shoulders = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Shoulders);
//                        exercise02_cmb01.setItems(Shoulders);
//                        exercise03_cmb01.setItems(Shoulders);
//
//
//                    }else if (selectedItem.equals("Bicep Curl")){
//                        List<String> legExercises = exerciseBO.getBicepExercises();
//                        ObservableList<String> bicep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(bicep);
//                        exercise02_cmb01.setItems(bicep);
//                        exercise03_cmb01.setItems(bicep);
//
//
//                    }else if (selectedItem.equals("Tricep Curls")){
//                        List<String> legExercises = exerciseBO.getTricepExercises();
//                        ObservableList<String> tricep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(tricep);
//                        exercise02_cmb01.setItems(tricep);
//                        exercise03_cmb01.setItems(tricep);
//
//                    }else if (selectedItem.equals("Forearms")){
//                        List<String> legExercises = exerciseBO.getForearmExercises();
//                        ObservableList<String> forearms = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(forearms);
//                        exercise02_cmb01.setItems(forearms);
//                        exercise03_cmb01.setItems(forearms);
//
//                    }else {
//                        List<String> legExercises = exerciseBO.getSixPAckUpExercises();
//                        ObservableList<String> sixPack = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(sixPack);
//                        exercise02_cmb01.setItems(sixPack);
//                        exercise03_cmb01.setItems(sixPack);
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        cmbBdyPrt05.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String selectedItem = String.valueOf(cmbBdyPrt05.getSelectionModel().getSelectedItem());
//
//
//
//                try{
//                    if (selectedItem.equals("WarmUps")){
//                        List<String> warmUpExercises = exerciseBO.getWarmUpExercises();
//                        ObservableList<String> warmUps = FXCollections.observableList(warmUpExercises);
//                        exercise01_cmb01.setItems(warmUps);
//                        exercise02_cmb01.setItems(warmUps);
//                        exercise03_cmb01.setItems(warmUps);
//                    }else if (selectedItem.equals("Legs")){
//                        List<String> legExercises = exerciseBO.getLegExercises();
//                        ObservableList<String> Legs = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Legs);
//                        exercise02_cmb01.setItems(Legs);
//                        exercise03_cmb01.setItems(Legs);
//
//
//
//                    }else if (selectedItem.equals("Chest")){
//                        List<String> legExercises = exerciseBO.getChestExercises();
//                        ObservableList<String> Chest = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Chest);
//                        exercise02_cmb01.setItems(Chest);
//                        exercise03_cmb01.setItems(Chest);
//
//
//                    }else if (selectedItem.equals("Shoulders")){
//                        List<String> legExercises = exerciseBO.getShoulderExercises();
//                        ObservableList<String> Shoulders = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Shoulders);
//                        exercise02_cmb01.setItems(Shoulders);
//                        exercise03_cmb01.setItems(Shoulders);
//
//
//                    }else if (selectedItem.equals("Bicep Curl")){
//                        List<String> legExercises = exerciseBO.getBicepExercises();
//                        ObservableList<String> bicep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(bicep);
//                        exercise02_cmb01.setItems(bicep);
//                        exercise03_cmb01.setItems(bicep);
//
//
//                    }else if (selectedItem.equals("Tricep Curls")){
//                        List<String> legExercises = exerciseBO.getTricepExercises();
//                        ObservableList<String> tricep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(tricep);
//                        exercise02_cmb01.setItems(tricep);
//                        exercise03_cmb01.setItems(tricep);
//
//                    }else if (selectedItem.equals("Forearms")){
//                        List<String> legExercises = exerciseBO.getForearmExercises();
//                        ObservableList<String> forearms = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(forearms);
//                        exercise02_cmb01.setItems(forearms);
//                        exercise03_cmb01.setItems(forearms);
//
//                    }else {
//                        List<String> legExercises = exerciseBO.getSixPAckUpExercises();
//                        ObservableList<String> sixPack = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(sixPack);
//                        exercise02_cmb01.setItems(sixPack);
//                        exercise03_cmb01.setItems(sixPack);
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//        cmbBdyPrt06.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String selectedItem = String.valueOf(cmbBdyPrt06.getSelectionModel().getSelectedItem());
//
//
//
//                try{
//                    if (selectedItem.equals("WarmUps")){
//                        List<String> warmUpExercises = exerciseBO.getWarmUpExercises();
//                        ObservableList<String> warmUps = FXCollections.observableList(warmUpExercises);
//                        exercise01_cmb01.setItems(warmUps);
//                        exercise02_cmb01.setItems(warmUps);
//                        exercise03_cmb01.setItems(warmUps);
//                    }else if (selectedItem.equals("Legs")){
//                        List<String> legExercises = exerciseBO.getLegExercises();
//                        ObservableList<String> Legs = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Legs);
//                        exercise02_cmb01.setItems(Legs);
//                        exercise03_cmb01.setItems(Legs);
//
//
//
//                    }else if (selectedItem.equals("Chest")){
//                        List<String> legExercises = exerciseBO.getChestExercises();
//                        ObservableList<String> Chest = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Chest);
//                        exercise02_cmb01.setItems(Chest);
//                        exercise03_cmb01.setItems(Chest);
//
//
//                    }else if (selectedItem.equals("Shoulders")){
//                        List<String> legExercises = exerciseBO.getShoulderExercises();
//                        ObservableList<String> Shoulders = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Shoulders);
//                        exercise02_cmb01.setItems(Shoulders);
//                        exercise03_cmb01.setItems(Shoulders);
//
//
//                    }else if (selectedItem.equals("Bicep Curl")){
//                        List<String> legExercises = exerciseBO.getBicepExercises();
//                        ObservableList<String> bicep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(bicep);
//                        exercise02_cmb01.setItems(bicep);
//                        exercise03_cmb01.setItems(bicep);
//
//
//                    }else if (selectedItem.equals("Tricep Curls")){
//                        List<String> legExercises = exerciseBO.getTricepExercises();
//                        ObservableList<String> tricep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(tricep);
//                        exercise02_cmb01.setItems(tricep);
//                        exercise03_cmb01.setItems(tricep);
//
//                    }else if (selectedItem.equals("Forearms")){
//                        List<String> legExercises = exerciseBO.getForearmExercises();
//                        ObservableList<String> forearms = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(forearms);
//                        exercise02_cmb01.setItems(forearms);
//                        exercise03_cmb01.setItems(forearms);
//
//                    }else {
//                        List<String> legExercises = exerciseBO.getSixPAckUpExercises();
//                        ObservableList<String> sixPack = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(sixPack);
//                        exercise02_cmb01.setItems(sixPack);
//                        exercise03_cmb01.setItems(sixPack);
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//        cmbBdyPrt07.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String selectedItem = String.valueOf(cmbBdyPrt07.getSelectionModel().getSelectedItem());
//
//
//
//                try{
//                    if (selectedItem.equals("WarmUps")){
//                        List<String> warmUpExercises = exerciseBO.getWarmUpExercises();
//                        ObservableList<String> warmUps = FXCollections.observableList(warmUpExercises);
//                        exercise01_cmb01.setItems(warmUps);
//                        exercise02_cmb01.setItems(warmUps);
//                        exercise03_cmb01.setItems(warmUps);
//                    }else if (selectedItem.equals("Legs")){
//                        List<String> legExercises = exerciseBO.getLegExercises();
//                        ObservableList<String> Legs = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Legs);
//                        exercise02_cmb01.setItems(Legs);
//                        exercise03_cmb01.setItems(Legs);
//
//
//
//                    }else if (selectedItem.equals("Chest")){
//                        List<String> legExercises = exerciseBO.getChestExercises();
//                        ObservableList<String> Chest = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Chest);
//                        exercise02_cmb01.setItems(Chest);
//                        exercise03_cmb01.setItems(Chest);
//
//
//                    }else if (selectedItem.equals("Shoulders")){
//                        List<String> legExercises = exerciseBO.getShoulderExercises();
//                        ObservableList<String> Shoulders = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Shoulders);
//                        exercise02_cmb01.setItems(Shoulders);
//                        exercise03_cmb01.setItems(Shoulders);
//
//
//                    }else if (selectedItem.equals("Bicep Curl")){
//                        List<String> legExercises = exerciseBO.getBicepExercises();
//                        ObservableList<String> bicep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(bicep);
//                        exercise02_cmb01.setItems(bicep);
//                        exercise03_cmb01.setItems(bicep);
//
//
//                    }else if (selectedItem.equals("Tricep Curls")){
//                        List<String> legExercises = exerciseBO.getTricepExercises();
//                        ObservableList<String> tricep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(tricep);
//                        exercise02_cmb01.setItems(tricep);
//                        exercise03_cmb01.setItems(tricep);
//
//                    }else if (selectedItem.equals("Forearms")){
//                        List<String> legExercises = exerciseBO.getForearmExercises();
//                        ObservableList<String> forearms = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(forearms);
//                        exercise02_cmb01.setItems(forearms);
//                        exercise03_cmb01.setItems(forearms);
//
//                    }else {
//                        List<String> legExercises = exerciseBO.getSixPAckUpExercises();
//                        ObservableList<String> sixPack = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(sixPack);
//                        exercise02_cmb01.setItems(sixPack);
//                        exercise03_cmb01.setItems(sixPack);
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        cmbBdyPrt08.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String selectedItem = String.valueOf(cmbBdyPrt08.getSelectionModel().getSelectedItem());
//
//
//
//                try{
//                    if (selectedItem.equals("WarmUps")){
//                        List<String> warmUpExercises = exerciseBO.getWarmUpExercises();
//                        ObservableList<String> warmUps = FXCollections.observableList(warmUpExercises);
//                        exercise01_cmb01.setItems(warmUps);
//                        exercise02_cmb01.setItems(warmUps);
//                        exercise03_cmb01.setItems(warmUps);
//                    }else if (selectedItem.equals("Legs")){
//                        List<String> legExercises = exerciseBO.getLegExercises();
//                        ObservableList<String> Legs = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Legs);
//                        exercise02_cmb01.setItems(Legs);
//                        exercise03_cmb01.setItems(Legs);
//
//
//
//                    }else if (selectedItem.equals("Chest")){
//                        List<String> legExercises = exerciseBO.getChestExercises();
//                        ObservableList<String> Chest = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Chest);
//                        exercise02_cmb01.setItems(Chest);
//                        exercise03_cmb01.setItems(Chest);
//
//
//                    }else if (selectedItem.equals("Shoulders")){
//                        List<String> legExercises = exerciseBO.getShoulderExercises();
//                        ObservableList<String> Shoulders = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Shoulders);
//                        exercise02_cmb01.setItems(Shoulders);
//                        exercise03_cmb01.setItems(Shoulders);
//
//
//                    }else if (selectedItem.equals("Bicep Curl")){
//                        List<String> legExercises = exerciseBO.getBicepExercises();
//                        ObservableList<String> bicep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(bicep);
//                        exercise02_cmb01.setItems(bicep);
//                        exercise03_cmb01.setItems(bicep);
//
//
//                    }else if (selectedItem.equals("Tricep Curls")){
//                        List<String> legExercises = exerciseBO.getTricepExercises();
//                        ObservableList<String> tricep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(tricep);
//                        exercise02_cmb01.setItems(tricep);
//                        exercise03_cmb01.setItems(tricep);
//
//                    }else if (selectedItem.equals("Forearms")){
//                        List<String> legExercises = exerciseBO.getForearmExercises();
//                        ObservableList<String> forearms = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(forearms);
//                        exercise02_cmb01.setItems(forearms);
//                        exercise03_cmb01.setItems(forearms);
//
//                    }else {
//                        List<String> legExercises = exerciseBO.getSixPAckUpExercises();
//                        ObservableList<String> sixPack = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(sixPack);
//                        exercise02_cmb01.setItems(sixPack);
//                        exercise03_cmb01.setItems(sixPack);
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        cmbBdyPrt09.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String selectedItem = String.valueOf(cmbBdyPrt09.getSelectionModel().getSelectedItem());
//
//
//
//                try{
//                    if (selectedItem.equals("WarmUps")){
//                        List<String> warmUpExercises = exerciseBO.getWarmUpExercises();
//                        ObservableList<String> warmUps = FXCollections.observableList(warmUpExercises);
//                        exercise01_cmb01.setItems(warmUps);
//                        exercise02_cmb01.setItems(warmUps);
//                        exercise03_cmb01.setItems(warmUps);
//                    }else if (selectedItem.equals("Legs")){
//                        List<String> legExercises = exerciseBO.getLegExercises();
//                        ObservableList<String> Legs = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Legs);
//                        exercise02_cmb01.setItems(Legs);
//                        exercise03_cmb01.setItems(Legs);
//
//
//
//                    }else if (selectedItem.equals("Chest")){
//                        List<String> legExercises = exerciseBO.getChestExercises();
//                        ObservableList<String> Chest = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Chest);
//                        exercise02_cmb01.setItems(Chest);
//                        exercise03_cmb01.setItems(Chest);
//
//
//                    }else if (selectedItem.equals("Shoulders")){
//                        List<String> legExercises = exerciseBO.getShoulderExercises();
//                        ObservableList<String> Shoulders = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(Shoulders);
//                        exercise02_cmb01.setItems(Shoulders);
//                        exercise03_cmb01.setItems(Shoulders);
//
//
//                    }else if (selectedItem.equals("Bicep Curl")){
//                        List<String> legExercises = exerciseBO.getBicepExercises();
//                        ObservableList<String> bicep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(bicep);
//                        exercise02_cmb01.setItems(bicep);
//                        exercise03_cmb01.setItems(bicep);
//
//
//                    }else if (selectedItem.equals("Tricep Curls")){
//                        List<String> legExercises = exerciseBO.getTricepExercises();
//                        ObservableList<String> tricep = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(tricep);
//                        exercise02_cmb01.setItems(tricep);
//                        exercise03_cmb01.setItems(tricep);
//
//                    }else if (selectedItem.equals("Forearms")){
//                        List<String> legExercises = exerciseBO.getForearmExercises();
//                        ObservableList<String> forearms = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(forearms);
//                        exercise02_cmb01.setItems(forearms);
//                        exercise03_cmb01.setItems(forearms);
//
//                    }else {
//                        List<String> legExercises = exerciseBO.getSixPAckUpExercises();
//                        ObservableList<String> sixPack = FXCollections.observableList(legExercises);
//                        exercise01_cmb01.setItems(sixPack);
//                        exercise02_cmb01.setItems(sixPack);
//                        exercise03_cmb01.setItems(sixPack);
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });



    }

    public void navigate(ActionEvent actionEvent) {
        try {

            if (actionEvent.getSource() instanceof Button){
                Button btn = (Button) actionEvent.getSource();
                Parent root = null;
                switch (btn.getId()){
                    case "btnBack":
                        root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/InstructorDashBoard.fxml"));
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
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnNwSchdle_OnAction(ActionEvent actionEvent) {

         cmbBdyPrt01.getSelectionModel().clearSelection();
         cmbReps01.getSelectionModel().clearSelection();
         cmbBdyPrt02.getSelectionModel().clearSelection();
         cmbBdyPrt03.getSelectionModel().clearSelection();
         cmbBdyPrt04.getSelectionModel().clearSelection();
         cmbBdyPrt06.getSelectionModel().clearSelection();
         cmbBdyPrt07.getSelectionModel().clearSelection();
         cmbBdyPrt05.getSelectionModel().clearSelection();
         cmbBdyPrt08.getSelectionModel().clearSelection();
         cmbReps08.getSelectionModel().clearSelection();
         cmbBdyPrt09.getSelectionModel().clearSelection();
         cmbReps02.getSelectionModel().clearSelection();
         cmbReps03.getSelectionModel().clearSelection();
         cmbReps04.getSelectionModel().clearSelection();
         cmbReps05.getSelectionModel().clearSelection();
         cmbReps06.getSelectionModel().clearSelection();
        cmbReps07.getSelectionModel().clearSelection();
         cmbReps09.getSelectionModel().clearSelection();
         exercise01_cmb01.getSelectionModel().clearSelection();
         exercise02_cmb01.getSelectionModel().clearSelection();
         exercise03_cmb01.getSelectionModel().clearSelection();
         exercise01_cmb02.getSelectionModel().clearSelection();
         exercise01_cmb03.getSelectionModel().clearSelection();
         exercise01_cmb04.getSelectionModel().clearSelection();
         exercise01_cmb05.getSelectionModel().clearSelection();
         exercise01_cmb06.getSelectionModel().clearSelection();
         exercise01_cmb07.getSelectionModel().clearSelection();
         exercise01_cmb08.getSelectionModel().clearSelection();
         exercise01_cmb09.getSelectionModel().clearSelection();
         exercise02_cmb02.getSelectionModel().clearSelection();
         exercise02_cmb03.getSelectionModel().clearSelection();
         exercise02_cmb04.getSelectionModel().clearSelection();
         exercise02_cmb05.getSelectionModel().clearSelection();
         exercise02_cmb06.getSelectionModel().clearSelection();
         exercise02_cmb07.getSelectionModel().clearSelection();
         exercise02_cmb08.getSelectionModel().clearSelection();
         exercise02_cmb09.getSelectionModel().clearSelection();
         exercise03_cmb02.getSelectionModel().clearSelection();
         exercise03_cmb03.getSelectionModel().clearSelection();
         exercise03_cmb04.getSelectionModel().clearSelection();
         exercise03_cmb05.getSelectionModel().clearSelection();
         exercise03_cmb06.getSelectionModel().clearSelection();
         exercise03_cmb07.getSelectionModel().clearSelection();
         exercise03_cmb08.getSelectionModel().clearSelection();
         exercise03_cmb09.getSelectionModel().clearSelection();
         cmbNoOfDays.getSelectionModel().clearSelection();
         txtMembrId.clear();
         setScheduleNo();



    }
    public void setScheduleNo(){
        try {
            int schdlNo = schedulesBO.getLastScheduleNo()+1;
//
            lblSchdleNbr.setText(String.valueOf(schdlNo));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        int noOfDays = 0;
        //Exercise 01
        String bdyPrt01;
        String ex01_01;
        String ex02_01;
        String ex03_01;
        String reps01;

        //Exercise 02
        String bdyPrt02;
        String ex01_02;
        String ex02_02;
        String ex03_02;
        String reps02;

        //Exercise 03
        String bdyPrt03;
        String ex01_03;
        String ex02_03;
        String ex03_03;
        String reps03;

        //Exercise 04
        String bdyPrt04;
        String ex01_04;
        String ex02_04;
        String ex03_04;
        String reps04;

        //Exercise 05
        String bdyPrt05;
        String ex01_05;
        String ex02_05;
        String ex03_05;
        String reps05;

        //Exercise 06
        String bdyPrt06;
        String ex01_06;
        String ex02_06;
        String ex03_06;
        String reps06;

        //Exercise 07
        String bdyPrt07;
        String ex01_07;
        String ex02_07;
        String ex03_07;
        String reps07;

        //Exercise 08
        String bdyPrt08;
        String ex01_08;
        String ex02_08;
        String ex03_08;
        String reps08;

        //Exercise 09
        String bdyPrt09;
        String ex01_09;
        String ex02_09;
        String ex03_09;
        String reps09;

        List<SchedulesDTO> schdlList = new ArrayList<>();
        int ScheduleNo = Integer.parseInt(lblSchdleNbr.getText());
        if (cmbNoOfDays.getSelectionModel().getSelectedItem()!=null){
             noOfDays = cmbNoOfDays.getSelectionModel().getSelectedItem();
        }else {
            new Alert(Alert.AlertType.ERROR,"Enter the day count").show();
            return;
        }
        if (cmbBdyPrt01.getSelectionModel().getSelectedItem()!=null){
            bdyPrt01=cmbBdyPrt01.getSelectionModel().getSelectedItem();

        }else {
            new Alert(Alert.AlertType.ERROR,"Enter the body part 01").show();
            return;
        }
        if (exercise01_cmb01.getSelectionModel().getSelectedItem()!=null){
            ex01_01=exercise01_cmb01.getSelectionModel().getSelectedItem();
        }else {
            ex01_01=null;
        }
        if (exercise02_cmb01.getSelectionModel().getSelectedItem()!=null){
            ex02_01=exercise02_cmb01.getSelectionModel().getSelectedItem();
        }else {
            ex02_01=null;
        }
        if (exercise03_cmb01.getSelectionModel().getSelectedItem()!=null){
            ex03_01=exercise03_cmb01.getSelectionModel().getSelectedItem();
        }else {
            ex03_01=null;
        }
        if (cmbReps01.getSelectionModel().getSelectedItem()!=null){
            reps01 =cmbReps01.getSelectionModel().getSelectedItem();
        }else {
            reps01=null;
        }
        schdlList.add(new SchedulesDTO(ScheduleNo,bdyPrt01,ex01_01,ex02_01,ex03_01,reps01,noOfDays,txtMembrId.getText()));

        if (cmbBdyPrt02.getSelectionModel().getSelectedItem()!=null){
            bdyPrt02=cmbBdyPrt02.getSelectionModel().getSelectedItem();
        }else {
            new Alert(Alert.AlertType.ERROR,"Select the body part 02").show();
            return;
        }
        if (exercise01_cmb02.getSelectionModel().getSelectedItem()!=null){
            ex01_02=exercise01_cmb02.getSelectionModel().getSelectedItem();

        }else {
            ex01_02=null;
        }

        if (exercise02_cmb02.getSelectionModel().getSelectedItem()!=null){
            ex02_02=exercise02_cmb02.getSelectionModel().getSelectedItem();
        }else {
            ex02_02 = null;
        }

        if (exercise03_cmb02.getSelectionModel().getSelectedItem()!=null){
            ex03_02 = exercise03_cmb02.getSelectionModel().getSelectedItem();
        }else {
            ex03_02 = null;
        }

        if (cmbReps02.getSelectionModel().getSelectedItem()!=null){
            reps02 = cmbReps02.getSelectionModel().getSelectedItem();
        }else {
            reps02 = null;
        }

        schdlList.add(new SchedulesDTO(ScheduleNo,bdyPrt02,ex01_02,ex02_02,ex03_02,reps02,noOfDays,txtMembrId.getText()));

        if (cmbBdyPrt03.getSelectionModel().getSelectedItem()!=null){
            bdyPrt03=cmbBdyPrt03.getSelectionModel().getSelectedItem();
        }else {
            new Alert(Alert.AlertType.ERROR,"Select the body part 03").show();
            return;
        }
        if (exercise01_cmb03.getSelectionModel().getSelectedItem()!=null){
            ex01_03 = exercise01_cmb03.getSelectionModel().getSelectedItem();

        }else {
            ex01_03 = null;
        }
        if (exercise02_cmb03.getSelectionModel().getSelectedItem()!=null){
            ex02_03 = exercise02_cmb03.getSelectionModel().getSelectedItem();
        }else {
            ex02_03 = null;
        }
        if (exercise03_cmb03.getSelectionModel().getSelectedItem()!=null){
            ex03_03 = exercise03_cmb03.getSelectionModel().getSelectedItem();
        }else {
            ex03_03 = null;
        }
        if (cmbReps03.getSelectionModel().getSelectedItem()!=null){
            reps03=cmbReps03.getSelectionModel().getSelectedItem();
        }else {
            reps03=null;
        }

        schdlList.add(new SchedulesDTO(ScheduleNo,bdyPrt03,ex01_03,ex02_03,ex03_03,reps03,noOfDays,txtMembrId.getText()));

        if (cmbBdyPrt04.getSelectionModel().getSelectedItem()!=null){
            bdyPrt04=cmbBdyPrt04.getSelectionModel().getSelectedItem();
        }else {
            new Alert(Alert.AlertType.ERROR,"Select the body part 04").show();
            return;
        }

        if (exercise01_cmb04.getSelectionModel().getSelectedItem()!=null){
            ex01_04 = exercise01_cmb04.getSelectionModel().getSelectedItem();
        }else {
            ex01_04 = null;
        }

        if (exercise02_cmb04.getSelectionModel().getSelectedItem()!=null){
            ex02_04 = exercise02_cmb04.getSelectionModel().getSelectedItem();
        }else {
            ex02_04=null;
        }

        if (exercise03_cmb04.getSelectionModel().getSelectedItem()!=null){
            ex03_04 = exercise03_cmb04.getSelectionModel().getSelectedItem();
        }else {
            ex03_04 = null;
        }
        if (cmbReps04.getSelectionModel().getSelectedItem()!=null){
            reps04 = cmbReps04.getSelectionModel().getSelectedItem();
        }else {
            reps04 = null;
        }

        schdlList.add(new SchedulesDTO(ScheduleNo,bdyPrt04,ex01_04,ex02_04,ex03_04,reps04,noOfDays,txtMembrId.getText()));

        if (cmbBdyPrt05.getSelectionModel().getSelectedItem()!=null){
            bdyPrt05=cmbBdyPrt05.getSelectionModel().getSelectedItem();
        }else {
            new Alert(Alert.AlertType.ERROR,"Select the body part 05").show();
            return;
        }
        if (exercise01_cmb05.getSelectionModel().getSelectedItem()!=null){
            ex01_05=exercise01_cmb05.getSelectionModel().getSelectedItem();
        }else {
            ex01_05=null;
        }
        if (exercise02_cmb05.getSelectionModel().getSelectedItem()!=null){
            ex02_05=exercise02_cmb05.getSelectionModel().getSelectedItem();
        }else {
            ex02_05=null;
        }
        if (exercise03_cmb05.getSelectionModel().getSelectedItem()!=null){
            ex03_05 = exercise03_cmb05.getSelectionModel().getSelectedItem();
        }else {
            ex03_05 = null;
        }
        if (cmbReps05.getSelectionModel().getSelectedItem()!=null){
            reps05=cmbReps05.getSelectionModel().getSelectedItem();
        }else {
            reps05=null;
        }


        schdlList.add(new SchedulesDTO(ScheduleNo,bdyPrt05,ex01_05,ex02_05,ex03_05,reps05,noOfDays,txtMembrId.getText()));

        if (cmbBdyPrt06.getSelectionModel().getSelectedItem()!=null){
            bdyPrt06=cmbBdyPrt06.getSelectionModel().getSelectedItem();
        }else {
            new Alert(Alert.AlertType.ERROR,"Slect the boyd part 06").show();
            return;
        }
        if (exercise01_cmb06.getSelectionModel().getSelectedItem()!=null){
            ex01_06=exercise01_cmb06.getSelectionModel().getSelectedItem();
        }else {
            ex01_06=null;
        }

        if (exercise02_cmb06.getSelectionModel().getSelectedItem()!=null){
            ex02_06=exercise02_cmb06.getSelectionModel().getSelectedItem();
        }else {
            ex02_06=null;
        }
        if (exercise03_cmb06.getSelectionModel().getSelectedItem()!=null){
            ex03_06=exercise03_cmb06.getSelectionModel().getSelectedItem();
        }else {
            ex03_06=null;
        }
        if (cmbReps06.getSelectionModel().getSelectedItem()!=null){
            reps06=cmbReps06.getSelectionModel().getSelectedItem();
        }else {
            reps06=null;
        }

        schdlList.add(new SchedulesDTO(ScheduleNo,bdyPrt06,ex01_06,ex02_06,ex03_06,reps06,noOfDays,txtMembrId.getText()));

        if (cmbBdyPrt07.getSelectionModel().getSelectedItem()!=null){
            bdyPrt07=cmbBdyPrt07.getSelectionModel().getSelectedItem();
        }else {
            new Alert(Alert.AlertType.ERROR,"select the body part 07").show();
            return;
        }
        if (exercise01_cmb07.getSelectionModel().getSelectedItem()!=null){
            ex01_07=exercise01_cmb07.getSelectionModel().getSelectedItem();
        }else {
            ex01_07=null;
        }
        if (exercise02_cmb07.getSelectionModel().getSelectedItem()!=null){
            ex02_07=exercise02_cmb07.getSelectionModel().getSelectedItem();
        }else {
            ex02_07=null;
        }

        if (exercise03_cmb07.getSelectionModel().getSelectedItem()!=null){
            ex03_07=exercise03_cmb07.getSelectionModel().getSelectedItem();
        }else {
            ex03_07=null;
        }

        if (cmbReps07.getSelectionModel().getSelectedItem()!=null){
            reps07=cmbReps07.getSelectionModel().getSelectedItem();

        }else {
            reps07 = null;
        }

        schdlList.add(new SchedulesDTO(ScheduleNo,bdyPrt07,ex01_07,ex02_07,ex03_07,reps07,noOfDays,txtMembrId.getText()));

        if (cmbBdyPrt08.getSelectionModel().getSelectedItem()!=null){
            bdyPrt08 = cmbBdyPrt08.getSelectionModel().getSelectedItem();
        }else {
            new Alert(Alert.AlertType.ERROR,"Select the Body part 08").show();
            return;
        }
        if (exercise01_cmb08.getSelectionModel().getSelectedItem()!=null){
            ex01_08=exercise01_cmb08.getSelectionModel().getSelectedItem();
        }else {
            ex01_08=null;
        }
        if (exercise02_cmb08.getSelectionModel().getSelectedItem()!=null){
            ex02_08=exercise02_cmb08.getSelectionModel().getSelectedItem();
        }else {
            ex02_08=null;
        }
        if (exercise03_cmb08.getSelectionModel().getSelectedItem()!=null){
            ex03_08=exercise03_cmb08.getSelectionModel().getSelectedItem();
        }else {
            ex03_08=null;
        }
        if (cmbReps08.getSelectionModel().getSelectedItem()!=null){
            reps08 = cmbReps08.getSelectionModel().getSelectedItem();
        }else {
            reps08=null;
        }


        schdlList.add(new SchedulesDTO(ScheduleNo,bdyPrt08,ex01_08,ex02_08,ex03_08,reps08,noOfDays,txtMembrId.getText()));
        if (cmbBdyPrt09.getSelectionModel().getSelectedItem()!=null){
            bdyPrt09=cmbBdyPrt09.getSelectionModel().getSelectedItem();
        }else {
            new Alert(Alert.AlertType.ERROR,"Select the body part 09").show();
            return;
        }
        if (exercise01_cmb09.getSelectionModel().getSelectedItem()!=null){
            ex01_09=exercise01_cmb09.getSelectionModel().getSelectedItem();
        }else {
            ex01_09=null;
        }

        if (exercise02_cmb09.getSelectionModel().getSelectedItem()!=null){
            ex02_09=exercise02_cmb09.getSelectionModel().getSelectedItem();
        }else {
            ex02_09=null;
        }
        if (exercise03_cmb09.getSelectionModel().getSelectedItem()!=null){
            ex03_09=exercise03_cmb09.getSelectionModel().getSelectedItem();
        }else {
            ex03_09=null;
        }
        if (cmbReps09.getSelectionModel().getSelectedItem()!=null){
            reps09=cmbReps09.getSelectionModel().getSelectedItem();
        }else {
            reps09=null;
        }
        schdlList.add(new SchedulesDTO(ScheduleNo,bdyPrt09,ex01_09,ex02_09,ex03_09,reps09,noOfDays,txtMembrId.getText()));

//        SchedulesBOImplTest schedulesBOImplTest = new SchedulesBOImplTest();

        try {
            boolean isSaved = schedulesBO.saveSchedule(new MainScheduleDTO(schdlList));
            if (isSaved==true){
                new Alert(Alert.AlertType.INFORMATION,"Schedule Saved").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Failled to Saved").show();
                throw new RuntimeException("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnPrnt_OnAction(ActionEvent actionEvent) {
    }

    public void btnView_OnAction(ActionEvent actionEvent) {


    }


}
