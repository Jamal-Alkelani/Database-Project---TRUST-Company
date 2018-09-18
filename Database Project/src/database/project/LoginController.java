
package database.project;


import DataBaseFun.Account;
import DataBaseFun.ConnectionDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.validation.Validator;

public class LoginController implements Initializable {
    

    @FXML
    AnchorPane Panel;
    @FXML
    ImageView close,minimize;
    @FXML
    JFXButton signin;
    @FXML
    private JFXTextField UserField;
    @FXML
    private JFXPasswordField PasswordField;

    public LoginController(){

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
        
        
        //close button handling
        close.setOnMouseClicked((MouseEvent e)->{
        System.exit(0);
        });
        
        //minimize button handling        
        minimize.setOnMouseClicked((MouseEvent e) -> {
            Stage stage=(Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
    });
        
        //signin button handling        
        signin.setOnMouseClicked((MouseEvent event) -> {
            
            try {
                SceneManager manager=new SceneManager();
              HomePageController.account=HomePageController.connection.getAccount(UserField.getText(), PasswordField.getText());
                Account aco= HomePageController.account;
    
               // ConnectionDB connection=new ConnectionDB();
               // Account aco=connection.getAccount(UserField.getText(), PasswordField.getText());
                 System.out.print("ssn:"+UserField.getText()+"*    pass:"+PasswordField.getText()+"*");
                if(aco==null)
                {

                    JFXDialog jfxdialog=new JFXDialog();
                    
                    jfxdialog.showDialog(Alert.AlertType.ERROR,"Error", "No such User Found",
                            "Please make sure that you've entered the Username and the Password correclty !");
                }
                else
                {
              if(aco.getType().equals("a"))
              {
                  HomePageController.isManager=true;    
                manager.LoadScene("ManagerHomePage.fxml",0.95f);
                 
                Stage stage = (Stage) signin.getScene().getWindow();
                 stage.close();   
              }
              else
              {
                   manager.LoadScene("HomePage.fxml",0.95f);
                 Stage stage = (Stage) signin.getScene().getWindow();
                 stage.setWidth(999);
                 stage.setHeight(570);
                 System.out.println("staff");
                 stage.close();
              }
                
                }
                
                
                
                
                /*
                if(UserField.getText().compareTo("admin")==0 && PasswordField.getText().compareTo("admin")==0){
                    
                   
                HomePageController.isManager=true;    
                manager.LoadScene("ManagerHomePage.fxml",0.95f);
                 
                Stage stage = (Stage) signin.getScene().getWindow();
                 stage.close();
                }
                else{
                 manager.LoadScene("HomePage.fxml",0.95f);
                 Stage stage = (Stage) signin.getScene().getWindow();
                 stage.setWidth(999);
                 stage.setHeight(570);
                 stage.close();
                }*/
            } 
                catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        });          
    }    
    
    
    
    public void crateAnimation(){
       //move left transition
        TranslateTransition t=new TranslateTransition();
        t.setDuration(Duration.millis(1000));
        t.setFromX(1000);
        t.setToX(0);
             
        //Fadein Transition     
        FadeTransition f=new FadeTransition();
        f.setDuration(Duration.millis(1500));
        f.setNode(Panel);
        f.setFromValue(0.2);
        f.setToValue(1);
        f.play();
        t.setNode(Panel);
        t.play();
    }
}
