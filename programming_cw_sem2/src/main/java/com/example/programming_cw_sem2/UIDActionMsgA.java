package com.example.programming_cw_sem2;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.IOException;

public class UIDActionMsgA extends DIDActionMsg{
    @Override
    public void actionMessageView(ActionEvent event) throws Exception {
        //Capturing the previous stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //Loading the success.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Success.fxml"));
        Parent root = fxmlLoader.load();
        CafeController successController = fxmlLoader.getController();
        System.out.println("\u001B[31mItem details deleted from the file\u001B[39m");
        successController.actionMessage.setText("Item details deleted from the file");
        Pane actionMessagePane = (Pane) fxmlLoader.getNamespace().get("actionMessagePane");
        actionMessagePane.setStyle("-fx-background-color: rgb(230, 77, 50)");
        //Creating a new stage
        Stage successStage = new Stage();
        //Making the stage trasparent
        successStage.initStyle(StageStyle.TRANSPARENT);
        //Creating a new scene
        Scene scene = new Scene(root);
        //Making the scene transparent
        scene.setFill(Color.TRANSPARENT);
        //Make the stage size constant
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
                Parent previousRoot = FXMLLoader.load(getClass().getResource("UID-ui-2.fxml"));
                stage.setResizable(false);
                stage.setScene(new Scene(previousRoot, 800, 600));
                System.out.println("\u001B[35mSystem --> UID-ui-2\u001B[39m");
                //Capturing the input fields and setting them values referenced to the user entered Item Code
                TextField itemCodeTextField = (TextField) previousRoot.lookup("#ItemCodeTextField");
                itemCodeTextField.setText("Item Code : " + Validator.getItemCode());
                itemCodeTextField.setDisable(true);
                TextField itemNameTextField = (TextField) previousRoot.lookup("#ItemNameTextField");
                itemNameTextField.setText(Validator.getItemName());
                TextField itemBrandTextField = (TextField) previousRoot.lookup("#ItemBrandTextField");
                itemBrandTextField.setText(Validator.getItemBrand());
                TextField itemPriceTextField = (TextField) previousRoot.lookup("#ItemPriceTextField");
                itemPriceTextField.setText(Validator.getItemPrice());
                TextField itemQuantityTextField = (TextField) previousRoot.lookup("#ItemQuantityTextField");
                itemQuantityTextField.setText(Validator.getItemQuantity());
                TextField itemCategoryTextField = (TextField) previousRoot.lookup("#ItemCategoryTextField");
                itemCategoryTextField.setText(Validator.getItemCategory());
                TextField itemPurchaseYearTextField = (TextField) previousRoot.lookup("#ItemPurchaseYearTextField");
                itemPurchaseYearTextField.setText(Validator.getItemPurchaseYear());
                TextField itemPurchaseMonthTextField = (TextField) previousRoot.lookup("#ItemPurchaseMonthTextField");
                itemPurchaseMonthTextField.setText(Validator.getItemPurchaseDay());
                TextField itemPurchaseDayTextField = (TextField) previousRoot.lookup("#ItemPurchaseDayTextField");
                itemPurchaseDayTextField.setText(Validator.getItemPurchaseDay());
                try {
                    //Showing the image in the image view
                    String imagePath = Validator.getItemImagePath().strip();
                    if (imagePath != null && !imagePath.isEmpty()) {
                        FileInputStream imageStream = new FileInputStream(imagePath);
                        Image image = new Image(imageStream);
                        //Looking for image view area
                        ImageView itemImagePath = (ImageView) previousRoot.lookup("#ImageViewArea");
                        if (itemImagePath != null) {
                            itemImagePath.setImage(image);
                        } else {
                            System.out.println("\u001B[31mImageViewArea not found\u001B[39m");
                        }
                    } else {
                        System.out.println("\u001B[31mImage path is empty or null\u001B[39m");
                    }
                } catch (Exception e) {
                    System.out.println("\u001B[31mError loading the image\u001B[39m");
                }
            } catch (Exception ex) {
                System.out.println("\u001B[31mAn error occurred while loading UID-ui-2.fxml\u001B[39m");
            }
        });
        delay.play();
    }
}

