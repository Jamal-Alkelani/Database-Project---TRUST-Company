/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.project;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class JFXDialog {
        
        public Optional<ButtonType> showDialog(Alert.AlertType type,String Title,String Headertxt,String Text){
                    Alert alert = new Alert(type);
            alert.setTitle(Title);
            alert.setHeaderText(Headertxt);
            alert.setContentText(Text);
            Optional<ButtonType> result = alert.showAndWait();
            return result;
    }
}
