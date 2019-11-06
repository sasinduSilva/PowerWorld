package lk.ijse.dep.powerWorldGyms.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class test01Controller {
    public AnchorPane root;
    public Button testBtn01;

    public void navigate(ActionEvent actionEvent) throws IOException {

        if (actionEvent.getSource() instanceof Button) {
            Button btn = (Button) actionEvent.getSource();

            Parent root = null;

            switch (btn.getId()) {
                case "testBtn01":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/test02.fxml"));
                    break;
                case "btnInstrctrPnl":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/InstructorLoginForm.fxml"));
                    break;
                case "btnMangmntPnl":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/ManagerLoginForm.fxml"));
                    break;

            }

            if (root != null) {
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), scene.getRoot());
                tt.setFromX(-scene.getWidth());
                tt.setToY(0);
                tt.play();

            }
            }
        }
}
