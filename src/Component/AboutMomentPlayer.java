/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Component;

import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 *
 * @author Anifowoshe
 */
public class AboutMomentPlayer extends VBox{
    public AboutMomentPlayer(){
        /*
         *
         * Holds the main content of the about Moment player 
        */
        HBox mainhbox = new HBox();

        
        ImageView pictureview = new ImageView();
        pictureview.setFitHeight(150.0);
        pictureview.setFitWidth(150.0);
        pictureview.pickOnBoundsProperty();
        pictureview.preserveRatioProperty();
        Image logoImage = new Image("/moment/player/Images/LogoBGImage.png");
        pictureview.setImage(logoImage);
        

        
        VBox maincontent = new VBox();
        Label playerLabel = new Label("MOMENT PLAYER");
        playerLabel.setTextFill(Paint.valueOf("#666666"));
        playerLabel.setFont(Font.font("Arial Black", 24.0));
        Label versionLabel = new Label("1.0.0 Aclet");
        versionLabel.setFont(Font.font(null, 14.0));
        Label contentDescription = new Label();
        contentDescription.setText("Moment Player (popularly known as Mo Player) is an Open source javafx based video player made by 2 Graphical Enthusiast. \n\nThe player uses the popular VLCJ open source library to play a set of formats which are not supported by JavaFx. Help improve our software based on your java and c/c++ skills. \n\nWe are right on gitHub.\n\n© 2017. Designed by Gad and Dr. Blue");
        contentDescription.setWrapText(true);
        Hyperlink playerLink = new Hyperlink();
        playerLink.setText("\n\n\nGithub.com");
        
        
        VBox.setMargin(playerLabel, new Insets(20,0,0,0));
        maincontent.getChildren().addAll(playerLabel, versionLabel, contentDescription, playerLink);
        maincontent.setPrefSize(100.0, 200.0);
        
        
        HBox.setHgrow(maincontent, Priority.ALWAYS);
        mainhbox.setPrefSize(100.0, 200.0);
        mainhbox.setStyle("-fx-background-color: transparent;");
        setVgrow(mainhbox, Priority.ALWAYS);
        HBox.setMargin(maincontent, new Insets(0,0,0,10));
        mainhbox.getChildren().addAll(pictureview,maincontent); 
        HBox.setMargin(pictureview, new Insets(100,0,0,0));
        
        setMaxSize(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        setMinSize(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        setPrefSize(600,400);
        getChildren().addAll(mainhbox);
    }
}
