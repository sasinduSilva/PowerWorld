package lk.ijse.dep.powerWorldGyms.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainDashboardController {
    public Button btnAbout;
    public Button btnHelp;
    public Button btnContactUs;
    public Button btnMembrPnl;
    public Button btnInstrctrPnl;
    public Button btnMangmntPnl;
    public AnchorPane root;

    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
//        pgb.setVisible(false);
    }


    public void navigate(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() instanceof Button){
            Button btn = (Button) actionEvent.getSource();

            Parent root = null;
            switch (btn.getId()){
                case "btnMembrPnl":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/MemberLoginForm.fxml"));
                    break;
                case "btnInstrctrPnl":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/InstructorLoginForm.fxml"));
                    break;
                case "btnMangmntPnl":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/powerWorldGyms/view/ManagerLoginForm.fxml"));
                    break;

            }

            if (root!=null){
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();
                primaryStage.show();

//                TranslateTransition tt = new TranslateTransition(Duration.millis(350),scene.getRoot());
//                tt.setFromX(-scene.getWidth());
//                tt.setToY(0);
//                tt.play();


            }

        }




    }

    public void playMouseEnteredAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button){
            Button btn = (Button) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200),btn);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            btn.setEffect(glow);

        }

    }

    public void playMouseExitedAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button){

            Button btn = (Button) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200),btn);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            btn.setEffect(null);
        }
    }
}
