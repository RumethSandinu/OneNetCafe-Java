package com.example.programming_cw_sem2;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class SuccessfullActionMsg {
    public void actionMessageView(ActionEvent event)throws Exception{
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Success.fxml"));
        Parent root = fxmlLoader.load();
        Stage successStage = new Stage();
        //Transparent stage
        successStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        //Transparent scene
        scene.setFill(Color.TRANSPARENT);
        //Setting the stage not to resize
        currentStage.setResizable(false);
        successStage.setScene(scene);
        double successStageX = currentStage.getX();
        double successStageY = currentStage.getY() + 600;
        successStage.setX(successStageX);
        successStage.setY(successStageY);
        successStage.show();
        //After 3 seconds closing the stage and open console-menu-ui in a new stage
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(e -> {
            successStage.close();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                Parent previousRoot = FXMLLoader.load(getClass().getResource("console-menu-ui.fxml"));
                stage.setResizable(false);
                stage.setScene(new Scene(previousRoot, 800, 600));
                System.out.println("\u001B[35mSystem --> console-menu-ui\u001B[39m");
            } catch (Exception ex) {
                System.out.println("\u001B[31mAn error occurred while loading console-menu-ui.fxml\u001B[39m");
            }
        });
        delay.play();
    }
}
