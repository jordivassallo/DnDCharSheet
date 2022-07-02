package main.java.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import main.java.Interfaces.Styles;

public class PopUpController extends VBox implements Styles {
    
    @FXML private ComboBox sourceDrop, statDrop, expDrop;
    @FXML private ImageView btnDone;
    
    public PopUpController() throws IOException {
        FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/popup.fxml"));
        popupLoader.setRoot(this);
        popupLoader.setController(this);

        try {
            popupLoader.load();
            btnAnimation(btnDone);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
