package main.java;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.java.Controllers.MenuController;

 
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuController menuController = new MenuController();
        Scene scene = new Scene(menuController);

        /* Binding CSS to the Menu Scene */
        String css = this.getClass().getResource("/main/resources/CSS/button.css").toExternalForm();
        scene.getStylesheets().add(css);        

        primaryStage.setScene(scene);
        primaryStage.setTitle("D&D Character");
        primaryStage.getIcons().add(new Image("/main/resources/img/logo.png"));
        primaryStage.setWidth(640);
        primaryStage.setHeight(480);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
 
public static void main(String[] args) {
        launch(args);
    }
}