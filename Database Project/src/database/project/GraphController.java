/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.project;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author gamal
 */
public class GraphController implements Initializable {

    @FXML
    private PieChart PieChart;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> pieChartDate=FXCollections.observableArrayList();
        
        pieChartDate.add(new PieChart.Data("# of Staffs",40));
        pieChartDate.add(new PieChart.Data("# of Custmors",50));
        PieChart.setData(pieChartDate);
        pieChartDate.add(new PieChart.Data("# of Cars",420));
        
        PieChart.setData(pieChartDate);
        PieChart.setStartAngle(90);
        PieChart.setAnimated(true);
        
    btn.setOnMouseClicked((MouseEvent e)->{
            
      pieChartDate.add(new PieChart.Data("# of Custmors",50));
      PieChart.setData(pieChartDate);
        });
    } 
    
}
