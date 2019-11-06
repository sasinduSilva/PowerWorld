package lk.ijse.dep.powerWorldGyms.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.crypto.BraavoEncrypt;
import lk.ijse.dep.powerWorldGyms.business.BOFactory;
import lk.ijse.dep.powerWorldGyms.business.BOTypes;
import lk.ijse.dep.powerWorldGyms.business.custom.MembershipBO;
import lk.ijse.dep.powerWorldGyms.business.custom.SchedulesBO;
import lk.ijse.dep.powerWorldGyms.dto.MembershipDTO;
import lk.ijse.dep.powerWorldGyms.dto.MembershipDTO02;
import lk.ijse.dep.powerWorldGyms.util.MembershipTM;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class IssueMembershipController {
    public AnchorPane root;
    public Button btnBack;
    public Button btnLogout;
    public Button btnAbt;
    public Button btnHlp;
    public Button btnCntct;
    public JFXTextField txtMemberID;
    public JFXTextField txtName;
    public JFXTextField txtContctNo;
    public ComboBox<String> cmbTypes;
    public JFXTextField txtPrice;
    public JFXPasswordField txtPw1;
    public JFXPasswordField txtPw2;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnDlete;
    public ComboBox<String> cmbFat;


    public TableView<MembershipTM> tblMembers;
    public JFXTextField txtSrch;
    public ComboBox<Integer> cmbSchdlNo;
    public Label lblDate;
    public JFXTextField txtHeight;
    public JFXTextField txtWeight;
    public ImageView imgTick;
    public JFXTextField txtBmiRange;
    public JFXTextField txtExpDate;
    public Label lblInstructId;
    public JFXTextArea txtNotification;

    SchedulesBO schedulesBO = BOFactory.getInstance().getBo(BOTypes.SCHEDULES);
    MembershipBO membershipBO = BOFactory.getInstance().getBo(BOTypes.MEMBERSHIP);

    public void initialize() {
        tblMembers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("membrID"));
        tblMembers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMembers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("expDate"));
        tblMembers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("schdlNo"));

        try {
            List<MembershipDTO02> allMembers = membershipBO.findAllMembers();
            List<MembershipTM> tmList = new ArrayList<>();

            for (MembershipDTO02 member : allMembers) {
                tmList.add(new MembershipTM(member.getMemberId(),
                        member.getName(),
                        member.getDate(),
                        member.getSchdlNo()));
            }
            ObservableList<MembershipTM> membershipTMS = FXCollections.observableList(tmList);
            tblMembers.setItems(membershipTMS);


        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<MembershipTM> tblArray = tblMembers.getItems();
        txtSrch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tblArray.clear();
//                ObservableList<MembershipTM> membershipTMS = FXCollections.observableArrayList(tblMembers.getItems());
//                membershipTMS.clear();
//                tblMembers.setItems(membershipTMS);
                try {
                    List<MembershipDTO02> membershipDTO02s = membershipBO.searchMemberDetails(newValue + "%");
                    for (MembershipDTO02 membershipDTO02 : membershipDTO02s) {
                        tblArray.add(new MembershipTM(membershipDTO02.getMemberId(),
                                membershipDTO02.getName(),
                                membershipDTO02.getDate(),
                                membershipDTO02.getSchdlNo()));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        try {
            List<Integer> scheduleNumbers = schedulesBO.getScheduleNumbers();
            ObservableList<Integer> cmbSchdlArray = FXCollections.observableList(scheduleNumbers);
            cmbSchdlNo.setItems(cmbSchdlArray);
        } catch (Exception e) {
            e.printStackTrace();
        }

        imgTick.setVisible(false);

        txtPw2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals(txtPw1.getText())) {
                    imgTick.setVisible(true);
                } else {
                    imgTick.setVisible(false);
                }
            }
        });

        cmbTypes.getItems().add("1 year");
        cmbTypes.getItems().add("2 year");
        cmbTypes.getItems().add("3 year");
        cmbTypes.getItems().add("4 year");
        cmbTypes.getItems().add("5 year");
        cmbTypes.getItems().add("10 year");
        cmbTypes.getItems().add("Lifetime");



        lblDate.setText(String.valueOf(LocalDate.now()));

        cmbTypes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String selectedItem = cmbTypes.getSelectionModel().getSelectedItem();
                switch (selectedItem){
                    case "1 year":
                        txtExpDate.setText(String.valueOf(LocalDate.now().plusYears(1)));
                        txtPrice.setText("Rs "+5000.00);
                        break;
                    case "2 year":
                        txtExpDate.setText(String.valueOf(LocalDate.now().plusYears(2)));
                        txtPrice.setText("Rs "+10000.00);
                        break;
                    case "3 year":
                        txtExpDate.setText(String.valueOf(LocalDate.now().plusYears(3)));
                        txtPrice.setText("Rs "+15000.00);
                        break;
                    case "4 year":
                        txtExpDate.setText(String.valueOf(LocalDate.now().plusYears(4)));
                        txtPrice.setText("Rs "+20000.00);
                        break;
                    case "5 year":
                        txtExpDate.setText(String.valueOf(LocalDate.now().plusYears(5)));
                        txtPrice.setText("Rs "+25000.00);
                        break;
                    case "10 year":
                        txtExpDate.setText(String.valueOf(LocalDate.now().plusYears(10)));
                        txtPrice.setText("Rs "+35000.00);
                        break;
                    case "Lifetime":
                        txtExpDate.setText("Lifetime");
                        txtPrice.setText("Rs "+50000.00);
                        break;


                }

            }
        });
        setMemberId();
        cmbFat.getItems().add("Low");
        cmbFat.getItems().add("Medium");
        cmbFat.getItems().add("High");

        tblMembers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MembershipTM>() {
            @Override
            public void changed(ObservableValue<? extends MembershipTM> observable, MembershipTM oldValue, MembershipTM newValue) {
                MembershipTM selectedItem = tblMembers.getSelectionModel().getSelectedItem();
                if (selectedItem!=null){
                    try {
                        MembershipDTO membership = membershipBO.findMembership(selectedItem.getMembrID());
                        cmbTypes.getSelectionModel().select(membership.getMembershipDetailsDTO().getType());
                        txtMemberID.setText(membership.getMembershipId());
                        txtName.setText(membership.getName());
                        txtContctNo.setText(membership.getContactNo());
                        txtPw1.setText(membership.getPassword());
                        txtPw2.setText(membership.getPassword());
                        txtBmiRange.setText(membership.getBmiRange());
                        lblDate.setText(String.valueOf(membership.getMembershipDetailsDTO().getDate()));
                        lblInstructId.setText(membership.getMembershipDetailsDTO().getInstructId());
                        cmbFat.getSelectionModel().select(membership.getFatRange());
                        cmbSchdlNo.getSelectionModel().select(membership.getScheduleNo());

                        btnAdd.setDisable(true);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }
        });


    }


    public void navigate(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof Button){
            Button btn = (Button) actionEvent.getSource();
            Parent root = null;

            try {
                switch (btn.getId()){
                    case "btnLogout" :
                        root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/InstructorLoginForm.fxml"));
                        break;
                    case "btnBack":
                        root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/InstructorDashBoard.fxml"));


                }
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();
                primaryStage.show();

            }catch (Exception e){

            }

        }

    }

    public void PwValidation(ActionEvent actionEvent) {}


        public void btnAdd_OnAction (ActionEvent actionEvent){
        String pw = BraavoEncrypt.encode(txtPw2.getText(),txtMemberID.getText());

            Date date = Date.valueOf(lblDate.getText());
            Date expDate= Date.valueOf(txtExpDate.getText());
            double price = Double.parseDouble(txtPrice.getText().replace("Rs",""));
            try {
                boolean isSaved = membershipBO.saveMembership(new MembershipDTO(
                        lblInstructId.getText(),
                        cmbTypes.getSelectionModel().getSelectedItem(),
                        date,
                        expDate,
                        txtMemberID.getText(),
                        txtName.getText(),
                        txtContctNo.getText(),
                        txtBmiRange.getText(),
                        cmbFat.getSelectionModel().getSelectedItem(),
                        pw,
                        cmbSchdlNo.getSelectionModel().getSelectedItem(),
                        txtNotification.getText(),
                        price
                        ));
                if (isSaved==true){
                    ObservableList<MembershipTM> tblArray = tblMembers.getItems();
                    tblArray.add(new MembershipTM(txtMemberID.getText(),
                            txtName.getText(),
                            expDate,cmbSchdlNo.getSelectionModel().getSelectedItem()));
                    new Alert(Alert.AlertType.INFORMATION,"Member Saved").show();
                }else {
                    new Alert(Alert.AlertType.INFORMATION,"Failled to Save Member").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void btnUpdate_OnAction (ActionEvent actionEvent){
            String pw = BraavoEncrypt.encode(txtPw2.getText(),txtMemberID.getText());

            Date date = Date.valueOf(lblDate.getText());
            Date expDate= Date.valueOf(txtExpDate.getText());
            try {
                boolean isUpdatd = membershipBO.updateMembership(new MembershipDTO(
                        lblInstructId.getText(),
                        cmbTypes.getSelectionModel().getSelectedItem(),
                        date,
                        expDate,
                        txtMemberID.getText(),
                        txtName.getText(),
                        txtContctNo.getText(),
                        txtBmiRange.getText(),
                        cmbFat.getSelectionModel().getSelectedItem(),
                        pw,
                        cmbSchdlNo.getSelectionModel().getSelectedItem(),
                        txtNotification.getText(),
                        Double.parseDouble(txtPrice.getText().replace("Rs",""))
                ));
                if (isUpdatd==true){
                    MembershipTM selectedItem = tblMembers.getSelectionModel().getSelectedItem();
                    selectedItem.setName(txtName.getText());
                    selectedItem.setExpDate(Date.valueOf(txtExpDate.getText()));
                    selectedItem.setSchdlNo(cmbSchdlNo.getSelectionModel().getSelectedItem());
                    tblMembers.refresh();

                    new Alert(Alert.AlertType.INFORMATION,"Details Updated").show();
                }else {
                    new Alert(Alert.AlertType.INFORMATION,"Failled to Update").show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void btnDlete_OnAction (ActionEvent actionEvent){
          try {
            boolean isDeleted = membershipBO.deleteMembership(txtMemberID.getText());
            if (isDeleted==true){
              new Alert(Alert.AlertType.INFORMATION,"Member Deleted").show();
              tblMembers.getItems().remove(tblMembers.getSelectionModel().getSelectedItem());
              return;
            }
          } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return;
          }


        }

        public void txtHeight_ActionEvent (ActionEvent actionEvent){
            txtWeight.requestFocus();
        }
        public void setMemberId(){
            int maxMemberNum = 0;
            try {
                maxMemberNum=membershipBO.getLastMembership();
                maxMemberNum++;
                if (maxMemberNum<10){
                    txtMemberID.setText("M00"+maxMemberNum);
                }else if (maxMemberNum<100){
                    txtMemberID.setText("M0"+maxMemberNum);
                }else {
                    txtMemberID.setText("M"+maxMemberNum);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        public void txtWeight_ActionEvent (ActionEvent actionEvent){
            float height = Float.parseFloat(txtHeight.getText());
            float weight = Float.parseFloat(txtWeight.getText());
            float height2 = height * height;
            float bmi = weight / height2;

            if (bmi < 18.5) {
                txtBmiRange.setText("Underweight");
            } else if (bmi > 18.5 && bmi < 24.9) {
                txtBmiRange.setText("Healthy weight");
            } else if (bmi > 25.0 && bmi < 29.9) {
                txtBmiRange.setText("Overweight");
            } else {
                txtBmiRange.setText("Obese");
            }


        }
    }


