
package database.project;

import DataBaseFun.*;
import com.jfoenix.controls.JFXButton;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

public class HomePageController implements Initializable {

    @FXML
    private AnchorPane Settings;
    @FXML
    private AnchorPane About;
    @FXML
    private AnchorPane ViewDB;
    @FXML
    private AnchorPane GenGraph;
    @FXML
    private AnchorPane BackupDB;
    @FXML
    private AnchorPane GenReport;
    @FXML
    private AnchorPane AddCustmor;
    @FXML
    private AnchorPane Find_Replace;
    @FXML
    AnchorPane Panel;
    @FXML
    Rectangle close,min;
    public static boolean isManager;
    public static boolean CustmorActivated,CarSpecActivated;
     @FXML
    private JFXButton Popup;
    
    
     private ContextMenu contextMenue;
    
    
    public static ArrayList <Node> panels =new ArrayList <Node>();

    public static  Account account=null;
    
    public static ConnectionDB connection=new ConnectionDB();
    
    public static Customer customer;
    
   public static Insurance insurance;
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
contextMenue=new ContextMenu(new MenuItem("Logout"));
       contextMenue.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              SceneManager sm=new SceneManager();
             Stage stage=(Stage) Popup.getScene().getWindow();
             Pane root=(Pane) Popup.getScene().getRoot();
             Node node=sm.LoadPanel(stage, 842, 546, "Login.fxml",root);
             //Reset All Panles
             resetPanels();
            //Apply Transitions
            crateScaleAnimation(node,.0001f,1,600f);
            crateScaleAnimation(Panel,1f,.0001f,600f);
           }
       });
       Popup.setOnMouseClicked((MouseEvent e)->{
           contextMenue.show(Panel, e.getScreenX(), e.getScreenY());
       });
        
        if(panels.isEmpty())
            panels.add(Panel);
        
        
        AddHoverHandler();
        //min button handling
         min.setOnMouseClicked((MouseEvent e) -> {
            Stage stage=(Stage) min.getScene().getWindow();
            stage.setIconified(true);
            });
        
        
        //close button handling
        close.setOnMouseClicked((MouseEvent e)->{
            System.exit(0);
        });
        
        //Add Custmor Handling
         AddCustmor.setOnMouseClicked((MouseEvent e)->{
             
             if(!CustmorActivated){
             SceneManager sm=new SceneManager();
             Stage stage=(Stage) AddCustmor.getScene().getWindow();
             Pane root=(Pane) AddCustmor.getScene().getRoot();
             Node node=sm.LoadPanel(stage, 1115, 472, "CustmorInfo.fxml",root);
             panels.add(node);
             
             //Apply Transitions
             crateTransitionAnimation(node,1000f,0f,600f);
             crateTransitionAnimation(Panel,0f,-2000f,600f);
             CustmorActivated=true;
             }
             else{
             //Apply Transitions
             panels.get(1).setScaleX(1);
             panels.get(1).setScaleY(1);
             crateTransitionAnimation(panels.get(1),1000f,0f,600f);
             crateTransitionAnimation(Panel,0f,-2000f,600f);
             }
             panels.get(0).getScene().getWindow().setWidth(1115);
             panels.get(0).getScene().getWindow().setHeight(472);
             //generate referencekeyx
             String x=null;
              
             while(true)
             {
             x=new Random_Refrence_Generator().generate();
             if(!connection.isRefKey(x))
             {
             CustmorInfoController.reftxt.setText(x);
             CustmorInfoController.refClear.fire();
             return;
             }
             }
             
        });

         
         //About button Handling
        About.setOnMouseClicked((MouseEvent e)->{

            SceneManager sm=new SceneManager();
            try {
                sm.LoadScene("About.fxml", 1);
            } catch (Exception ex) {
                Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }                                       
        });
        
        BackupDB.setOnMouseClicked((MouseEvent e)->{
            SceneManager sm=new SceneManager();
            try {
                sm.LoadScene("Backups.fxml", 1);
            } catch (Exception ex) {
                Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Show custmor Database Button Handling
        Find_Replace.setOnMouseClicked((MouseEvent e)->{
            SceneManager sm=new SceneManager();
            try {
                sm.LoadSceneDecorated("CustmorTableView.fxml", 1,false);
            } catch (Exception ex) {
                Logger.getLogger(ManagerHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //view  Database Button Handling
        ViewDB.setOnMouseClicked((MouseEvent e)->{
            SceneManager sm=new SceneManager();
            try {
                sm.LoadSceneDecorated("CustmorTableView.fxml", 1,true);
            } catch (Exception ex) {
                Logger.getLogger(ManagerHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
         //Generate Graph handling
        GenGraph.setOnMouseClicked((MouseEvent e)->{
            SceneManager sm=new SceneManager();
            try {
                sm.LoadSceneDecorated("Graph.fxml", 1,false);
            } catch (Exception ex) {
                Logger.getLogger(ManagerHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
                 //Generate Graph handling
        GenReport.setOnMouseClicked((MouseEvent e)->{
            
            TextInputDialog d=new TextInputDialog();
            d.setTitle("Text Dialog");
            d.setHeaderText("Please Enter ID Custmor");
           String text=null; 
           Optional<String> res=d.showAndWait();
           if(res.isPresent()){
               text=res.get();
           
                    ConnectionDB con= HomePageController.connection;
        InputStream in;
        JasperDesign jd;
        JasperReport jrep;
        JasperPrint jp;
        con.startConnection();
        JFrame frame=new JFrame("Report");
        try
        {
           ///---- jd=JRXmlLoader.load("src\\staffrep\\Simple_Blue.jrxml");
            jd=JRXmlLoader.load("src\\report2\\Simple_Blue.jrxml");
            String sql="select customer.IDNUMBERC,customer.FNAMEC,customer.MNAMEC,customer.LNAMEC,customer.ADDRESS,customer.CELLPHONEC,customer.HOMEPHONEC,customer.BIRTHDATEC " +
                       ",customer.SEXC,insurance.DOSI,insurance.DOEI,insurance.PLATENO,insurance.REFRENCEKEYCUST " +
 
                            "from customer,insurance where  " +
                            "customer.IDNUMBERC='"+text+"' " +//9855675
                            "and  " +
                            "customer.REFRENCEKEY=insurance.REFRENCEKEYCUST " ;
                           /* "and  " +
                            "staff.SSNFORSTAFF='XXX-XXX'";*/
            JRDesignQuery newq=new JRDesignQuery();
            newq.setText(sql);
             jd.setQuery(newq);
            jrep=JasperCompileManager.compileReport(jd);
            
            // System.out.println("sdssdsd");
             jp=JasperFillManager.fillReport(jrep,null,con.getCon());
             
            /*
            File f=new File("Simple_Blue.jrxml");
        in=new FileInputStream(f);
        System.out.print("22222222222");
        jd=JRXmlLoader.load(in);
        System.out.print("111111111");
        jrep=JasperCompileManager.compileReport(jd);
        jp=JasperFillManager.fillReport(jrep,null,con.getCon());
            */
          //System.out.println("zaid");
         
         frame.getContentPane().add(new JRViewer(jp));
         frame.pack();
         frame.setVisible(true);
         frame.setSize(800,600);
         con.endConnection();
         //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
        } catch (JRException ex) {
             //frame.setVisible(false);
        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
    }
           }
        });
        
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

    void IconHoverFadeIn(Node n){
       //Fadein Transition  
        FadeTransition f=new FadeTransition();
        f.setDuration(Duration.millis(500));
        f.setNode(n);
        f.setFromValue(0.9);
        f.setToValue(1);
        f.play();
        n.setStyle("-fx-background-color: #b3e0ff");
    }
    
    void IconHoverFadeOut(Node n){
          //FadeOut Transition
          
        FadeTransition f=new FadeTransition();
        f.setDuration(Duration.millis(500));
        f.setNode(n);
        f.setFromValue(1);
        f.setToValue(.9);
        f.play();
        n.setStyle("-fx-background-color: #ffffff");
        
    }
    
    private void AddHoverHandler() {
       close.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(close);
        });
         close.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(close);
        });
         
               min.setOnMouseEntered((MouseEvent e)->{
        IconHoverFadeIn(min);
        });
         min.setOnMouseExited((MouseEvent e)->{
        IconHoverFadeOut(min);
        });
         
         Settings.setOnMouseEntered((MouseEvent e)->{
         IconHoverFadeIn(Settings);
        });

         Settings.setOnMouseExited((MouseEvent e)->{
         IconHoverFadeOut(Settings);              
        });
         
         About.setOnMouseEntered((MouseEvent e)->{
         IconHoverFadeIn(About);
        });

         About.setOnMouseExited((MouseEvent e)->{
         IconHoverFadeOut(About);              
        });
         
         ViewDB.setOnMouseEntered((MouseEvent e)->{
         IconHoverFadeIn(ViewDB);
        });

         ViewDB.setOnMouseExited((MouseEvent e)->{
         IconHoverFadeOut(ViewDB);              
        });
         
         GenGraph.setOnMouseEntered((MouseEvent e)->{
         IconHoverFadeIn(GenGraph);
        });

         GenGraph.setOnMouseExited((MouseEvent e)->{
         IconHoverFadeOut(GenGraph);              
        });
         
         BackupDB.setOnMouseEntered((MouseEvent e)->{
         IconHoverFadeIn(BackupDB);
        });

         BackupDB.setOnMouseExited((MouseEvent e)->{
         IconHoverFadeOut(BackupDB);              
        });
         
         GenReport.setOnMouseEntered((MouseEvent e)->{
         IconHoverFadeIn(GenReport);
        });

         GenReport.setOnMouseExited((MouseEvent e)->{
         IconHoverFadeOut(GenReport);              
        });
         
         AddCustmor.setOnMouseEntered((MouseEvent e)->{
         IconHoverFadeIn(AddCustmor);
        });

         AddCustmor.setOnMouseExited((MouseEvent e)->{
         IconHoverFadeOut(AddCustmor);              
        });
        
                 
         Find_Replace.setOnMouseEntered((MouseEvent e)->{
         IconHoverFadeIn(Find_Replace);
        });

         Find_Replace.setOnMouseExited((MouseEvent e)->{
         IconHoverFadeOut(Find_Replace);              
        });   
    }
    
    public Pane getPanel(){
        return Panel;
    }
    public void crateTransitionAnimation(Node n,float from,float to,float speed){
       //move left/Right transition
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
}
