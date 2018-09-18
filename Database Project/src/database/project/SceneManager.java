
package database.project;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneManager extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoadScene("Login.fxml",.95f);
    }
    
    
        
    public void LoadScene(String fxmlName,float opacity) throws Exception{
       Pane root=new Pane();
       FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource(fxmlName));
       root.getChildren().add(fxmlloader.load());
       Scene scene=new Scene(root);
       Stage stage=new Stage(); 
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.setOpacity(opacity);
       stage.show();
    }
    
        public void LoadSceneDecorated(String fxmlName,float opacity,boolean custmoSize) throws Exception{
       Pane root=new Pane();
       FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource(fxmlName));
       root.getChildren().add(fxmlloader.load());
       Scene scene=new Scene(root);
       Stage stage=new Stage(); 
       stage.setScene(scene);
       stage.initStyle(StageStyle.DECORATED);
       stage.setOpacity(opacity);
       if(custmoSize)
           stage.setHeight(658);
       //stage.setResizable(false);
       stage.show();
    }
    
    public void LoadScene(String fxmlName,Scene scene,float opacity) throws Exception{
       Pane root=new Pane();
       FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource(fxmlName));
       root.getChildren().add(fxmlloader.load());
       Stage stage=new Stage();
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.setOpacity(opacity);
       stage.show();
       
 
    }


    public Node LoadPanel(Stage stage,float W,float H,String fxmlName,Pane root){
        Node node = null;
        stage.setWidth(W);
        stage.setHeight(H);
        try{
        //get AnchorPane of fxml File
        node=(AnchorPane) FXMLLoader.load(getClass().getResource(fxmlName)); 
        // Add AnchorPane to the current scene
       root.getChildren().add(node);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return node;
    }
    
}
