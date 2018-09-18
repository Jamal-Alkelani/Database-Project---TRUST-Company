/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class AboutController implements Initializable {

    @FXML
    private ImageView close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


              DropShadow ds = new DropShadow();

        
        close.setOnMouseEntered(MouseEvent->{
        ds.setOffsetY(0);
        ds.setOffsetX(0);
        ds.setHeight(100f);
        ds.setWidth(100f);
        ds.setRadius(15);
        ds.setSpread(0.6f);
        ds.setColor(Color.RED);
        close.setEffect(ds);
        });
        
                close.setOnMouseExited(MouseEvent->{
        ds.setOffsetY(0);
        ds.setOffsetX(0);
        ds.setHeight(0);
        ds.setWidth(0);
        ds.setRadius(0);
        ds.setSpread(0);
        ds.setColor(Color.WHITE);
        close.setEffect(ds);
        });
        
            close.setOnMouseClicked(MouseEvent->{

            
            Stage stage = (Stage) close.getScene().getWindow();
                 stage.close();
        });
    }    
    
}
