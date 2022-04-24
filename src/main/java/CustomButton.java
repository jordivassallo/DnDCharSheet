package main.java;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class CustomButton extends StackPane {

    @FXML private ImageView btnImage;
    @FXML private Label btnLabel;

    FXMLLoader loader;
    
    private Image pressedBtn = new Image("/main/resources/img/button_pressed.jpg");
    private Image unpressedBtn = new Image("/main/resources/img/button_unpressed.jpg");

    public CustomButton(){
        super();
        if (getClass() == CustomButton.class){
            loader = new FXMLLoader(getClass().getResource("/main/resources/fxml/customButton.fxml")); 
            try {
                loader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public void addListeners() {
        btnImage.addEventHandler(MouseEvent.MOUSE_ENTERED,
                          e -> btnImage.setImage(pressedBtn)
        );
        btnImage.addEventHandler(MouseEvent.MOUSE_EXITED,
                          e -> btnImage.setImage(unpressedBtn)
        );
    }

    public Label getBtn(){
        return btnLabel;
    }
    
}
