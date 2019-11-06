package lk.ijse.dep.powerWorldGyms.controller;

import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.powerWorldGyms.business.BOFactory;
import lk.ijse.dep.powerWorldGyms.business.BOTypes;
import lk.ijse.dep.powerWorldGyms.business.custom.ExerciseBO;
import lk.ijse.dep.powerWorldGyms.business.exception.AlreadyExistScheduleException;
import lk.ijse.dep.powerWorldGyms.dto.ExerciseDTO;
import lk.ijse.dep.powerWorldGyms.util.ExerciseTM;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CreateExerciseController {
    public AnchorPane root;
    public JFXTextField txtbodyPart;
    public JFXTextField txtReps;
    public JFXTextField txtName;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnDelete;
    public TableView<ExerciseTM> tblExrcise;
    public JFXTextField txtSrch;
    public Button btnBack;

    private ExerciseBO exerciseBO = BOFactory.getInstance().getBo(BOTypes.EXERCISE);


    public void initialize() {
        tblExrcise.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bodyPart"));
        tblExrcise.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblExrcise.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("reps"));

        try {
            List<ExerciseDTO> allExercises = exerciseBO.findAllExercises();
            ObservableList<ExerciseTM> items = tblExrcise.getItems();
            for (ExerciseDTO allExercise : allExercises) {
                items.add(new ExerciseTM(allExercise.getExerciseName(),
                        allExercise.getBodyPart(),
                        allExercise.getReps()));

            }
            tblExrcise.refresh();


        } catch (Exception e) {
            e.printStackTrace();
        }
        tblExrcise.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ExerciseTM>() {
            @Override
            public void changed(ObservableValue<? extends ExerciseTM> observable, ExerciseTM oldValue, ExerciseTM newValue) {
                ExerciseTM selectedItem = tblExrcise.getSelectionModel().getSelectedItem();
                if (selectedItem!=null){
                    txtName.setText(selectedItem.getName());
                    txtbodyPart.setText(selectedItem.getBodyPart());
                    txtReps.setText(selectedItem.getReps());
                }
            }
        });
        ObservableList<ExerciseTM> tblArray =tblExrcise.getItems();
        txtSrch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tblArray.clear();
//                String txt = newValue;
                try {
                    List<ExerciseDTO> searchLst = exerciseBO.search(newValue + "%");
                    for (ExerciseDTO exerciseDTO : searchLst) {
                        tblArray.add(new ExerciseTM(exerciseDTO.getBodyPart(),exerciseDTO.getExerciseName(),exerciseDTO.getReps()));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });


    }

    public void btnAdd_OnAction(ActionEvent actionEvent) {
      try{
          boolean isAdded = exerciseBO.saveExercise(new ExerciseDTO(txtbodyPart.getText(),
                  txtName.getText(),
                  txtReps.getText()));
          if (isAdded==true){
              tblExrcise.getItems().add(new ExerciseTM(txtName.getText(),txtbodyPart.getText(),txtReps.getText()));
              tblExrcise.refresh();
              txtName.clear();
              txtbodyPart.clear();
              txtReps.clear();
              txtName.requestFocus();
          }else {
              new Alert(Alert.AlertType.ERROR,"Failled to add").show();
              throw new RuntimeException("Something went wrong");
          }

      }catch (Exception e){
          e.printStackTrace();
      }
    }

    public void btnUpdate_OnAction(ActionEvent actionEvent) {


        try{
            boolean isUpdated = exerciseBO.updateExercise(new ExerciseDTO(txtbodyPart.getText(),
                    txtName.getText(),txtReps.getText()));

            if (isUpdated==true){
                ExerciseTM selectedItem = tblExrcise.getSelectionModel().getSelectedItem();
                if (selectedItem!=null){
                    selectedItem.setReps(txtReps.getText());
                    txtName.clear();
                    txtbodyPart.clear();
                    txtReps.clear();
                }
                tblExrcise.refresh();

            }else {
                new Alert(Alert.AlertType.ERROR,"Failled to update").show();
                throw new RuntimeException("Something went wrong");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ??", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get()==ButtonType.YES){
            try {
                ExerciseTM selectedItem = tblExrcise.getSelectionModel().getSelectedItem();

                    boolean deleted = exerciseBO.deleteExercise(selectedItem.getBodyPart(),selectedItem.getName());
                    if (deleted==true){
                        new Alert(Alert.AlertType.INFORMATION,"Deleted Sucessfully").show();
                        tblExrcise.getItems().remove(selectedItem);
                        tblExrcise.refresh();
                        txtName.clear();
                        txtbodyPart.clear();
                        txtReps.clear();
                    }



            }catch (AlreadyExistScheduleException e){
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }catch (MySQLIntegrityConstraintViolationException e1){
                new Alert(Alert.AlertType.ERROR,e1.getMessage()).show();

            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }


    public void navigate(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof Button){
            Button btn = (Button) actionEvent.getSource();
            Parent root = null;
            try {
                switch (btn.getId()){
                    case "btnBack" :
                        root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/InstructorDashBoard.fxml"));
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
}
