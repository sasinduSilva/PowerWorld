package lk.ijse.dep.powerWorldGyms.controller;

import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.powerWorldGyms.business.BOFactory;
import lk.ijse.dep.powerWorldGyms.business.BOTypes;
import lk.ijse.dep.powerWorldGyms.business.custom.EquipmentsBO;
import lk.ijse.dep.powerWorldGyms.business.custom.InstructorsBO;
import lk.ijse.dep.powerWorldGyms.dto.EquipmentDTO;
import lk.ijse.dep.powerWorldGyms.dto.InstructorsDTO;
import lk.ijse.dep.powerWorldGyms.util.EquipmentTM;
import lk.ijse.dep.powerWorldGyms.util.InstructorsTM;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManagerPanelController implements Initializable {
    public Button btnBack;
    public Button btnLogout;
    public Button btnAbout;
    public Button btnHelp;
    public Button btnContact;
    public JFXTextField txtMchinID;
    public JFXTextField txtMchineName;
    public JFXTextField txtBuyingPRice;
    public JFXTextField txtWarrantyPrido;
    public JFXTextField txtBuyingDAte;
    public JFXTextField txtUsefullLifetime;
    public TableView<EquipmentTM> tblEquipment;
    public JFXTextField txtSrchMachine;
    public JFXTextField txtEmpId;
    public JFXTextField txtEMPName;
    public JFXTextField txtEmpshift;
    public JFXTextField txtEmpContact;
    public TableView<InstructorsTM> tblEmp;
    public JFXTextField txtSrchEmp;
    public Button btnAddInstructor;
    public Button btnUpdateInstructor;
    public Button btnDeleteInstructor;
    public Button btnAddEqupment;
    public Button btnUpdateEquipment;
    public Button btnDeleteEquipment;
    public AnchorPane root;
    public JFXPasswordField txtPw1;
    public JFXPasswordField txtPw2;
  public Button btnNew;
  public ImageView imgTick;

  private EquipmentsBO equipmentsBO = BOFactory.getInstance().getBo(BOTypes.EQUIPMENTS);
    private InstructorsBO instructorsBO = BOFactory.getInstance().getBo(BOTypes.INSTRUCTORS);


    public void navigate(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof Button){
            Button btn = (Button) actionEvent.getSource();
            Parent root=null;
            try {
                switch (btn.getId()){
                    case "btnLogout":
                        root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/ManagerLoginForm.fxml"));
                        break;

                }
                if (root!=null){
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      setMachineId();

      tblEquipment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("equipId"));
      tblEquipment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
      tblEquipment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
      tblEquipment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("warrantyPriod"));
      tblEquipment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("baughtDate"));
      tblEquipment.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("lifeTime"));


      tblEmp.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
      tblEmp.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
      tblEmp.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("shift"));
      tblEmp.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contactNo"));






      txtMchinID.setEditable(false);
      txtEmpId.setEditable(false);
      imgTick.setVisible(false);

      txtBuyingDAte.setText(LocalDate.now()+"");

      try {

        List<EquipmentDTO> allEquips = equipmentsBO.findAllEquips();
        List<EquipmentTM> equipList = new ArrayList<>();
        for (EquipmentDTO allEquip : allEquips) {
          equipList.add(new EquipmentTM(allEquip.getEquipId(),
            allEquip.getEquipName(),
            allEquip.getBuyingPrice(),
            allEquip.getWarrantyPeriod(),
            allEquip.getBuyingDate(),
            allEquip.getLifeTime()));

        }
        ObservableList<EquipmentTM> equipmentTMS = FXCollections.observableList(equipList);
        tblEquipment.setItems(equipmentTMS);

        List<InstructorsDTO> allInstructors = instructorsBO.findAllInstructors();
        List<InstructorsTM> empList = new ArrayList<>();
        for (InstructorsDTO allInstructor : allInstructors) {
          empList.add(new InstructorsTM(allInstructor.getEmpId(),
            allInstructor.getName(),
            allInstructor.getShift(),
            allInstructor.getContactNo()));


        }
        ObservableList<InstructorsTM> instructorsTMS = FXCollections.observableList(empList);
        tblEmp.setItems(instructorsTMS);


      }catch (Exception e){
        e.printStackTrace();
      }
      tblEquipment.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<EquipmentTM>() {
        @Override
        public void changed(ObservableValue<? extends EquipmentTM> observable, EquipmentTM oldValue, EquipmentTM newValue) {
          EquipmentTM selectedItem = tblEquipment.getSelectionModel().getSelectedItem();
          if (selectedItem!=null){
            txtMchinID.setText(selectedItem.getEquipId());
            txtBuyingPRice.setText(selectedItem.getPrice()+"");
            txtBuyingDAte.setText(selectedItem.getBaughtDate()+"");
            txtMchineName.setText(selectedItem.getName());
            txtWarrantyPrido.setText(selectedItem.getWarrantyPriod());
            txtUsefullLifetime.setText(selectedItem.getLifeTime()+"");
          }
        }
      });

      tblEmp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<InstructorsTM>() {
        @Override
        public void changed(ObservableValue<? extends InstructorsTM> observable, InstructorsTM oldValue, InstructorsTM newValue) {
          InstructorsTM selectedItem = tblEmp.getSelectionModel().getSelectedItem();
          if (selectedItem!=null){
            txtEmpId.setText(selectedItem.getId());
            txtEMPName.setText(selectedItem.getName());
            txtEmpshift.setText(selectedItem.getShift());
            txtEmpContact.setText(selectedItem.getContactNo());
          }
        }
      });

      ObservableList<InstructorsTM> empTblArray = tblEmp.getItems();
      txtSrchEmp.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          empTblArray.clear();
          try {
            List<InstructorsDTO> instructorsDTOS = instructorsBO.searchEmp(newValue + "%");
            for (InstructorsDTO instructorsDTO : instructorsDTOS) {
              empTblArray.add(new InstructorsTM(instructorsDTO.getEmpId(),
                instructorsDTO.getName(),
                instructorsDTO.getShift(),
                instructorsDTO.getContactNo()));

            }

          }catch (Exception e){
            e.printStackTrace();
          }
        }
      });

      ObservableList<EquipmentTM> tblArray = tblEquipment.getItems();
      txtSrchMachine.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          tblArray.clear();
          try {
            List<EquipmentDTO> equipmentDTOS = equipmentsBO.searchMachin(newValue + "%");
            for (EquipmentDTO equipmentDTO : equipmentDTOS) {
              tblArray.add(new EquipmentTM(equipmentDTO.getEquipId(),
                equipmentDTO.getEquipName(),
                equipmentDTO.getBuyingPrice(),
                equipmentDTO.getWarrantyPeriod(),
                equipmentDTO.getBuyingDate(),
                equipmentDTO.getLifeTime()));

            }
          }catch (Exception e){
            e.printStackTrace();
          }



        }
      });

      txtPw2.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
         if (txtPw2!=null){
           if (newValue.equals(txtPw1.getText())){
             imgTick.setVisible(true);
           }else {
             imgTick.setVisible(false);
           }
         }
        }
      });




    }

    public void btnAddInstructor_OnAction(ActionEvent actionEvent) {
        try {
            boolean isAdded = instructorsBO.saveInstructor(new InstructorsDTO(txtEmpId.getText(),
                    txtEMPName.getText(),
                    txtEmpshift.getText(),
                    txtEmpContact.getText(),
                    txtPw2.getText()));
            if (isAdded==true){
              Alert alert = new Alert(Alert.AlertType.INFORMATION, "Instructor Added",ButtonType.OK);
              Optional<ButtonType> btnType = alert.showAndWait();
              if (btnType.get()==ButtonType.OK){
                isAdded = tblEmp.getItems().add(new InstructorsTM(txtEmpId.getText(),
                  txtEMPName.getText(),
                  txtEmpshift.getText(),
                  txtEmpContact.getText()));
                if (isAdded==true){
                  btnNew_OnAction(actionEvent);


                }


              }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateInstructor_OnAction(ActionEvent actionEvent) {
        try {
            boolean isAdded = instructorsBO.updateInstructor(new InstructorsDTO(txtEmpId.getText(),
                    txtEMPName.getText(),
                    txtEmpshift.getText(),
                    txtEmpContact.getText(),
                    txtPw2.getText()));
            if (isAdded==true){
                new Alert(Alert.AlertType.INFORMATION,"Instructor Added").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteInstructor_OnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Sure you wana delete?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get()==ButtonType.YES){
            try {
                boolean isDeleted = instructorsBO.deleteInstructor(txtEmpId.getText());
                if (isDeleted==true){
                    new Alert(Alert.AlertType.INFORMATION,"Instructor Deleted");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void btnAddEqupment_Onaction(ActionEvent actionEvent) {
        Date byingDate = Date.valueOf(LocalDate.now());
        try {
            boolean isAdded = equipmentsBO.saveEquipment(new EquipmentDTO(txtMchinID.getText(),
                    txtMchineName.getText(),
                    Double.parseDouble(txtBuyingPRice.getText()),
                    byingDate,
                    txtWarrantyPrido.getText(),
                    Integer.parseInt(txtUsefullLifetime.getText())));
            if (isAdded==true){
                new Alert(Alert.AlertType.INFORMATION,"Equipment Added").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateEquipment_OnAction(ActionEvent actionEvent) {
        try {
            boolean isAdded = equipmentsBO.updateEquipment(new EquipmentDTO(txtMchinID.getText(),
                    txtMchineName.getText(),
                    Double.parseDouble(txtBuyingPRice.getText()),
                    Date.valueOf(txtBuyingDAte.getText()),
                    txtWarrantyPrido.getText(),
                    Integer.parseInt(txtUsefullLifetime.getText())));
            if (isAdded==true){
                new Alert(Alert.AlertType.INFORMATION,"Equipment Updated").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteEquipmentOnaction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Sure you wanna delete?? ", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get()==ButtonType.YES){
            try {
                boolean isDeleted = equipmentsBO.deleteEquipment(txtMchinID.getText());
                new Alert(Alert.AlertType.INFORMATION,"Equipment Deleted").show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    public void setMachineId(){
      txtBuyingDAte.setText(String.valueOf(LocalDate.now()));
      int maxMachineID = 0;
      int maxEmpId = 0;
      try {
        maxMachineID = equipmentsBO.getLastEquipId();
        maxEmpId = instructorsBO.getLastEmpId();
        maxEmpId++;
        maxMachineID++;
        System.out.println(maxMachineID);
        if (maxMachineID<10){
          txtMchinID.setText("EQ00"+maxMachineID);
        }else if (maxMachineID<100){
          txtMchinID.setText("EQ0"+maxMachineID);
        }else {
          txtMchinID.setText("EQ"+maxMachineID);
        }
        if (maxEmpId<10){
          txtEmpId.setText("EMP00"+maxEmpId);
        }else if (maxEmpId<100){
          txtEmpId.setText("EMP0"+maxEmpId);
        }else {
          txtEmpId.setText("EMP"+maxEmpId);
        }



      }catch (Exception e){
        e.printStackTrace();
      }

    }

  public void btnNew_OnAction(ActionEvent actionEvent) {
      txtEmpId.clear();
      txtEMPName.clear();
      txtEmpshift.clear();
      txtEmpContact.clear();
      txtPw1.clear();
      txtPw2.clear();
      txtSrchEmp.clear();
      txtMchinID.clear();
      txtMchineName.clear();
      txtBuyingPRice.clear();
      txtBuyingDAte.clear();
      txtWarrantyPrido.clear();
      txtUsefullLifetime.clear();
      txtSrchMachine.clear();
      setMachineId();

  }
}


