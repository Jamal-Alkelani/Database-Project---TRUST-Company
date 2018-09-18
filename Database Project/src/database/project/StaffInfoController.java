/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.project;

import DataBaseFun.Account;
import DataBaseFun.Admin;
import DataBaseFun.ConnectionDB;
import DataBaseFun.Staff;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author gamal
 */
public class StaffInfoController implements Initializable {


    @FXML
    private AnchorPane Panel;
    @FXML
    private TextField FNametxt;
    @FXML
    private TextField MNametxt;
    @FXML
    private TextField LNametxt;
    @FXML
    private TextField Addresstxt;
    @FXML
    private TextField HPhonetxt;
    @FXML
    private TextField Salarytxt;
    @FXML
    private TextField CPhonetxt;
    @FXML
    private TextField Emailtxt;
    @FXML
    private TextField Passwordtxt;
    @FXML
    private TextField IssueDate;
    @FXML
    private TextField ReferenceKeytxt;
    @FXML
    private DatePicker BirthDatePicker;   
    @FXML
    private JFXCheckBox MarriedCB;
    @FXML
    private JFXRadioButton MaleRB;
    @FXML
    private JFXRadioButton FemaleRB;
    @FXML
    private JFXButton Savebtn;
    @FXML
    private JFXButton ClearAllbtn;
    @FXML
    private Rectangle Searchbtn;
    @FXML
    private Rectangle Homebtn;
    @FXML
    private Rectangle ShowDBbtn;
    @FXML
    private Rectangle Settingsbtn;
    @FXML
    private Rectangle Logoutbtn;
    @FXML
    private Rectangle Closebtn;
    @FXML
    private Rectangle Minibtn;
    @FXML
    private Rectangle Backbtn;
    
    private ToggleGroup RBgroup ;
    
    public static TextField reftxt;
    
    private TextFieldValidator txtValidator=new TextFieldValidator();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       RBgroup= new ToggleGroup();
       MaleRB.setToggleGroup(RBgroup);
       FemaleRB.setToggleGroup(RBgroup);
       
       
          //Validate All components in the scene  
            //validate Strings
            txtValidator.validateTextFields(FNametxt,TextFieldValidator.STRING);
            txtValidator.validateTextFields(MNametxt,TextFieldValidator.STRING);
            txtValidator.validateTextFields(LNametxt,TextFieldValidator.STRING);
            //validate numbers
            txtValidator.validateTextFields(HPhonetxt,TextFieldValidator.NUMBER);
            txtValidator.validateTextFields(CPhonetxt,TextFieldValidator.NUMBER);
            txtValidator.validateTextFields(ReferenceKeytxt,TextFieldValidator.NUMBER);
             txtValidator.validateTextFields(Salarytxt,TextFieldValidator.NUMBER);
            //validate both
            txtValidator.validateTextFields(Addresstxt,TextFieldValidator.BOTH);
            txtValidator.validateTextFields(Emailtxt,TextFieldValidator.BOTH);
            txtValidator.validateTextFields(Passwordtxt,TextFieldValidator.BOTH);
            
            
            
            
       //set the referenceKey vlaue and set the current date
       reftxt=ReferenceKeytxt;
       
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       Date date = new Date();
       IssueDate.setText(dateFormat.format(date));

        
        
       ////IconHover effect
        AddHoverHandler();
        
        //ClearAll button Handling
        ClearAllbtn.setOnMouseClicked((MouseEvent e) -> {
            ClearAll();
            }); 
        
                        //Save  button Handling
        Savebtn.setOnMouseClicked((MouseEvent e) -> {
            JFXDialog jfxd=new JFXDialog();
            if(txtValidator.checkValidators()){
                jfxd.showDialog(Alert.AlertType.ERROR,"Error Message","You've made a mistake!",
                        "Oops are you sure you've filled all the required data correctly ?!");
            }
            else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Confirmation Dialog");
alert.setHeaderText("Save All Information");
alert.setContentText("You're going to save all the information you've entered, Once You saved it you'll not be able to UNDO it !");
Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
    //okay Code add staff dataBase
    String type;
    if(RBgroup.getSelectedToggle()==MaleRB)
        type="m";
        else
        type="f";
    int sa=Integer.valueOf(Salarytxt.getText());
    Staff staff=new Staff(ReferenceKeytxt.getText(),Emailtxt.getText(),FNametxt.getText(),"",MNametxt.getText(),LNametxt.getText(),type,Addresstxt.getText(),CPhonetxt.getText(),HPhonetxt.getText(),Passwordtxt.getText(),sa,"","");
    //AddStaff(Staff staff,Admin admin)
     ConnectionDB con=  HomePageController.connection;
     Account ac=HomePageController.account;
    con.AddStaff(staff, (Admin)HomePageController.account.getObject());
    
    
    ///--------
                            // Notification Status
                       Notifications notificationBuilder=Notifications.create()
                    .title("Save Completed")
                    .text("Your Informations have been saved")
                    .graphic(new ImageView("/Icons/Done.png"))
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.BOTTOM_RIGHT);
                     notificationBuilder.darkStyle();
                     notificationBuilder.show();
            ClearAll();
                     Node pp=ManagerHomePageController.panels.get(0).n;
             pp.getScene().getWindow().setWidth(1100);
             pp.getScene().getWindow().setHeight(570); 
            //Apply Transitions
            crateTransitionAnimation(pp,1000f,0f,600f);
            crateTransitionAnimation(Panel,0f,-2000f,600f);
            
} 
            }
            });
        
        //Minimze Button Handling       
        Minibtn.setOnMouseClicked((MouseEvent e) -> {
            Stage stage=(Stage) Minibtn.getScene().getWindow();
            stage.setIconified(true);
            });
        
        //Home Button Handling
        Homebtn.setOnMouseClicked((MouseEvent e) -> {
            Node node=null;
            
            ClearAll();
             SceneManager sm=new SceneManager();
             Stage stage=(Stage) Homebtn.getScene().getWindow();
             Pane root=(Pane) Homebtn.getScene().getRoot();            
              node=sm.LoadPanel(stage, 1100, 570, "ManagerHomePage.fxml",root);
              node.setScaleX(1f);
              node.setScaleY(1f);
            //Apply Transitions
             crateScaleAnimation(node,.0001f,1,600f);
             crateScaleAnimation(Panel,1f,.0001f,600f);

             node.getScene().getWindow().setWidth(1100);
             node.getScene().getWindow().setHeight(570);


            });
        
        
        //close button handling
        Closebtn.setOnMouseClicked((MouseEvent e)->{
        System.exit(0);
        });
        
        //back button handling
        Backbtn.setOnMouseClicked((MouseEvent e)->{
            //Apply Transitions
            ClearAll();
            crateTransitionAnimation(ManagerHomePageController.panels.get(0).n,-1000f,0,600f);
            crateTransitionAnimation(Panel,0f,2000f,600f);
             ManagerHomePageController.panels.get(0).n.getScene().getWindow().setWidth(1100);
             ManagerHomePageController.panels.get(0).n.getScene().getWindow().setHeight(570);
        });
       
        //Logout Button Handling
        Logoutbtn.setOnMouseClicked((MouseEvent e)->{
             SceneManager sm=new SceneManager();
             Stage stage=(Stage) Logoutbtn.getScene().getWindow();
             Pane root=(Pane) Logoutbtn.getScene().getRoot();
             Node node=sm.LoadPanel(stage, 842, 546, "Login.fxml",root);
             //reset All Panles
             resetPanels();
            //Apply Transitions
            crateScaleAnimation(node,.0001f,1,600f);
            crateScaleAnimation(Panel,1f,.0001f,600f);
        });
        
                //Show custmor Database Button Handling
        Searchbtn.setOnMouseClicked((MouseEvent e)->{
            SceneManager sm=new SceneManager();
            try {
                sm.LoadSceneDecorated("CustmorTableView.fxml", 1,false);
            } catch (Exception ex) {
                Logger.getLogger(ManagerHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //view  Database Button Handling
        ShowDBbtn.setOnMouseClicked((MouseEvent e)->{
            SceneManager sm=new SceneManager();
            try {
                sm.LoadSceneDecorated("CustmorTableView.fxml", 1,true);
            } catch (Exception ex) {
                Logger.getLogger(ManagerHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }    
    
    public void resetPanels(){
             HomePageController.panels.clear();
             HomePageController.CustmorActivated=false;
             HomePageController.CarSpecActivated=false;
             HomePageController.isManager=false;
             ManagerHomePageController.panels.clear();
             ManagerHomePageController.CarSpecActivated=false;
             ManagerHomePageController.CustmorActivated=false;
             ManagerHomePageController.StaffActivated=false;
    }
    
    void IconHoverFadeIn(Rectangle r){
          //Fadein Transition  
        FadeTransition f=new FadeTransition();
        f.setDuration(Duration.millis(500));
        f.setNode(r);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();
    }
    
    void IconHoverFadeOut(Rectangle r){
          //FadeOut Transition
        FadeTransition f=new FadeTransition();
        f.setDuration(Duration.millis(500));
        f.setNode(r);
        f.setFromValue(1);
        f.setToValue(0);
        f.play();
    }
    
    void AddHoverHandler(){
        
        Homebtn.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(Homebtn);
        });
         Homebtn.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(Homebtn);
        });
         
                 Searchbtn.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(Searchbtn);
        });
         Searchbtn.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(Searchbtn);
        });
         
                 ShowDBbtn.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(ShowDBbtn);
        });
         ShowDBbtn.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(ShowDBbtn);
        });
         
                 Settingsbtn.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(Settingsbtn);
        });
         Settingsbtn.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(Settingsbtn);
        });
         
                 Logoutbtn.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(Logoutbtn);
        });
         Logoutbtn.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(Logoutbtn);
        });
         
          Backbtn.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(Backbtn);
        });
         Backbtn.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(Backbtn);
        });
         
         Minibtn.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(Minibtn);
        });
         Minibtn.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(Minibtn);
        });
         
         Closebtn.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(Closebtn);
        });
         Closebtn.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(Closebtn);
        });
    }
    
    public void crateTransitionAnimation(Node n,float from,float to,float speed){
       //move left transition
        TranslateTransition t=new TranslateTransition();
        t.setDuration(Duration.millis(speed));
        t.setFromX(from);
        t.setToX(to);
        t.setNode(n);
        t.play();
    }
    
    public void crateScaleAnimation(Node n,float from,float to,float speed){
ScaleTransition t1=new ScaleTransition(Duration.millis(speed),n);
n.setLayoutX(0);
n.setLayoutY(0);
t1.setFromX(from);
t1.setFromY(from);
t1.setToX(to);
t1.setToY(to);
t1.play();
    }

    private void ClearAll() {
                    MarriedCB.setSelected(false);
            MaleRB.setSelected(false);
            FemaleRB.setSelected(false);
        //Validate All components in the scene
        for (Node node : Panel.getChildren()) {
            if (node instanceof TextField) {
           ((TextField) node).setText("");
    }
}
    }  
    
    
}
