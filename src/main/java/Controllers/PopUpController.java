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
        PHB ("Player's Handbook"),
        MM ("Monster Manual"),
        DMG ("Dungeon Master's Guide"),
        VGtM ("Volo's Guide to Monsters"),
        XGtE ("Xanathar's Guide to Everything"),
        MToF ("Mordenkainen's Tome of Foes"),
        TCoE ("Tasha's Cauldron of Everything"),
        FToD ("Fizban's Treasury of Dragons"),
        MPMotM ("Mordenkainen Presents: Monsters of the Multiverse");

        String fullname;

        private Sources(String fullname) {
            this.fullname = fullname;
        }   
    }
    public enum Stats {
        METHOD_1 ("Point Buy"),
        METHOD_2 ("Standard Array"),
        METHOD_3 ("Standard Roll"),
        METHOD_4 ("Custom Roll"),
        METHOD_5 ("Manual Fill");
        
        String method_name;

        private Stats(String method_name){
            this.method_name = method_name;
        }
    }
    public enum Advancement {
        EXP ("Experience Points"),
        MILESTONE ("Milestone");

        String method_name;

        private Advancement(String method_name) {
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

        for (Stats statMethod : Stats.values()) {
            statDrop.getItems().add(statMethod.method_name);
        }

        for (Advancement advMethod : Advancement.values()) {
            expDrop.getItems().add(advMethod.method_name);
        }
    }


}
