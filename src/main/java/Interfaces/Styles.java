package main.java.Interfaces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Styles {
    default void btnAnimation(ImageView imgView, Image pressedBtn, Image unpressedBtn) {
        imgView.setOnMouseEntered(e -> {
            imgView.setImage(pressedBtn);
        });

        imgView.setOnMouseExited(e -> {
            imgView.setImage(unpressedBtn);
        });
    }
}
