package main.java.Controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class CreateCharController extends StackPane {

    private Parent root;
    
    public CreateCharController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/createChar.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            this.root = fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        
        StackPane rootNode = (StackPane) this.root;
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        Image img = new Image("/main/resources/img/RepeatBackground.png");
        BackgroundSize customSize = new BackgroundSize(0.5, 0.5, true, true, true, false);
        BackgroundImage bImg = new BackgroundImage(img, 
                                                   BackgroundRepeat.NO_REPEAT, 
                                                   BackgroundRepeat.NO_REPEAT, 
                                                   BackgroundPosition.CENTER, 
                                                   customSize);
        Background bGround = new Background(bImg);
        rootNode.setBackground(bGround);

        Stage stage = (Stage) this.getScene().getWindow();
        stage.setX(((primaryScreenBounds.getMinX() + primaryScreenBounds.getMaxX()) / 2) - stage.getWidth() / 2);
        stage.setY(primaryScreenBounds.getMinY());
        stage.setHeight(primaryScreenBounds.getMaxY());
        stage.setScene(new Scene(root));
    }

}
