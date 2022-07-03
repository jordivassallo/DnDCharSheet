package main.java.Controllers;

import java.io.IOException;

import org.controlsfx.control.CheckComboBox;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import main.java.Interfaces.Styles;

public class PopUpController extends VBox implements Styles {
    
    @FXML private CheckComboBox<String> sourceDrop, statDrop, expDrop;
    @FXML private ImageView btnDone;

    public enum Sources {
        PHB (false, "Player's Handbook"),
        MM (false, "Monster Manual"),
        DMG (false, "Dungeon Master's Guide"),
        VGtM (false, "Volo's Guide to Monsters"),
        XGtE (false, "Xanathar's Guide to Everything"),
        MToF (false, "Mordenkainen's Tome of Foes"),
        TCoE (false, "Tasha's Cauldron of Everything"),
        FToD (false, "Fizban's Treasury of Dragons"),
        MPMotM (false, "Mordenkainen Presents: Monsters of the Multiverse");

        boolean present;
        String fullname;

        private Sources(boolean present, String fullname) {
            this.present = present;
            this.fullname = fullname;
        }   
    }
    public enum Stats {
        METHOD_1 (false, "Point Buy"),
        METHOD_2 (false, "Standard Array"),
        METHOD_3 (false, "Standard Roll"),
        METHOD_4 (false, "Custom Roll"),
        METHOD_5 (false, "Manual Fill");

        boolean present;
        String method_name;

        private Stats(boolean present, String method_name){
            this.present = present;
            this.method_name = method_name;
        }
    }
    public enum Advancement {
        EXP (false, "Experience Points"),
        MILESTONE (false, "Milestone");

        boolean present;
        String method_name;

        private Advancement(boolean present, String method_name) {
            this.present = present;
            this.method_name = method_name;
        }
    }

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

        /* Filling the ComboBoxes */
        for (Sources source : Sources.values()) {
            sourceDrop.getItems().add(source.fullname);
        }

        for (Stats method : Stats.values()) {
            statDrop.getItems().add(method.method_name);
        }

        for (Advancement method : Advancement.values()) {
            expDrop.getItems().add(method.method_name);
        }
        

        
    }


}
