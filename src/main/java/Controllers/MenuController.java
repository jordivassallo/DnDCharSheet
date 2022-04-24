package main.java.Controllers;

import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import javafx.fxml.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;


public class MenuController extends StackPane {


    @FXML private ImageView createBtnImage, loadBtnImage;
    @FXML private Label createBtnLabel;
    private Image pressedBtn = new Image("/main/resources/img/button_pressed.jpg");
    private Image unpressedBtn = new Image("/main/resources/img/button_unpressed.jpg");


    public MenuController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/menu.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        

        try {
            fxmlLoader.load();
            // initializeListeners();  //TODO: remove this function

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void initializeListeners() {        //TODO: remove this function (replace with css ideally)
        /* Create Button Animations  (Event Handler + lambda) */
        createBtnImage.addEventHandler(MouseEvent.MOUSE_ENTERED,
                          e -> createBtnImage.setImage(pressedBtn)
        );
        createBtnImage.setOnMouseExited(e -> {
            createBtnImage.setImage(unpressedBtn);
        });
        
        
        /* Load Button Animations (setOnXXXX method) */
        loadBtnImage.addEventHandler(MouseEvent.MOUSE_ENTERED, 
                          e -> loadBtnImage.setImage(pressedBtn)
        );
        loadBtnImage.setOnMouseExited(e -> {
            loadBtnImage.setImage(unpressedBtn);
        });
    }


    /* OnClick activity for create button */
    @FXML
    protected void createBtn() throws Exception {
        CreateCharController createCharController = new CreateCharController();

        /* Resizing and orienting current window */
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setX(((primaryScreenBounds.getMinX() + primaryScreenBounds.getMaxX()) / 2) - stage.getWidth() / 2);
        stage.setY(primaryScreenBounds.getMinY());
        stage.setHeight(primaryScreenBounds.getMaxY());
        stage.setScene(new Scene(createCharController));

        /* Creating the initial pop-up */
        Stage popup = new Stage();
        popup.setResizable(false);
        popup.setHeight(480);
        popup.setWidth(640);
        popup.setX(((primaryScreenBounds.getMinX() + primaryScreenBounds.getMaxX()) / 2) - stage.getWidth() / 2);
        popup.initOwner(stage);
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.showAndWait(); 
    }

    /* OnClick activity for load button */
    @FXML
    protected void loadBtn() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/fxml/loadChar.fxml"));
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        Stage stage = (Stage) this.getScene().getWindow();
        stage.setX(((primaryScreenBounds.getMinX() + primaryScreenBounds.getMaxX()) / 2) - stage.getWidth() / 2);
        stage.setY(primaryScreenBounds.getMinY());
        stage.setHeight(primaryScreenBounds.getMaxY());
        stage.setScene(new Scene(root));
    }

}


