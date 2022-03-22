package main.java.Controllers;

import javafx.scene.layout.StackPane;
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


public class MenuController extends StackPane {


    @FXML private ImageView createBtnImage, loadBtnImage;
    private Image pressedBtn = new Image("/main/resources/img/button_pressed.png");
    private Image unpressedBtn = new Image("/main/resources/img/button_unpressed.png");


    public MenuController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/menu.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            initializeListeners();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void initializeListeners() {
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
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setX(((primaryScreenBounds.getMinX() + primaryScreenBounds.getMaxX()) / 2) - stage.getWidth() / 2);
        stage.setY(primaryScreenBounds.getMinY());
        stage.setHeight(primaryScreenBounds.getMaxY());
        stage.setScene(new Scene(createCharController));
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


