package com.example.programming_cw_sem2;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;

public class DIDActionMsg extends SuccessfullActionMsg {
    @Override
    public void actionMessageView(ActionEvent event)throws Exception{
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Success.fxml"));
        Parent root = fxmlLoader.load();
        CafeController successController = fxmlLoader.getController();
        System.out.println("\u001B[31mItem details deleted from the file\u001B[39m");
        successController.actionMessage.setText("Item details deleted from the file");
        Pane actionMessagePane = (Pane) fxmlLoader.getNamespace().get("actionMessagePane");
        actionMessagePane.setStyle("-fx-background-color: rgb(230, 77, 50)");
        Stage successStage = new Stage();
        successStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        currentStage.setResizable(false);
        successStage.setScene(scene);
        double successStageX = currentStage.getX();
        double successStageY = currentStage.getY() + 600;
        successStage.setX(successStageX);
        successStage.setY(successStageY);
        successStage.show();
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(e -> {
            successStage.close();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                Parent previousRoot = FXMLLoader.load(getClass().getResource("console-menu-ui.fxml"));
                stage.setResizable(false);
                stage.setScene(new Scene(previousRoot, 800, 600));
                System.out.println("\u001B[35mSystem --> console-menu-ui\u001B[39m");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        delay.play();
    }
}
