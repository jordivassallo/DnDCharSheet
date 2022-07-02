package main.java.Interfaces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Styles {

    default void btnAnimation(ImageView imgView) {
        final Image pressedBtn = new Image("/main/resources/img/button_pressed.jpg");
        final Image unpressedBtn = new Image("/main/resources/img/button_unpressed.jpg");

        imgView.setOnMouseEntered(e -> {
            imgView.setImage(pressedBtn);
        });

        imgView.setOnMouseExited(e -> {
            imgView.setImage(unpressedBtn);
        });
    }
}
