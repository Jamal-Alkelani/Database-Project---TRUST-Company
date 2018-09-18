
package database.project;

import DataBaseFun.Insurance;
import Email.EmailMessage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.teknikindustries.bulksms.SMS;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.Notifications;


public class CarSpecController implements Initializable {

    @FXML
    Rectangle Homebtn;

    @FXML
    Rectangle Searchbtn,ShowDBbtn,Settingsbtn,Logoutbtn,Backbtn,Minibtn,Closebtn;
    @FXML
    AnchorPane Panel;
    @FXML
    JFXButton ClearAllbtn,Savebtn;
    @FXML
    private ComboBox ColorCombobox;
    
    private String[] colors={"Blue","Red","Green","Black","Orange","Purple ","White","Silver ","turquoise","Gold","Brown","Yellow","chrome","Pink","Lavender","orangey red","Dark stone grey","Baby Blue"};
    @FXML
    private TextField Licensetxt;
    @FXML
    private TextField Chassistxt;
    @FXML
    private TextField PlateNotxt;
    @FXML
    private TextField FuelTypetext;
    @FXML
    private TextField Enginetxt;
    @FXML
    private TextField Purchasetxt;
    @FXML
    private TextField CarBrandtxt;
    @FXML
    private TextField Modeltxt;
    @FXML
    private TextField Manuftxt;
    @FXML
    private TextField NoOfDoorstxt;
    @FXML
    private TextField LicCategorytxt;
    @FXML
    private TextField PrevAccidentstxt;
    @FXML
    private TextField Weighttxt;
    @FXML
    private TextField Powertxt;
    @FXML
    private JFXCheckBox AlarmCB;
    @FXML
    private JFXCheckBox TurboCB;
    @FXML
    private TextField Passengerstxt;
    @FXML
    private TextArea AddInfotxt;
    @FXML
    private TextField ReferenceKeytxt;
    @FXML
    private TextField IssueDate;
    @FXML
    private TextField Costtext;
    @FXML
    private MaskerPane Masker;
public static TextField refKey;
    private TextFieldValidator txtValidator=new TextFieldValidator();
        
    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
          Masker.setVisible(false);
        }
  };
    
  Timer t=new Timer(1000, taskPerformer);
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ValidationSupport validation=new ValidationSupport(); 
       // ReferenceKeytxt.setText(CustmorInfoController.ReferenceKeytxt.getText());
        ColorCombobox.getItems().addAll(colors);
        //set the ReferenceKey txt value and setting up the date value
        ReferenceKeytxt.setText(CustmorInfoController.reftxt.getText());
               DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       Date date = new Date();
       IssueDate.setText(dateFormat.format(date)); 

       refKey=ReferenceKeytxt;
        ////IconHover effect    
        AddHoverHandler();
        
        t.setRepeats(false);
        //Validate TextFields in the scene  
            //validate Strings
            txtValidator.validateTextFields(LicCategorytxt,TextFieldValidator.STRING);
            //validate numbers
            txtValidator.validateTextFields(NoOfDoorstxt,TextFieldValidator.NUMBER);
            txtValidator.validateTextFields(Weighttxt,TextFieldValidator.NUMBER);
            txtValidator.validateTextFields(Powertxt,TextFieldValidator.NUMBER);
            txtValidator.validateTextFields(Licensetxt,TextFieldValidator.NUMBER);
            txtValidator.validateTextFields(Chassistxt,TextFieldValidator.NUMBER);
            txtValidator.validateTextFields(Modeltxt,TextFieldValidator.NUMBER);
            txtValidator.validateTextFields(Manuftxt,TextFieldValidator.NUMBER);
            txtValidator.validateTextFields(Costtext,TextFieldValidator.NUMBER);
            //validate Both
            txtValidator.validateTextFields(PlateNotxt,TextFieldValidator.BOTH);
            txtValidator.validateTextFields(PrevAccidentstxt,TextFieldValidator.BOTH);
            txtValidator.validateTextFields(Enginetxt,TextFieldValidator.BOTH);
            txtValidator.validateTextFields(FuelTypetext,TextFieldValidator.BOTH);
            txtValidator.validateTextFields(Purchasetxt,TextFieldValidator.BOTH);
            txtValidator.validateTextFields(CarBrandtxt,TextFieldValidator.BOTH);
            txtValidator.validateTextFields(Passengerstxt,TextFieldValidator.BOTH);
            
        //validate comboBoxes in the scene
        txtValidator.validateComboBoxes(ColorCombobox);
        

                
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
   
Optional<ButtonType> result = jfxd.showDialog(AlertType.WARNING,"Confirmation Dialog","Save All Information",
        "You're going to save all the information you've entered, Once You saved it you'll not be able to UNDO it !");
    
try{

if (result.get() == ButtonType.OK){
    
    MaskerPane masker=new MaskerPane();
    Masker=masker;
    masker.setLayoutX(0);
    masker.setLayoutY(0);
    
    Pane x=(Pane)this.Panel.getScene().getRoot();
    x.getChildren().add(masker);
    masker.setVisible(true);
    t.start();
    
    // data bace code cust
    String endy;
    String h[]=IssueDate.getText().split("/");
    int y=Integer.valueOf(h[0]);
         endy=""+(y+1)+"/"+h[1]+"/"+h[2];
         String alsrm,Turbo;
         if(AlarmCB.isSelected())
             alsrm="1";
         else
             alsrm="0";
             if(TurboCB.isSelected())
                 Turbo="1";
             else
                 Turbo="0";
        // Passengerstxt
       System.out.println(Purchasetxt.getText());
    HomePageController.insurance=new Insurance(
            IssueDate.getText(),endy,Integer.valueOf(Costtext.getText()),ReferenceKeytxt.getText(),Chassistxt.getText()
            ,Enginetxt.getText(),PlateNotxt.getText(),FuelTypetext.getText(),Licensetxt.getText()
            ,Purchasetxt.getText(),CarBrandtxt.getText(),Modeltxt.getText(),Integer.valueOf(Manuftxt.getText())
            ,Integer.valueOf(NoOfDoorstxt.getText()),LicCategorytxt.getText(),PrevAccidentstxt.getText()
            ,Integer.valueOf(Weighttxt.getText()),Integer.valueOf(Powertxt.getText()),Turbo,alsrm
            , ColorCombobox.getSelectionModel().getSelectedItem().toString());
  //  System.out.println(":::::::::::::::::::::::"+ColorCombobox.getSelectionModel().getSelectedItem().toString());
            //ColorCombobox.getSelectionModel().getSelectedItem().toString();
            //Edit VVV
            boolean flag=false;
           /* try
            {
    HomePageController.connection.AddCustomer(HomePageController.customer);
    flag=true;
    HomePageController.connection.AddInsurance(HomePageController.insurance);
            }
            catch(Exception jkk)
            {
                if(flag==true)
               HomePageController.connection.DeleteCustomer(HomePageController.customer);
            }*/
           
          HomePageController.insurance.setRefKey(HomePageController.customer.getRefKey());
          if(HomePageController.connection.addCustomerAndInsurance(HomePageController.customer, HomePageController.insurance))
          {    
              //-----------------------
              
              String Mess=
                         "Welcome to Trust International Insurance Company,"
                         + " Your info had been added successfulyy (Be Life Confident)";
              if(HomePageController.customer.getSex().equals("m"))
                        Mess="Dear Sir "+Mess;
              else
                      Mess="Dear Madam "+Mess;
            
              //EmailMessage.SendMessage(HomePageController.customer.getEmail(), "J&Z", Mess);
               SMS s=new SMS();
                 
           
       
              //Send SMS Message to added user
                 
                //  s.SendSMS("Jamal_Alkelani", "jojo20155",Mess, "97"+HomePageController.customer.getCellPhone(), "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
   
          
               
               
               
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
                     //Apply Transitions
                Node pp=null;
                if(HomePageController.isManager){
                    pp=ManagerHomePageController.panels.get(0).n;
                    crateTransitionAnimation(pp,1000f,0f,600f);
                    crateTransitionAnimation(Panel,0f,-2000f,600f);
                    pp.getScene().getWindow().setWidth(1100);
                    pp.getScene().getWindow().setHeight(570);
                }
                else
                {
                    pp=HomePageController.panels.get(0);
                    crateTransitionAnimation(pp,1000f,0f,600f);
                    crateTransitionAnimation(Panel,0f,-2000f,600f);
                    pp.getScene().getWindow().setWidth(999);
                    pp.getScene().getWindow().setHeight(570);
                }
                
          }
          else
          {  
              JFXDialog jfxdoalog=new JFXDialog();
              jfxdoalog.showDialog(AlertType.WARNING, "Warning","Error Ocuured", "Please make sure that you've"
                      + "entered the inofrmation coreectly !");
          
          }
   // HomePageController.connection.addCustomerAndInsurance(HomePageController.customer,HomePageController.insurance);
   
        
   
   
   
    
            

}
}
catch(Exception NoSuchElementException){
    
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
            CustmorInfoController.refClear.fire();
            ClearAll();
            Node pp;
            //Apply Transitions
             SceneManager sm=new SceneManager();
             Stage stage=(Stage) Homebtn.getScene().getWindow();
             Pane root=(Pane) Homebtn.getScene().getRoot();
             Node node;
             if(HomePageController.isManager){
              node=sm.LoadPanel(stage, 1100, 570, "ManagerHomePage.fxml",root);
              pp=node;

             }
             else{
                  node=sm.LoadPanel(stage, 999, 570, "HomePage.fxml",root);
                  HomePageController.panels.remove(0);
                  HomePageController.panels.add(0, node);
                  pp=node;
             }
             

             

             crateScaleAnimation(pp,.0001f,1,600f);
             crateScaleAnimation(Panel,1f,.0001f,600f);

             //panels.get(0).getScene().getWindow().setWidth(999);
             //panels.get(0).getScene().getWindow().setHeight(570);


            });
        
        
        //close button handling
        Closebtn.setOnMouseClicked((MouseEvent e)->{
        System.exit(0);
        });
        
        //back button handling
        Backbtn.setOnMouseClicked((MouseEvent e)->{
            Node pp=null;
            //Apply Transitions
            if(HomePageController.isManager){
                for(ScenePanels ele:ManagerHomePageController.panels)
                    if(ele.s.compareTo("CustmorInfo")==0){
                        pp=ele.n;
                    }
            }
            else{
                pp=HomePageController.panels.get(1);
            }
            
            crateTransitionAnimation(pp,-1000f,0,600f);
            crateTransitionAnimation(Panel,0f,2000f,600f);
            pp.getScene().getWindow().setWidth(1115);
            pp.getScene().getWindow().setHeight(472);
        });
       
        //Logout Button Handling
        Logoutbtn.setOnMouseClicked((MouseEvent e)->{
             SceneManager sm=new SceneManager();
             Stage stage=(Stage) Logoutbtn.getScene().getWindow();
             Pane root=(Pane) Logoutbtn.getScene().getRoot();
             Node node=sm.LoadPanel(stage, 842, 546, "Login.fxml",root);
             //Reset All Panles
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
    
    
    public ArrayList <TextField> getAllTextFields(){
        ArrayList <TextField> arr=new ArrayList<TextField>();
        for(Node node:Panel.getChildren())
        {
            if(node instanceof TextField)
            {
                arr.add((TextField) node);
            }
        }
        
        
        return arr;
               
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
t1.setFromX(from);
t1.setFromY(from);
t1.setToX(to);
t1.setToY(to);
t1.play();
    }

    private void ClearAll() {
                    TurboCB.setSelected(false);
            AlarmCB.setSelected(false);
        //Clear All components in the scene
       for (Node ele : Panel.getChildren()) {
            if (ele instanceof TextField) {
                if(!(ele.getId().compareTo("IssueDate")==0 || ele.getId().compareTo("ReferenceKeytxt")==0))
                ((TextField) ele).setText("");
    }
}
        
    }

   
    
}
