/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moment.player.Controller;
//
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.control.TextInputDialog;
import java.io.File;
import java.util.Optional;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import Component.AboutMomentPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Anifowoshe
 */
public class MomentMainController implements Initializable {
    
    @FXML
    private Label toolBarBackBtn;
    @FXML
    private Label toolBarOpenFolder;
    @FXML
    private Label toolBarCloud;
    @FXML
    private Label toolBarExit;
    @FXML
    private Label toolBarHelp;
    @FXML
    private Label toolBarFullScreen;
    @FXML
    private VBox momentToolbar;
    
    
    private Double toolbarWidth = 0.0d;
    private boolean isToolBarHidden = false;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //This gets the preferred width of the toolbar 
        this.toolbarWidth = momentToolbar.getPrefWidth();
        
        //This aspect helps to set tooltips and imageView for all the toolbar components 
        toolBarBackBtn.setGraphic(new ImageView(new Image("/moment/player/Images/backButton.png", 25, 25, false, false)));
        toolBarBackBtn.setTooltip(new Tooltip("back"));
        
        toolBarOpenFolder.setGraphic(new ImageView(new Image("/moment/player/Images/openFolder.png", 25, 25, false, false)));
        toolBarOpenFolder.setTooltip(new Tooltip("open file/folder"));
        
        toolBarCloud.setGraphic(new ImageView(new Image("/moment/player/Images/cloud.png", 25, 25, false, false)));
        toolBarCloud.setTooltip(new Tooltip("stream video"));
        
        toolBarExit.setGraphic(new ImageView(new Image("/moment/player/Images/exit.png", 25, 25, false, false)));
        toolBarExit.setTooltip(new Tooltip("Exit app"));
        
        toolBarHelp.setGraphic(new ImageView(new Image("/moment/player/Images/help.png", 25, 25, false, false)));
        toolBarHelp.setTooltip(new Tooltip("help"));
        
        toolBarFullScreen.setGraphic(new ImageView(new Image("/moment/player/Images/fullscreen.png", 25, 25, false, false)));
        toolBarFullScreen.setTooltip(new Tooltip("fullscreen mode"));
    }   
    
   
    @FXML
    private void showCloudDialog(MouseEvent event){
        TextInputDialog cloudDialog = new TextInputDialog();
        cloudDialog.setTitle("Cloud Stream");
        cloudDialog.setHeaderText(null);
        cloudDialog.setGraphic(null);
        cloudDialog.setContentText("Enter the movie url:");
        
        //set the button types 
        ButtonType connectButtonType = new ButtonType("connect", ButtonData.OK_DONE);
        cloudDialog.getDialogPane().getButtonTypes().setAll(connectButtonType);
        
        Optional<String> result = cloudDialog.showAndWait();
        if(result.isPresent()){
            
        }
    }
    
    @FXML
    private void closeApp(MouseEvent event){
        Stage stage = (Stage) toolBarExit.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void openFileDialog(MouseEvent event){
        FileChooser openDialog = new FileChooser();
        openDialog.setTitle("select a video file to open");
        openDialog.getExtensionFilters().addAll(
                new ExtensionFilter("Media Files", "*.3gp", "*.mp4", "*.mkv" , "*.avi" , "*.flv" , "*.m4v"),
                new ExtensionFilter("Video Files", "*.3gp", "*.mp4", "*.mkv", "*.avi", "*.flv", "*.m4v")
        );
        File selectedFile = openDialog.showOpenDialog((Stage) toolBarOpenFolder.getScene().getWindow());
        if(selectedFile != null){
            System.out.println(selectedFile);
        }
    }
    
    @FXML
    private void showHelpDialog(MouseEvent event){
        Dialog aboutDialog = new Dialog();
        aboutDialog.setTitle("About");
        aboutDialog.setHeaderText(null);
        aboutDialog.setGraphic(null);
        
        ButtonType cancelModal = new ButtonType("ok", ButtonData.CANCEL_CLOSE);
        aboutDialog.getDialogPane().getButtonTypes().setAll(cancelModal);
        
        AboutMomentPlayer aboutNode = new AboutMomentPlayer();
        aboutDialog.getDialogPane().setContent(aboutNode);
        aboutDialog.showAndWait();
    }
    
    
    @FXML
    private void hideToolbar(MouseEvent event){
         Timeline timeline = new Timeline();
         timeline.getKeyFrames().addAll(
                 new KeyFrame(Duration.ZERO, 
                         new KeyValue(momentToolbar.prefWidthProperty(), this.toolbarWidth)
                 ),
                 new KeyFrame(Duration.millis(300.0d),
                         new KeyValue(momentToolbar.prefWidthProperty(), 0.0)
                 )
         );
         
         timeline.play();
         timeline.setOnFinished(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent evt){
                 momentToolbar.setVisible(false);
                 isToolBarHidden = true;
             }
         });
    }  
    
    
    @FXML
    private void showToolBar(MouseEvent event){
        if(isToolBarHidden){
            momentToolbar.setVisible(true);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, 
                            new KeyValue(momentToolbar.prefWidthProperty(), 0.0)
                    ),
                    new KeyFrame(Duration.millis(300.0d),
                            new KeyValue(momentToolbar.prefWidthProperty(), this.toolbarWidth)
                    )
            );

            timeline.play();
            timeline.setOnFinished(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent evt){
                    isToolBarHidden = false;
                }
            });
        }
    }
}
