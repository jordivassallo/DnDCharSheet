package main.java.Controllers;

import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.java.Interfaces.Styles;
import javafx.scene.image.ImageView;

import java.io.IOException;

import javafx.fxml.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;


public class MenuController extends StackPane implements Styles {
    @FXML private ImageView createBtnImage, loadBtnImage;
    @FXML private Label createBtnLabel;


    public MenuController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/menu.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();

            btnAnimation(createBtnImage);
            btnAnimation(loadBtnImage);

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /* OnClick activity for create button */
    @FXML
    protected void createBtn() throws Exception {
        CreateCharController createCharController = new CreateCharController();
        PopUpController popUpController = new PopUpController();

        /* Resizing and orienting current window */
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setX(((primaryScreenBounds.getMinX() + primaryScreenBounds.getMaxX()) / 2) - stage.getWidth() / 2);
        stage.setY(primaryScreenBounds.getMinY());
        stage.setHeight(primaryScreenBounds.getMaxY());
        stage.setScene(new Scene(createCharController));

        /* Creating the initial popup */
        Stage popup = new Stage();
        popup.setScene(new Scene(popUpController));
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


