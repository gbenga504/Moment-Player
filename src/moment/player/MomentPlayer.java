/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moment.player;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Anifowoshe
 */
public class MomentPlayer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // Loading fonts 
        System.out.println(MomentPlayer.class);
        Font.loadFont(MomentPlayer.class.getResource("Fonts/Roboto.ttf").toExternalForm(), 15);
        Parent root = FXMLLoader.load(getClass().getResource("MomentPlayerDocument.fxml"));
        
        Scene scene = new Scene(root);

        
        stage.setScene(scene);
        stage.setMinWidth(800.0);
        stage.setMinHeight(600.0);
        
        stage.setTitle("Moment Player");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
