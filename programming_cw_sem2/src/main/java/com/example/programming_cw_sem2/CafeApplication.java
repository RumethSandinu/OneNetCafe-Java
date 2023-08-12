package com.example.programming_cw_sem2;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class CafeApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Loading the Preloading-ui.fxml
        Parent preloadingRoot = FXMLLoader.load(getClass().getResource("Preloading-ui.fxml"));
        //Creating a new scene
        Scene preloadingScene = new Scene(preloadingRoot);
        //Making the scene transparent
        preloadingScene.setFill(Color.TRANSPARENT);
        //Creating a new stage
        Stage preloadingStage = new Stage();
        //Making the stage transparent
        preloadingStage.initStyle(StageStyle.TRANSPARENT);
        //Setting the stage size constant
        preloadingStage.setResizable(false);
        //Setting the scene to the stage
        preloadingStage.setScene(preloadingScene);
        //Showing the stage
        preloadingStage.show();
        //Looking up for the progressBar and animating it
        ProgressBar progressBar = (ProgressBar) preloadingRoot.lookup("#progressBar");
        KeyValue keyValue = new KeyValue(progressBar.progressProperty(), 1.0);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        timeline.setOnFinished(e -> {
            //closing the stage
            preloadingStage.close();
            try {
                //Loading the console-menu-ui.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("console-menu-ui.fxml"));
                Parent consoleMenuRoot = loader.load();
                //Creating a new scene
                Scene consoleMenuScene = new Scene(consoleMenuRoot);
                //Creating a new stage
                Stage consoleMenuStage = new Stage();
                //Setting the scene to the stage
                consoleMenuStage.setScene(consoleMenuScene);
                //Making the stage size constant
                consoleMenuStage.setResizable(false);
                //Showing the stage
                consoleMenuStage.show();
                System.out.println("\u001B[35mSystem --> console-menu-ui\u001B[39m");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        timeline.play();
    }
    // Method to enable dragging for a stage
    public static void main(String[] args) {
        launch(args);
    }
}
