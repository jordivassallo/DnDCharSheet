package main.java.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import main.java.Interfaces.Styles;


public class CreateCharController extends StackPane implements Styles {

    @FXML private TextField charName;
    
    public CreateCharController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/fxml/createChar.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        StackPane root = (StackPane) loader.load();
        Image img = new Image("/main/resources/img/RepeatBackground.png");
        BackgroundSize customSize = new BackgroundSize(0.5, 0.5, true, true, true, false);
        BackgroundImage bImg = new BackgroundImage(img, 
                                                   BackgroundRepeat.NO_REPEAT, 
                                                   BackgroundRepeat.NO_REPEAT, 
                                                   BackgroundPosition.CENTER, 
                                                   customSize);
        Background bGround = new Background(bImg);
        root.setBackground(bGround);

        charName.setOnKeyPressed(e -> {
             if (e.getCode() == KeyCode.ESCAPE) {root.requestFocus();} 
        });
    }
}
