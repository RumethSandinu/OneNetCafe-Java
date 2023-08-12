package com.example.programming_cw_sem2;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileWriter;
import javafx.util.Duration;
import java.io.IOException;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


import static com.example.programming_cw_sem2.Validator.itemRecord;
import static com.example.programming_cw_sem2.Validator.dealerRecord;
import static com.example.programming_cw_sem2.Validator.dealersArray;
import static com.example.programming_cw_sem2.Validator.selectedDealers;
import static com.example.programming_cw_sem2.Validator.itemsFile;
import static com.example.programming_cw_sem2.Validator.dealersFile;
import static com.example.programming_cw_sem2.Validator.tempItemsFile;

public class CafeController{
    //Creating variable for fxml components and linking them to fxml
    @FXML
    private Button submitButton;
    @FXML
    private Button resetButton;
    @FXML
    private TextField ItemCodeTextField;
    @FXML
    private TextField ItemNameTextField;
    @FXML
    private TextField ItemBrandTextField;
    @FXML
    private TextField ItemPriceTextField;
    @FXML
    private TextField ItemQuantityTextField;
    @FXML
    private TextField ItemCategoryTextField;
    @FXML
    private TextField ItemPurchaseYearTextField;
    @FXML
    private TextField ItemPurchaseMonthTextField;
    @FXML
    private TextField ItemPurchaseDayTextField;
    @FXML
    private ImageView ImageViewArea;
    @FXML
    private Pane ImagePane;
    @FXML
    private TextField VRLDealerIDTextField;
    @FXML
    public Text actionMessage;
    @FXML
    public Pane actionMessagePane;

    //When exit is clicked button program will load Preloading-ui.fxml and terminate the program
    @FXML
    public void onClickExitButton(ActionEvent e) {
        try {
            //Capturing the previous stage
            Stage previousStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            //Closing the previous stage
            previousStage.close();
            //Loading the Preloading-ui.fxml
            Parent preloadingRoot = FXMLLoader.load(getClass().getResource("Preloading-ui.fxml"));
            //Creating a new stage
            Stage preloadingStage = new Stage();
            //Making the stage transparent
            preloadingStage.initStyle(StageStyle.TRANSPARENT);
            //Creating a new scene
            Scene preloadingScene = new Scene(preloadingRoot);
            //Making the scene transparent
            preloadingScene.setFill(Color.TRANSPARENT);
            //Setting the stage size constant
            preloadingStage.setResizable(false);
            preloadingStage.setScene(preloadingScene);
            //Showing the stage
            preloadingStage.show();
            //Looking up for the progressBar and animating it
            ProgressBar progressBar = (ProgressBar) preloadingRoot.lookup("#progressBar");
            progressBar.setProgress(1.0);
            KeyValue keyValue = new KeyValue(progressBar.progressProperty(), 0.0);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);
            Timeline timeline = new Timeline(keyFrame);
            timeline.setOnFinished(event -> {
                //Closing the stage
                preloadingStage.close();
                System.out.println("\u001B[35mSystem --> exit\u001B[39m");
                //Exit the system
                System.exit(0);
            });
            timeline.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    //When console button is clicked program will load the console-menu-ui
    @FXML
    public void onClickConsoleButton(ActionEvent e) throws Exception {
        //Capturing the previous stage
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //Loading the console-menu-ui.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("console-menu-ui.fxml"));
        stage.setScene(new Scene(root, 800, 600));
        System.out.println("\u001B[35mSystem --> console-menu-ui\u001B[39m");
    }

    //When user enter something in any of text field program will setting up the text feild border to black and enabling the reset button submit button
    @FXML
    public void onItemCodeTextFieldChange() {
        ItemCodeTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    @FXML
    public void onItemNameTextFieldChange() {
        ItemNameTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    @FXML
    public void onItemBrandTextFieldChange() {
        ItemBrandTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    @FXML
    public void onItemPriceTextFieldChange() {
        ItemPriceTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    @FXML
    public void onItemQuantityTextFieldChange() {
        ItemQuantityTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    @FXML
    public void onItemCategoryTextFieldChange() {
        ItemCategoryTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    @FXML
    public void onItemPurchaseYearTextFieldChange() {
        ItemPurchaseYearTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    @FXML
    public void onItemPurchaseMonthTextFieldChange() {
        ItemPurchaseMonthTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    @FXML
    public void onItemPurchaseDayTextFieldChange() {
        ItemPurchaseDayTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    @FXML
    public void onVRLDealerIDTextChange() {
        VRLDealerIDTextField.setStyle("-fx-border-color: black;");
        submitButton.setDisable(false);
        resetButton.setDisable(false);
    }

    //When AID button or resert button inside AID-ui,is clicked program will load the AID-ui.fxml and give opportutity for user to add data
    @FXML
    public void onClickAIDButton(ActionEvent e) throws Exception {
        //Capturing the previous stage
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //Loading the AID-ui.fxml
        Parent root = FXMLLoader.load(getClass().getResource("AID-ui.fxml"));
        stage.setScene(new Scene(root, 800, 600));
        //Making the image is not validated yet
        Validator.setImageValidationCheck(false);
        System.out.println("\u001B[35mSystem --> AID-ui\u001B[39m");
    }

    //When Image adding button is clicked program will ask to enter a file and the image will be displayed in the AID-ui if it is valid image
    @FXML
    private void onClickAddImageButton() {
        System.out.println("\u001B[34m_____Action add Item Image started_____ \u001B[39m");
        //Setting the image is not validated yet
        Validator.setImageValidationCheck(false);
        try {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            if (selectedFile != null) {
                System.out.println("\u001B[32mItem Image accepted\u001B[39m");
                //Printing the selected file path
                System.out.println("Selected File: " + selectedFile.getAbsolutePath());
                //Validating the image path using regex
                String regex = ".*\\.(?i)(png|jpe?g|jpg|bmp|gif|tiff|svg)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(selectedFile.getAbsolutePath());
                //If the image path is valid
                if (matcher.matches()) {
                    //Setting the image is valid
                    Validator.setImageValidationCheck(true);
                    //Inserting the image path to itemRecord array
                    itemRecord[9] = selectedFile.getAbsolutePath().strip();
                    //Enabling the submit and reset buttons
                    submitButton.setDisable(false);
                    resetButton.setDisable(false);
                    //Setting the image pane border
                    ImagePane.setStyle("-fx-border-color: black;");
                    try {
                        //Showing the image in the image view in the image pane
                        Image image = new Image(selectedFile.toURI().toString());
                        ImageViewArea.setImage(image);
                    } catch (Exception e) {
                        System.out.println("\u001B[31mError loading image: \u001B[39m" + e.getMessage());
                    }

                } //If image is invalid
                else {
                    //Setting the image pane border
                    ImagePane.setStyle("-fx-border-color: rgb(230, 77, 50);");
                    System.out.println("\u001B[31mItem Image declined\u001B[39m");
                    System.out.println("\u001B[31mInvalid image file selected\u001B[39m");
                }
            } else {
                System.out.println("\u001B[31mFile selection canceled\u001B[39m");
            }
        } catch (Exception e) {
            System.out.println("\u001B[31mError occurred while selecting the file: \u001B[39m" + e.getMessage());
        }
        System.out.println("\u001B[34m_____Action add Item Image finished_____ \u001B[39m");
    }

    //When AID submit button is clicked the program will check if the data valid.If all of them are valid then the program will save the data in Items.txt text file
    @FXML
    public void onClickAIDSubmitButton(ActionEvent event) {
        System.out.println("\u001B[34m_____Action add Item Details started_____ \u001B[39m");
        //Sending the values of text fields to the constructor of Validator class
        Validator aidValidationObj = new Validator(ItemCodeTextField.getText(), ItemNameTextField.getText(), ItemBrandTextField.getText(), ItemPriceTextField.getText(), ItemQuantityTextField.getText(), ItemCategoryTextField.getText(), ItemPurchaseYearTextField.getText(), ItemPurchaseMonthTextField.getText(), ItemPurchaseDayTextField.getText());
        //Setting the user entered item code does not exist
        aidValidationObj.setItemCodeMatch(false);
        //Validating the item code
        aidValidationObj.itemCodeValidate();
        //If item code is valid
        if (aidValidationObj.getValidationCheck()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(itemsFile))) {
                String line;
                //Reading the file line by line
                while ((line = bufferedReader.readLine()) != null) {
                    // Decrypting the line
                    try {
                        String decryptedLine = Encryption.decryptData(line);
                        //Spliting the decrypted line and getting it to an array
                        String[] itemRecord = decryptedLine.split(",");
                        //If user entered item code exists
                        if(itemRecord[0].equals(ItemCodeTextField.getText())){
                            //Setting the item code exist
                            aidValidationObj.setItemCodeMatch(true);
                            //Breaking the while loop
                            break;
                        }
                    } catch (Exception ex) {
                        System.out.println("Failed to decrypt line: " + line);
                    }
                }
            } catch (Exception ex) {
                System.out.println("File doesnt exists");
            }
            //Checking if the data valid.If not progam will set the privous prompt text in red color and setting the text field border in red color
            //If item code exists
            if (aidValidationObj.getItemCodeMatch()) {
                System.out.println("\u001B[31mItem Code exists\u001B[39m");
                //Setting the text field
                ItemCodeTextField.clear();
                ItemCodeTextField.setPromptText("Item Code");
                ItemCodeTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                //Disable the submiot button
                submitButton.setDisable(true);
            } //If item code does not exist
            else {
                System.out.println("\u001B[32mItem Code accepted \u001B[39m");
                //Increase validate points
                aidValidationObj.setValidatepoints(aidValidationObj.getValidatepoints() + 1);
                //Passing the item code to itemRecord array
                itemRecord[0] = Validator.getItemCode();
            }
        }//If item code is invalid
        else {
            System.out.println("\u001B[31mItem Code declined\u001B[39m");
            //Setting the item code text field
            ItemCodeTextField.clear();
            ItemCodeTextField.setPromptText("Item Code");
            ItemCodeTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item name
        aidValidationObj.itemNameValidate();
        //If the item name is valid
        if (aidValidationObj.getValidationCheck()) {
            System.out.println("\u001B[32mItem Name accepted \u001B[39m");
            //Increase the validate points
            aidValidationObj.setValidatepoints(aidValidationObj.getValidatepoints() + 1);
            //Passing the item name to itemRecord array
            itemRecord[1] = Validator.getItemName();
        }//If the item name is invalid
        else {
            System.out.println("\u001B[31mItem Name declined\u001B[39m");
            //Setting the item name field
            ItemNameTextField.clear();
            ItemNameTextField.setPromptText("Item Name");
            ItemNameTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item brand
        aidValidationObj.itemBrandValidate();
        //If the item brand is valid
        if (aidValidationObj.getValidationCheck()) {
            System.out.println("\u001B[32mItem Brand accepted \u001B[39m");
            //Increase the validate points
            aidValidationObj.setValidatepoints(aidValidationObj.getValidatepoints() + 1);
            //Passing the item brand to the itemRecord array
            itemRecord[2] = Validator.getItemBrand();
        } //If the item brand is invalid
        else {
            System.out.println("\u001B[31mItem Brand declined\u001B[39m");
            //Setting the item brand text field
            ItemBrandTextField.clear();
            ItemBrandTextField.setPromptText("Item Brand");
            ItemBrandTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item price
        aidValidationObj.itemPriceValidate();
        //If the item price is valid
        if (aidValidationObj.getValidationCheck()) {
            System.out.println("\u001B[32mItem Price accepted \u001B[39m");
            //Increase the validate points
            aidValidationObj.setValidatepoints(aidValidationObj.getValidatepoints() + 1);
            //Passing the item price to the itemRecord array
            itemRecord[3] = Validator.getItemPrice();
        }//If the item price is invalid
        else {
            System.out.println("\u001B[31mItem Price declined\u001B[39m");
            //Setting the item price text field
            ItemPriceTextField.clear();
            ItemPriceTextField.setPromptText("Enter the Item Price");
            ItemPriceTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item quantity
        aidValidationObj.itemQuantityValidate();
        //If the item quantity is valid
        if (aidValidationObj.getValidationCheck()) {
            System.out.println("\u001B[32mItem Quantity accepted\u001B[39m");
            //Increase the validate points
            aidValidationObj.setValidatepoints(aidValidationObj.getValidatepoints() + 1);
            //Passing the item quantity to the itemRecord array
            itemRecord[4] = Validator.getItemQuantity();
        } //If the item quantity is invalid
        else {
            System.out.println("\u001B[31mItem Quantity declined\u001B[39m");
            //Setting the item quantity text field
            ItemQuantityTextField.clear();
            ItemQuantityTextField.setPromptText("Enter the Item Quantity");
            ItemQuantityTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item category
        aidValidationObj.itemCategoryValidate();
        //If the item category is valid
        if (aidValidationObj.getValidationCheck()) {
            System.out.println("\u001B[32mItem Category accepted \u001B[39m");
            //Increase the validate points
            aidValidationObj.setValidatepoints(aidValidationObj.getValidatepoints() + 1);
            //Passing the item Category to the itemRecord array
            itemRecord[5] = Validator.getItemCategory();
        } //If the item category is invalid
        else {
            System.out.println("\u001B[31mItem Category declined\u001B[39m");
            //Setting the item category text field
            ItemCategoryTextField.clear();
            ItemCategoryTextField.setPromptText("Enter the Item Category");
            ItemCategoryTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item purchase date
        aidValidationObj.itemPurchaseDateValidate();
        //If the item purchase year is valid
        if (aidValidationObj.getValidationCheckYear()) {
            System.out.println("\u001B[32mItem Purchase Year accepted \u001B[39m");
            //Increase validate points
            aidValidationObj.setValidatepoints(aidValidationObj.getValidatepoints() + 1);
            //Passig the item purchase year value to the itemRecord array
            itemRecord[6] = Validator.getItemPurchaseYear();
            //If the item purchase month is valid
            if (aidValidationObj.getValidationCheckMonth()) {
                System.out.println("\u001B[32mItem Purchase Month accepted \u001B[39m");
                //Increase validate points
                aidValidationObj.setValidatepoints(aidValidationObj.getValidatepoints() + 1);
                //PAssing the item purchase month to the itemRecord array
                itemRecord[7] = Validator.getItemPurchaseMonth();
                //If the item purchase day is valid
                if (aidValidationObj.getValidationCheckMonth()) {
                    System.out.println("\u001B[32mItem Purchase Day accepted \u001B[39m");
                    //Increase validate points
                    aidValidationObj.setValidatepoints(aidValidationObj.getValidatepoints() + 1);
                    //Passing the item purchase day to the itemRecord array
                    itemRecord[8] = Validator.getItemPurchaseDay();
                } //If the item purchase day is invalid
                else {
                    System.out.println("\u001B[31mItem Purchase Day declined\u001B[39m");
                    //Setting the item purchase day text field
                    ItemPurchaseDayTextField.clear();
                    ItemPurchaseDayTextField.setPromptText("Day");
                    ItemPurchaseDayTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                    //Disable the submit button
                    submitButton.setDisable(true);
                }
            }//If the item purchase month is valid
            else {
                System.out.println("\u001B[31mItem Purchase Month declined\u001B[39m");
                //Setting the item purchase month text field
                ItemPurchaseMonthTextField.clear();
                ItemPurchaseMonthTextField.setPromptText("Month");
                ItemPurchaseMonthTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                System.out.println("\u001B[31mItem Purchase Day declined\u001B[39m");
                //Setting the item purchase day text field
                ItemPurchaseDayTextField.clear();
                ItemPurchaseDayTextField.setPromptText("Day");
                ItemPurchaseDayTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                //Disable the submit button
                submitButton.setDisable(true);
            }
        }//If the item purchase year is invalid
        else {
            System.out.println("\u001B[31mItem Purchase Year declined\u001B[39m");
            //Setting the item purchase year text field
            ItemPurchaseYearTextField.clear();
            ItemPurchaseYearTextField.setPromptText("Year");
            ItemPurchaseYearTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            System.out.println("\u001B[31mItem Purchase Month declined\u001B[39m");
            //Setting the item purchase month text field
            ItemPurchaseMonthTextField.clear();
            ItemPurchaseMonthTextField.setPromptText("Month");
            ItemPurchaseMonthTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            System.out.println("\u001B[31mItem Purchase Day declined\u001B[39m");
            //Setting the item purchase day text field
            ItemPurchaseDayTextField.clear();
            ItemPurchaseDayTextField.setPromptText("Day");
            ItemPurchaseDayTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //If the image is not valid
        if (!Validator.getImageValidationCheck()) {
            //Setting the image pane border
            ImagePane.setStyle("-fx-border-color: rgb(230, 77, 50);");
            System.out.println("\u001B[31mItem Image declined\u001B[39m");
        }
        //If the image is valid and validate poits are equal to 9
        if (aidValidationObj.getValidatepoints() == 9 && Validator.getImageValidationCheck()) {
            try {
                //Getting the array data to a string
                String data = String.valueOf(itemRecord[0] + "," + itemRecord[1] + "," + itemRecord[2] + "," + itemRecord[3] + "," + itemRecord[4] + "," + itemRecord[5] + "," + itemRecord[6] + "," + itemRecord[7] + "," + itemRecord[8] + "," + itemRecord[9] + "\n");
                //Encrypt the string
                String encryptedData = Encryption.encryptData(data);
                try {
                    //Open the text file
                    File file = new File(itemsFile);
                    //Set the file read and write
                    file.setWritable(true);
                }catch (Exception e){
                    System.out.println("\u001B[31File not found\u001B[39");
                }
                //Append the data to the file without overwriting existing content
                try (FileWriter fileWriter = new FileWriter(itemsFile, true);
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    //Write the data in to the file
                    bufferedWriter.write(encryptedData);
                    //Next line
                    bufferedWriter.write("\n");
                    System.out.println("\u001B[32mData successfully written to the file\u001B[39m");
                } catch (Exception ex) {
                    System.out.println("\u001B[32mAn error occurred while writing to the file\u001B[39m");
                }
                File file = new File(itemsFile);
                file.setReadOnly();
                System.out.println("\u001B[32mItems.txt updated successfully\u001B[39m");
                //Displaying the successfull message
                SuccessfullActionMsg successMsgObj = new SuccessfullActionMsg();
                successMsgObj.actionMessageView(event);
            } catch (Exception e) {
                System.out.println("\u001B[31mAn error occurred while encrypting the data\u001B[32m");
            }
        }//If the image is invalid or validate poits are not equal to 9
        else {
            System.out.println("\u001B[31mSome input is declined\u001B[32m");
        }
        System.out.println("\u001B[34m_____Action add Item Details finished_____ \u001B[39m");
    }

    //If item DID button is trigerred this function will help user to view available item codes for deletation in Items.txt
    @FXML
    public void onClickDIDButton(ActionEvent e) throws Exception {
        System.out.println("\u001B[34m_____Action delete Item Details started_____ \u001B[39m");
        //Capturing the previous stage
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //Loading the DID-ui.fxml
        Parent root = FXMLLoader.load(getClass().getResource("DID-ui.fxml"));
        //Capturing the DIDTableView in DID-ui.fxml
        TableView<Update> DIDTableView = (TableView<Update>) root.lookup("#DIDTableView");
        //Capturing the columns in the table
        TableColumn<Update, String> itemCodeColumn = (TableColumn<Update, String>) DIDTableView.getColumns().get(0);
        TableColumn<Update, String> itemNameColumn = (TableColumn<Update, String>) DIDTableView.getColumns().get(1);
        //Creating an observable array list
        ObservableList<Update> itemData = FXCollections.observableArrayList();
        //Open the text file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(itemsFile))) {
            String line;
            //Reading the text file line by line
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    //Decrypting line
                    String decryptedLine = Encryption.decryptData(line);
                    //Spliting the lina and get it to an array
                    String[] itemRecord = decryptedLine.split(",");
                    Update item = new Update(itemRecord[0], itemRecord[1]);
                    //Adding the values to the observable array list
                    itemData.add(item);
                    //sorting the item code assending order using bubble sort
                    int n = itemData.size();
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            int itemCode1 = Integer.parseInt(itemData.get(j).getItemCode());
                            int itemCode2 = Integer.parseInt(itemData.get(j + 1).getItemCode());
                            if (itemCode1 > itemCode2) {
                                //Swapping
                                Update temp = itemData.get(j);
                                itemData.set(j, itemData.get(j + 1));
                                itemData.set(j + 1, temp);
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("\u001B[31mFailed to decrypt line: \u001B[39m" + line);
                }
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mAn error occurred while reading the file.\u001B[39m");
        }
        //Setting the cell value factories
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        //Setting the table data
        DIDTableView.setItems(itemData);
        Scene scene = new Scene(root, 800, 600);
        //Setting the scene to the stage
        stage.setScene(scene);
        //Showing the stage
        stage.show();
        System.out.println("\u001B[35mSystem --> DID-ui\u001B[39m");
    }


    //When submit button in DID function is trigerred this function will validate the user entered ItemCode,It will help user to delete the spesific record from the Items.txt if ItemCode is available to delete
    @FXML
    public void onClickDIDSubmitButton(ActionEvent event) throws Exception {
        System.out.println("\u001B[34m_____Action delete Item Details started_____ \u001B[39m");
        //Passing the item code to the Validator to validate
        Validator didValidation = new Validator(ItemCodeTextField.getText());
        //Setting the item code does not exist
        didValidation.setItemCodeMatch(false);
        //Validating the item code
        didValidation.itemCodeValidate();
        //If item code is valid
        if (didValidation.getValidationCheck()) {
            //Open the text file
            try (FileReader fileReader = new FileReader(itemsFile);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);
                 //Create a temparory file
                 FileWriter fileWriter = new FileWriter(tempItemsFile);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                System.out.println("\u001B[32mItems.txt successfully loaded\u001B[39m");
                String line;
                //Read the file line by line
                while ((line = bufferedReader.readLine()) != null) {
                    try {
                        //Decrypt the line
                        String decryptedLine = Encryption.decryptData(line);
                        //Splitting the line and getting it to and array
                        String[] itemArray = decryptedLine.split(",");
                        //If the item code exists
                        if (itemArray[0].equals(Validator.getItemCode())) {
                            //Setting the item code exists
                            didValidation.setItemCodeMatch(true);
                        } //If the item code does not exist
                        else {
                            bufferedWriter.write(line);
                            bufferedWriter.write("\n");
                        }
                    } catch (Exception ex) {
                        System.out.println("\u001B[31mFailed to decrypt line: \u001B[39m" + line);
                        ex.printStackTrace();
                    }
                }
                bufferedReader.close();
                bufferedWriter.close();
                //If the item code exists
                if (didValidation.getItemCodeMatch()) {
                    File originalFile = new File(itemsFile);
                    //Delete the original file
                    if (originalFile.delete()) {
                        File tempFile = new File(tempItemsFile);
                        //Rename the temparory file as original file
                        if (tempFile.renameTo(originalFile)) {
                            File file = new File(itemsFile);
                            //Set the file read only
                            file.setReadOnly();
                            System.out.println(" \u001B[32mItem details deleted successfully\u001B[39m");
                            //Displaying the successfull meassage
                            SuccessfullActionMsg successMsgObj = new DIDActionMsg();
                            successMsgObj.actionMessageView(event);
                        } else {
                            System.out.println("\u001B[31mAn error occurred while deleting the file\u001B[39m");
                        }
                    } else {
                        System.out.println("\u001B[31mFailed to delete original file\u001B[39m");
                    }
                } //If the item code does not exist
                else {
                    System.out.println("\u001B[31mItem code not found in the file\u001B[39m");
                    //Setting the item code text fiels
                    ItemCodeTextField.clear();
                    ItemCodeTextField.setPromptText("Item Code");
                    ItemCodeTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                }
            } catch (Exception e) {
                System.out.println("\u001B[31mAn error occurred while reading the file\u001B[39m");
            }
        }//If item code is valid
        else {
            System.out.println("\u001B[31mItem code must be an integer value\u001B[39m");
            //Setting the item code text field
            ItemCodeTextField.clear();
            ItemCodeTextField.setPromptText("Item Code");
            ItemCodeTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
        }
        System.out.println("\u001B[34m_____Action delete Item Details finished_____ \u001B[39m");
    }

    //If item UID button is trigerred this function will help user to view available item codes for updating in Items.txt
    @FXML
    public void onClickUIDButton(ActionEvent e) throws Exception {
        //Setting the image is not validated yet
        Validator.setImageValidationCheck(false);
        //Capturin the previous stage
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //Loading the UID-ui-1.fxml
        Parent root = FXMLLoader.load(getClass().getResource("UID-ui-1.fxml"));
        // Capturing the table and columns
        TableView<Update> UIDTableView = (TableView<Update>) root.lookup("#UIDTableView");
        TableColumn<Update, String> itemCodeColumn = (TableColumn<Update, String>) UIDTableView.getColumns().get(0);
        TableColumn<Update, String> itemNameColumn = (TableColumn<Update, String>) UIDTableView.getColumns().get(1);
        //Creating an observable list
        ObservableList<Update> itemData = FXCollections.observableArrayList();
        //Open the text file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(itemsFile))) {
            String line;
            //Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Decrypting the line
                String decryptedLine = Encryption.decryptData(line);
                // Spliting the decrypted line and get it to an array
                String[] itemRecord = decryptedLine.split(",");
                    Update item = new Update(itemRecord[0], itemRecord[1]);
                    //Ading the array to the observable array list
                    itemData.add(item);
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mAn error occurred while reading the file\u001B[39m");
        }
        //Setting the cell value factories
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        //sorting the item code assending order using bubble sort
        int n = itemData.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int itemCode1 = Integer.parseInt(itemData.get(j).getItemCode());
                int itemCode2 = Integer.parseInt(itemData.get(j + 1).getItemCode());
                if (itemCode1 > itemCode2) {
                    //Swapping
                    Update temp = itemData.get(j);
                    itemData.set(j, itemData.get(j + 1));
                    itemData.set(j + 1, temp);
                }
            }
        }
        // Setting the data in the table
        UIDTableView.setItems(itemData);
        stage.setScene(new Scene(root, 800, 600));
        System.out.println("\u001B[35mSystem --> UID-ui-1\u001B[39m");
    }

    //When user enter a ItemCode to delete and entered the submit button this function will check wheather the ItemCode is available in the Items.txt and validate the code
    //This function is same as DID
    @FXML
    public void onClickUIDSubmitButtonA(ActionEvent event) throws Exception {
        System.out.println("\u001B[34m_____Action update Item Details started_____\u001B[39m");
        //Passing the item code to Validator to validate
        Validator uidValidationObj = new Validator(ItemCodeTextField.getText());
        //Validate the item code
        uidValidationObj.itemCodeValidate();
        //Setting the item code does not exist
        uidValidationObj.setItemCodeMatch(false);
        //If the item code is valid
        if (uidValidationObj.getValidationCheck()) {
            //Open the text file
            try (FileReader fileReader = new FileReader(itemsFile);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);
                 //Creating a temporory file
                 FileWriter fileWriter = new FileWriter(tempItemsFile);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                System.out.println("\u001B[32mItems.txt successfully loaded\u001B[39m");
                String line;
                //Reading the original file line by line
                while ((line = bufferedReader.readLine()) != null) {
                    // Decrypting the line
                    String decryptedLine = Encryption.decryptData(line);
                    //Spliting the decrypted line and get it to an array
                    String[] itemArray = decryptedLine.split(",");
                    //If the item code exists
                    if (itemArray[0].equals(uidValidationObj.getItemCode())) {
                        //passing the item data to the Validator
                        Validator.setItemCode(itemArray[0]);
                        Validator.setItemName(itemArray[1]);
                        Validator.setItemBrand(itemArray[2]);
                        Validator.setItemPrice(itemArray[3]);
                        Validator.setItemQuantity(itemArray[4]);
                        Validator.setItemCategory(itemArray[5]);
                        Validator.setItemPurchaseYear(itemArray[6]);
                        Validator.setItemPurchaseMonth(itemArray[7]);
                        Validator.setItemPurchaseDay(itemArray[8]);
                        Validator.setItemImagePath(itemArray[9]);
                        itemRecord[9] = itemArray[9].strip();
                        //Setting the image is valid
                        Validator.setImageValidationCheck(true);
                        //Setting the item code eists
                        uidValidationObj.setItemCodeMatch(true);
                    }//If the item code exists
                    else{
                        bufferedWriter.write(line);
                        bufferedWriter.write("\n");
                    }
                }
                bufferedReader.close();
                bufferedWriter.close();
                //If item code exists
                if (uidValidationObj.getItemCodeMatch()) {
                    File originalFile = new File(itemsFile);
                    //Deleting the original file
                    if (originalFile.delete()) {
                        File tempFile = new File(tempItemsFile);
                        //Renaming the temparory file as original file
                        if (tempFile.renameTo(originalFile)) {
                            System.out.println("\u001B[32mItem record successfully deleted\u001B[39m");
                            //Displaying the successull message
                            DIDActionMsg successMsgObj = new UIDActionMsgA();
                            successMsgObj.actionMessageView(event);
                        } else {
                            System.out.println("\u001B[31mFailed to update item record\u001B[39m");
                        }
                    } else {
                        System.out.println("\u001B[31mFailed to delete original file\u001B[39m");
                    }
                }//If item code does not exist
                else {
                    // Handle cases where the item code was not found in the Items.txt file
                    submitButton.setDisable(true);
                    ItemCodeTextField.clear();
                    ItemCodeTextField.setPromptText("Item Code");
                    ItemCodeTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                    System.out.println("\u001B[31mItem code not found in the Items.txt\u001B[39m");
                }
            } catch (Exception ex) {
                System.out.println("\u001B[31mAn error occurred while reading\u001B[39m");
            }
        } //If the item code is valid
        else {
            System.out.println("\u001B[31mInvalid item code\u001B[39m");
            //Setting the item code text field
            ItemCodeTextField.clear();
            ItemCodeTextField.setPromptText("Item Code");
            ItemCodeTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
    }

    //This fucntion is same as AID
    @FXML
    public void onClickUIDSubmitButtonB(ActionEvent event) throws Exception {
        //Passing the values to the Validator to validate
        Validator uidValidaitionObjB = new Validator(ItemNameTextField.getText(), ItemBrandTextField.getText(),ItemPriceTextField.getText(), ItemQuantityTextField.getText(), ItemCategoryTextField.getText(),ItemPurchaseYearTextField.getText(), ItemPurchaseMonthTextField.getText(), ItemPurchaseDayTextField.getText());
        //Increasing the validate points
        uidValidaitionObjB.setValidatepoints(uidValidaitionObjB.getValidatepoints() + 1);
        //Get item code to itemRecord array
        itemRecord[0] = Validator.getItemCode();
        //Validate item name
        uidValidaitionObjB.itemNameValidate();
        //If the item name is valid
        if (uidValidaitionObjB.getValidationCheck()) {
            System.out.println("\u001B[32mItem Name accepted \u001B[39m");
            //Increasing validate points
            uidValidaitionObjB.setValidatepoints(uidValidaitionObjB.getValidatepoints() + 1);
            //Getting item name to itemRecord array
            itemRecord[1] = Validator.getItemName();
        }//If the item name is invalid
        else {
            System.out.println("\u001B[31mItem Name declined\u001B[39m");
            //Setting the item name text field
            ItemNameTextField.clear();
            ItemNameTextField.setPromptText("Item Name");
            ItemNameTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item brand
        uidValidaitionObjB.itemBrandValidate();
        //If the item brand is valid
        if (uidValidaitionObjB.getValidationCheck()) {
            System.out.println("\u001B[32mItem Brand accepted \u001B[39m");
            //Increasing validate points
            uidValidaitionObjB.setValidatepoints(uidValidaitionObjB.getValidatepoints() + 1);
            //Passing item brand to itemRecord array
            itemRecord[2] = Validator.getItemBrand();
        }//If the item brand is invalid
        else {
            System.out.println("\u001B[31mItem Brand declined\u001B[39m");
            //Setting the item brand text field
            ItemBrandTextField.clear();
            ItemBrandTextField.setPromptText("Item Brand");
            ItemBrandTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item price
        uidValidaitionObjB.itemPriceValidate();
        //If the item price is valid
        if (uidValidaitionObjB.getValidationCheck()) {
            System.out.println("\u001B[32mItem Price accepted \u001B[39m");
            //Increase the validate points
            uidValidaitionObjB.setValidatepoints(uidValidaitionObjB.getValidatepoints() + 1);
            //Passing the item pice to itemRecord array
            itemRecord[3] = Validator.getItemPrice();
        }//If the item price is invalid
        else {
            System.out.println("\u001B[31mItem Price declined\u001B[39m");
            //Setting the item price text field
            ItemPriceTextField.clear();
            ItemPriceTextField.setPromptText("Enter the Item Price");
            ItemPriceTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item quantity
        uidValidaitionObjB.itemQuantityValidate();
        //If the item quantity is valid
        if (uidValidaitionObjB.getValidationCheck()) {
            System.out.println("\u001B[32mItem Code Quantity \u001B[39m");
            //Increase validate points
            uidValidaitionObjB.setValidatepoints(uidValidaitionObjB.getValidatepoints() + 1);
            //Pass the item quantity to itemRecord array
            itemRecord[4] = Validator.getItemQuantity();
        } //If the item quantity is invalid
        else {
            System.out.println("\u001B[31mItem Quantity declined\u001B[39m");
            //Setting the item quantity field
            ItemQuantityTextField.clear();
            ItemQuantityTextField.setPromptText("Enter the Item Quantity");
            ItemQuantityTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item category
        uidValidaitionObjB.itemCategoryValidate();
        //If the item category is valid
        if (uidValidaitionObjB.getValidationCheck()) {
            System.out.println("\u001B[32mItem Category accepted \u001B[39m");
            //Increase the validate points
            uidValidaitionObjB.setValidatepoints(uidValidaitionObjB.getValidatepoints() + 1);
            //Passing the item category to the itemRecord array
            itemRecord[5] = Validator.getItemCategory();
        } //If the item category is invalid
        else {
            System.out.println("\u001B[31mItem Category declined\u001B[39m");
            //Setting the item category text field
            ItemCategoryTextField.clear();
            ItemCategoryTextField.setPromptText("Enter the Item Category");
            ItemCategoryTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //Validate the item purchase date
        uidValidaitionObjB.itemPurchaseDateValidate();
        //If the item purchase year is valid
        if (uidValidaitionObjB.getValidationCheckYear()) {
            System.out.println("\u001B[32mItem Purchase Year accepted \u001B[39m");
            //Increase validate points
            uidValidaitionObjB.setValidatepoints(uidValidaitionObjB.getValidatepoints() + 1);
            //Passing the item purchase year to itemRecord array
            itemRecord[6] = Validator.getItemPurchaseYear();
            //If the item purchase month is valid
            if (uidValidaitionObjB.getValidationCheckMonth()) {
                System.out.println("\u001B[32mItem Purchase Month accepted \u001B[39m");
                //Increase validate points
                uidValidaitionObjB.setValidatepoints(uidValidaitionObjB.getValidatepoints() + 1);
                //Getting item purchase month to itemRecord array
                itemRecord[7] = Validator.getItemPurchaseMonth();
                //If the item purchase day is valid
                if (uidValidaitionObjB.getValidationCheckMonth()) {
                    System.out.println("\u001B[32mItem Purchase Day accepted \u001B[39m");
                    //Increase the validate points
                    uidValidaitionObjB.setValidatepoints(uidValidaitionObjB.getValidatepoints() + 1);
                    //Pass the item purhase day to the itemRecord array
                    itemRecord[8] = Validator.getItemPurchaseDay();
                }//If the item purchase day is invalid
                else {
                    System.out.println("\u001B[31mItem Purchase Day declined\u001B[39m");
                    //Setting the item purchase day text field
                    ItemPurchaseDayTextField.clear();
                    ItemPurchaseDayTextField.setPromptText("Day");
                    ItemPurchaseDayTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                    //Disable the submit button
                    submitButton.setDisable(true);
                }
            } //If the item purchase month is invalid
            else {
                System.out.println("\u001B[31mItem Purchase Month declined\u001B[39m");
                //Setting the item purchase month text field
                ItemPurchaseMonthTextField.clear();
                ItemPurchaseMonthTextField.setPromptText("Month");
                ItemPurchaseMonthTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                System.out.println("\u001B[31mItem Purchase Day declined\u001B[39m");
                //Setting the item purchase day text field
                ItemPurchaseDayTextField.clear();
                ItemPurchaseDayTextField.setPromptText("Day");
                ItemPurchaseDayTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                //Disable the submit button
                submitButton.setDisable(true);
            }
        }//If the item purchase year is invalid
        else {
            System.out.println("\u001B[31mItem Purchase Year declined\u001B[39m");
            //Setting the item purchase year text field
            ItemPurchaseYearTextField.clear();
            ItemPurchaseYearTextField.setPromptText("Year");
            ItemPurchaseYearTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            System.out.println("\u001B[31mItem Purchase Month declined\u001B[39m");
            //Setting the item purchase month text field
            ItemPurchaseMonthTextField.clear();
            ItemPurchaseMonthTextField.setPromptText("Month");
            ItemPurchaseMonthTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            System.out.println("\u001B[31mItem Purchase Day declined\u001B[39m");
            //Setting the item purchase day text field
            ItemPurchaseDayTextField.clear();
            ItemPurchaseDayTextField.setPromptText("Day");
            ItemPurchaseDayTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable the submit button
            submitButton.setDisable(true);
        }
        //If the image is not valid
        if (!Validator.getImageValidationCheck()) {
            //Setting the image pane border
            ImagePane.setStyle("-fx-border-color: rgb(230, 77, 50);");
            System.out.println("\u001B[31mItem Image declined\u001B[39m");
        }
        try {
            System.out.println("\u001B[32mItems.txt loaded successfully\u001B[39m");
            // Create the data string
            String data = String.valueOf(itemRecord[0] + "," + itemRecord[1] + "," + itemRecord[2] + "," + itemRecord[3] + "," + itemRecord[4] + "," + itemRecord[5] + "," + itemRecord[6] + "," + itemRecord[7] + "," + itemRecord[8] + "," + itemRecord[9] + "\n");
            //Encrypt the string
            String encryptedData = Encryption.encryptData(data);
            try {
                //Open the file
                File file = new File(itemsFile);
                //make the file read and write
                file.setWritable(true);
            }catch (Exception e){
                System.out.println("\u001B[31mFile not found\u001B[39m");
            }
            // Append the data to the file without overwriting existing content
            try (FileWriter fileWriter = new FileWriter(itemsFile, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                //Wtriting the encrypted data in the file
                bufferedWriter.write(encryptedData);
                //New line
                bufferedWriter.write("\n");
                System.out.println("\u001B[32mData written to the file\u001B[39m");
            } catch (Exception ex) {
                System.out.println("\u001B[31mAn error occurred while writing data to the file\u001B[39m");
            }
            File file = new File(itemsFile);
            //Making the file read only
            file.setReadOnly();
            System.out.println("\u001B[32mItems.txt updated successfully\u001B[39m");
            //Displaying the successfull message
            SuccessfullActionMsg successMsgObj = new SuccessfullActionMsg();
            successMsgObj.actionMessageView(event);
        } catch (Exception e) {
            System.out.println("\u001B[31mAn error occurred while encrypting data\u001B[39m");
        }
        System.out.println("\u001B[34m_____Action update Item Details finished_____\u001B[39m");
    }

    //When VID button is clicked this function will display all the data in Items.txt in a table
    @FXML
    public void onClickVIDButton(ActionEvent e) throws Exception {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("VID-ui.fxml"));
        System.out.println("\u001B[35mSystem --> VID-ui\u001B[39m");

        // Capturing the tables and columns
        TableView<ViewItems> VIDTableView = (TableView<ViewItems>) root.lookup("#VIDTableView");
        TableColumn<ViewItems, String> itemCodeColumn = (TableColumn<ViewItems, String>) VIDTableView.getColumns().get(0);
        TableColumn<ViewItems, String> itemNameColumn = (TableColumn<ViewItems, String>) VIDTableView.getColumns().get(1);
        TableColumn<ViewItems, String> itemBrandColumn = (TableColumn<ViewItems, String>) VIDTableView.getColumns().get(2);
        TableColumn<ViewItems, String> itemPriceColumn = (TableColumn<ViewItems, String>) VIDTableView.getColumns().get(3);
        TableColumn<ViewItems, String> itemQuantityColumn = (TableColumn<ViewItems, String>) VIDTableView.getColumns().get(4);
        TableColumn<ViewItems, String> itemCategoryColumn = (TableColumn<ViewItems, String>) VIDTableView.getColumns().get(5);
        TableColumn<ViewItems, String> itemPurchaseDateColumn = (TableColumn<ViewItems, String>) VIDTableView.getColumns().get(6);
        TableColumn<ViewItems, String> itemImageColumn = (TableColumn<ViewItems, String>) VIDTableView.getColumns().get(7);
        //Setting the cell value factories
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemBrandColumn.setCellValueFactory(new PropertyValueFactory<>("itemBrand"));
        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
        itemCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
        itemPurchaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("itemPurchaseDate"));
        itemImageColumn.setCellValueFactory(new PropertyValueFactory<>("itemImagePath"));
        //Creating observable array list
        ObservableList<ViewItems> itemData = FXCollections.observableArrayList();
        int lineCalculation = 0;
        //Opne the file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(itemsFile))) {
            String line;
            //Readint the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                //Decrypting thr line
                String decryptedLine = Encryption.decryptData(line);
                //Splitiing the line and getting it into array
                String[] itemRecord = decryptedLine.split(",");
                ViewItems item = new ViewItems(itemRecord[0], itemRecord[1], itemRecord[2], itemRecord[3], itemRecord[4], itemRecord[5], String.valueOf(itemRecord[6] + " / " + itemRecord[7] + " / " + itemRecord[8]),itemRecord[9]);
                lineCalculation++;
                // Setting the record in the table
                itemData.add(item);
            }
            //sorting the item code assending order using bubble sort
            int n = itemData.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    int itemCode1 = Integer.parseInt(itemData.get(j).getItemCode());
                    int itemCode2 = Integer.parseInt(itemData.get(j + 1).getItemCode());
                    if (itemCode1 > itemCode2) {
                        //Swapping
                        ViewItems temp = itemData.get(j);
                        itemData.set(j, itemData.get(j + 1));
                        itemData.set(j + 1, temp);
                    }
                }
            }
            // This will capture the totalItemsLabel and print the total items quantity
            Label totalItemsLabel = (Label) root.lookup("#totalItemsLabel");
            totalItemsLabel.setText("Total items : " + lineCalculation);
            //Setting the data in the table
            VIDTableView.setItems(itemData);
        } catch (Exception ex) {
            System.out.println("\u001B[31mAn error occurred while reading the file\u001B[39m");
            ex.printStackTrace();
        }
        Scene scene = new Scene(root, 800, 600);
        //Setting the scene to the stage
        stage.setScene(scene);
        //Showing the stage
        stage.show();
    }

    //When SDD button is clicked this function will select randomly four dealers from Dealers.txt
    @FXML
    public void onClickSDDButton(ActionEvent e) throws IOException {
        System.out.println("\u001B[35mSystem --> VRL-ui\u001B[39m");
        System.out.println("\u001B[34m_____Action random Dealer selection started_____ \u001B[39m");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dealersFile))) {
            String line;
            int i = 0;
            //Reading Dealers.txt and getting each line to dealersArray
            while ((line = bufferedReader.readLine()) != null) {
                dealersArray[i] = line;
                i++;
            }
            RandomDealer selectedNumbersObj = new RandomDealer();
            //This function will randomly generate 4 numbers from 0-5
            selectedNumbersObj.selectRandomNumbers();
            dealerRecord = new String[dealersArray.length][];
            int k = 0;
            int selectedId = -1;
            for (int j = 0; j < dealersArray.length; j++) {
                dealerRecord[j] = dealersArray[j].split(",");
                if (selectedId == Integer.parseInt(dealerRecord[j][0])) {
                    continue;
                }//If dealerID is equal to one of randomly generated numbers the dealer details will store in selectedDealers array
                if (Integer.parseInt(dealerRecord[j][0]) == selectedNumbersObj.getRandomNumber1() || Integer.parseInt(dealerRecord[j][0]) == selectedNumbersObj.getRandomNumber2() || Integer.parseInt(dealerRecord[j][0]) == selectedNumbersObj.getRandomNumber3() || Integer.parseInt(dealerRecord[j][0]) == selectedNumbersObj.getRandomNumber4()) {
                    selectedDealers[k] = dealerRecord[j];
                    selectedId = Integer.parseInt(dealerRecord[j][0]);
                    k++;
                }
            }
            //This will call the viewDealerTable fucntion
            viewDealersTable(e);
        }
    }

    //This will print the randomly selected dealer details in a table
    @FXML
    public void viewDealersTable(ActionEvent event) {
        try {
            System.out.println("\u001B[34m_____Action random Dealer selection finished_____ \u001B[39m");
            System.out.println("\u001B[34m_____Action view Dealer details started_____ \u001B[39m");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("VRL-ui.fxml"));
            //Capturing the VRLTableView
            TableView<Dealer> VRLTableView = (TableView<Dealer>) root.lookup("#VRLTableView");
            TableColumn<Dealer, String> dealerIDColumn = (TableColumn<Dealer, String>) VRLTableView.getColumns().get(0);
            TableColumn<Dealer, String> dealerFirstNameColumn = (TableColumn<Dealer, String>) VRLTableView.getColumns().get(1);
            TableColumn<Dealer, String> dealerLastNameColumn = (TableColumn<Dealer, String>) VRLTableView.getColumns().get(2);
            TableColumn<Dealer, String> dealerLocationColumn = (TableColumn<Dealer, String>) VRLTableView.getColumns().get(3);
            TableColumn<Dealer, String> dealerContactNoColumn = (TableColumn<Dealer, String>) VRLTableView.getColumns().get(4);
            //Getting data to observable List
            ObservableList<Dealer> dealerData = FXCollections.observableArrayList();
            for (int j = 0; j < selectedDealers.length; j++) {
                Dealer dealer = new Dealer(selectedDealers[j][0], selectedDealers[j][1], selectedDealers[j][2], selectedDealers[j][3], selectedDealers[j][4]);
                dealerData.add(dealer);
            }
            //Sorting the location  using bubble sort
            int n = dealerData.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    String location1 = dealerData.get(j).getDealerLocation();
                    String location2 = dealerData.get(j + 1).getDealerLocation();
                    if (location1.compareTo(location2) > 0) {
                        //Swapping
                        Dealer temp = dealerData.get(j);
                        dealerData.set(j, dealerData.get(j + 1));
                        dealerData.set(j + 1, temp);
                    }
                }
            }
            //Setting the cell value factories
            dealerIDColumn.setCellValueFactory(new PropertyValueFactory<>("dealerID"));
            dealerFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("dealerFirstName"));
            dealerLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("dealerLastName"));
            dealerLocationColumn.setCellValueFactory(new PropertyValueFactory<>("dealerLocation"));
            dealerContactNoColumn.setCellValueFactory(new PropertyValueFactory<>("dealerContactNo"));
            //Setting the data in the table
            VRLTableView.setItems(dealerData);
            Scene scene = new Scene(root, 800, 600);
            //Setting the scene to the stage
            stage.setScene(scene);
            //Showing the stage
            stage.show();
        } catch (IOException ex) {
            System.out.println("\u001B[31mAn error occurred while loading the VRL-ui.fxml\u001B[39m");
        }
        System.out.println("\u001B[34m_____Action view Dealer details finished_____ \u001B[39m");
    }

    //If user enter a dealerID and click the View Items button in VRLthis function will print dealer items in a table if it is a valid and randomly selected dealerIC
    @FXML
    public void onClickVRLSubmitButton(ActionEvent e) throws Exception {
        System.out.println("\u001B[34m_____Action view Dealer items started_____ \u001B[39m");
        //Passing the dealer id to the Validator
        Validator dealerIDObj = new Validator(VRLDealerIDTextField.getText());
        //Validate the dealer id
        dealerIDObj.itemCodeValidate();
        //If the dealer id is valid
        if (dealerIDObj.getValidationCheck()) {
            boolean selection = false;
            //Check if the given DealerID is a selected one
            for (int i = 0; i < selectedDealers.length; i++) {
                if (selectedDealers[i][0].equals(VRLDealerIDTextField.getText())) {
                    selection = true;
                    break;
                }
            }
            //If the dealer is selected one
            if (selection) {
                //Read the dealers file
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dealersFile))) {
                    String line;
                    //Setting the dealer id does not exitsts
                    boolean dealerCodeMatch = false;
                    //Reading the file line by line
                    while ((line = bufferedReader.readLine()) != null) {
                        //Splitting the line and getting it to an array
                        String[] dealerInfo = line.split(",");
                        //If the dealer id exists
                        if (dealerInfo[0].equals(Validator.getItemCode())) {
                            //Make dealer id exists
                            dealerCodeMatch = true;
                        }
                    }
                    //If dealer id exists
                    if (dealerCodeMatch) {
                        //Capturing the previous stage
                        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                        //Loading LDI-ui.fxml
                        Parent root = FXMLLoader.load(getClass().getResource("LDI-ui.fxml"));
                        //Capturing the table
                        TableView<Dealer> VRLTableView = (TableView<Dealer>) root.lookup("#LDITableView");
                        TableColumn<Dealer, String> dealerIDColumn = (TableColumn<Dealer, String>) VRLTableView.getColumns().get(0);
                        TableColumn<Dealer, String> dealerFirstNameColumn = (TableColumn<Dealer, String>) VRLTableView.getColumns().get(1);
                        TableColumn<Dealer, String> dealerItemColumn = (TableColumn<Dealer, String>) VRLTableView.getColumns().get(2);
                        //Creating observable array list
                        ObservableList<Dealer> dealerData = FXCollections.observableArrayList();
                        for (String[] record : dealerRecord) {
                            if (record[0].equals(Validator.getItemCode())) {
                                Dealer dealer = new Dealer(record[0], record[1], record[5]);
                                //Add data to the observable list
                                dealerData.add(dealer);
                            }
                        }
                        //Setting the cell value factories
                        dealerIDColumn.setCellValueFactory(new PropertyValueFactory<>("dealerID"));
                        dealerFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("dealerFirstName"));
                        dealerItemColumn.setCellValueFactory(new PropertyValueFactory<>("dealerItem"));
                        //Setting the dealer items in the table
                        VRLTableView.setItems(dealerData);
                        Scene scene = new Scene(root, 800, 600);
                        //Setting the scene to the stage
                        stage.setScene(scene);
                        //Showing the stage
                        stage.show();
                    } else {
                        VRLDealerIDTextField.clear();
                        VRLDealerIDTextField.setPromptText("DealerID");
                        VRLDealerIDTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                        //Disable submit button
                        submitButton.setDisable(true);
                        System.out.println("\u001B[31mDealer ID does not match with selected Dealer IDs\u001B[39m");
                    }
                } catch (IOException ex) {
                    System.out.println("\u001B[31mAn error occurred while reading the file\u001B[39m");
                }
            } //If the dealer is selected one
            else {
                VRLDealerIDTextField.clear();
                VRLDealerIDTextField.setPromptText("DealerID");
                VRLDealerIDTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
                //Disable submit button
                submitButton.setDisable(true);
            }
        }//If the dealer id is valid
        else {
            //Setting the dealer id text field
            VRLDealerIDTextField.clear();
            VRLDealerIDTextField.setPromptText("DealerID");
            VRLDealerIDTextField.setStyle("-fx-prompt-text-fill: rgb(230, 77, 50);-fx-border-color: rgb(230, 77, 50);");
            //Disable submit button
            submitButton.setDisable(true);
        }
        System.out.println("\u001B[34m_____Action view Dealer items finished_____ \u001B[39m");
    }

    public void onClickLDIResetButton(ActionEvent event) {
        viewDealersTable(event);
    }
}