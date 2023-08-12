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

public class UIDActionMsgB extends UIDActionMsgA{
    @Override
    public void actionMessageView(ActionEvent event)throws Exception{
        //Capturing the previous stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //Loading the success.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Success.fxml"));
        Parent root = fxmlLoader.load();
        //Creating a new stage
        Stage successStage = new Stage();
        //Making the stage transparent
        successStage.initStyle(StageStyle.TRANSPARENT);
        //Creating a new scene
        Scene scene = new Scene(root);
        //Making the scene transparent
        scene.setFill(Color.TRANSPARENT);
        //Making the stage size constant
        currentStage.setResizable(false);
        //Setting the scene to the stage
        successStage.setScene(scene);
        double successStageX = currentStage.getX();
        double successStageY = currentStage.getY() + 600;
        successStage.setX(successStageX);
        successStage.setY(successStageY);
        //Showing the stage
        successStage.show();
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(ey -> {
            //Closing the stage
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
