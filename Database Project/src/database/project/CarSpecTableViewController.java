/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package database.project;

import DataBaseFun.Insurance;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import static database.project.CustmorTableViewController.ref;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;


public class CarSpecTableViewController implements Initializable {

    @FXML
    private TableView<Car_Spec> CarSpecTableView;
    @FXML
    private TableColumn<Car_Spec, String> col1;
     @FXML
    private TableColumn<Car_Spec, String> col14;
    @FXML
    private TableColumn<Car_Spec, String> col15;
    @FXML
    private TableColumn<Car_Spec, String> col16;
    @FXML
    private TableColumn<Car_Spec, String> col17;
    @FXML
    private TableColumn<Car_Spec, String> col18;
    @FXML
    private TableColumn<Car_Spec, String> col19;
    @FXML
    private TableColumn<Car_Spec, String> col20;
    @FXML
    private TableColumn<Car_Spec, String> col21;
    @FXML
    private TableColumn<Car_Spec, String> col22;
    @FXML
    private TableColumn<Car_Spec, String> col23;
    @FXML
    private TableColumn<Car_Spec, String> col24;
    @FXML
    private TableColumn<Car_Spec, String> col25;
    @FXML
    private TableColumn<Car_Spec, String> col26;
    @FXML
    private TableColumn<Car_Spec, String> col27;
    @FXML
    private TableColumn<Car_Spec, String> col28;
    @FXML
    private TableColumn<Car_Spec, String> col29;
    @FXML
    private TableColumn<Car_Spec, String> col30;
    @FXML
    private TableColumn<Car_Spec, String> col32;
    @FXML
    private TableColumn<Car_Spec, String> col33;
    @FXML
    private TableColumn<Car_Spec, String> col34;
    @FXML
    private JFXTextField SearchFor;
  
    
    ObservableList <Car_Spec> Cars= FXCollections.observableArrayList();
    
@Override
    public void initialize(URL url, ResourceBundle rb) {
        
        CarSpecTableView.setEditable(true);

        Car_Spec a;
        
        ArrayList<Insurance> ins=HomePageController.connection.getInsuranceForCustomer(CustmorTableViewController.ref);
        //SetCellValueFactory for all columns
        for(int i=0;i<ins.size();i++)
        {
            Cars.add(new Car_Spec(ins.get(i)));
        }
        System.out.println(":::"+ Cars.size());
        setCellValueFactoryForAllCloumns();
        CarSpecTableView.setItems(Cars);
        //setCellFactory for all cloumns
        setCellFactoryForAllColumns();
        
   
        
        ////////////////Filter //////////////////
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList <Car_Spec> filteredData = new FilteredList<>(Cars, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        SearchFor.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(car -> {
                // If filter text is empty, display all Cars.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // compare all the data
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (car.getReferenceKey().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if(car.getLicenseNo().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getChassisNo().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getPlateNo().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getEngineNo().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getFuelType().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getPurchase().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getCarBrand().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getModel().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getManufYear().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getNoOfDoors().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getLicCategory().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getPrevAccidents().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getWeight().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getPower().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getColor().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getAlarm().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getTurbo().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getDOSI().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getDOEI().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(car.getInsuranceCost().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                }

                return false; // Does not match.
            });
            
                    // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Car_Spec> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(CarSpecTableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        CarSpecTableView.setItems(sortedData);
        });

          // Add columns event hanlding for all
        HandleAllColumns();

}

    
    public void setCellValueFactoryForAllCloumns(){
        col1.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getReferenceKey();
        });
     
        /* OR
        col1.setCellValueFactory(cellData -> cellData.getValue().getReferenceKey());
        */

        
        col14.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getLicenseNo();
        });
        
        col15.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getChassisNo();
        });
        
        col16.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getPlateNo();
        });
        
        col17.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getFuelType();
        });
        
        
        col18.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getEngineNo();
        });
        
        col19.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getPurchase();
        });
        
        col20.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getCarBrand();
        });
        
        col21.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getModel();
        });
        
        col22.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getManufYear();
        });
        
        col23.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getNoOfDoors();
        });
        
        col24.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getLicCategory();
        });
        
        col25.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getPrevAccidents();
        });
        
        col26.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getWeight();
        });
        
        col27.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getPower();
        });
        
        col28.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getColor();
        });
        
        col29.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getAlarm();
        });
        
        col30.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getTurbo();
        });
        
        col32.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getInsuranceCost();
        });
        
                col33.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getDOSI();
        });
                
                        col34.setCellValueFactory((TableColumn.CellDataFeatures<Car_Spec, String> param) -> {
            return param.getValue().getDOEI();
        });
 
                         //Insert  delete Button
        TableColumn col_del = new TableColumn<>("Delete");
        CarSpecTableView.getColumns().add(col_del);
        
        col_del.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_del.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCell("Delete");
            }
        
        });
        
    }

    
    public void addNewCustmor(Car_Spec p){
     Cars.add(p);
     CarSpecTableView.setItems(Cars);
}    
    
private void updateTable(Car_Spec c){
    CarSpecTableView.setItems(Cars);
    Insurance inc=c.getInsurance();
    System.out.println("plate is :"+inc.getPlateNumber()+"--------------------------------------");
    HomePageController.connection.updateInsurance(inc);
    //Person_Custmor custmor=c.getInsurance();
    //غير وحدث هاد
    
}

    public void setCellFactoryForAllColumns() {
        //make the table fields editable

         col14.setCellFactory(TextFieldTableCell.forTableColumn());
         col15.setCellFactory(TextFieldTableCell.forTableColumn());
         col16.setCellFactory(TextFieldTableCell.forTableColumn());
         col17.setCellFactory(TextFieldTableCell.forTableColumn());
         col18.setCellFactory(TextFieldTableCell.forTableColumn());
         col19.setCellFactory(TextFieldTableCell.forTableColumn());
         col20.setCellFactory(TextFieldTableCell.forTableColumn());
         col21.setCellFactory(TextFieldTableCell.forTableColumn());
         col22.setCellFactory(TextFieldTableCell.forTableColumn());
         col23.setCellFactory(TextFieldTableCell.forTableColumn());
         col24.setCellFactory(TextFieldTableCell.forTableColumn());
         col25.setCellFactory(TextFieldTableCell.forTableColumn());
         col26.setCellFactory(TextFieldTableCell.forTableColumn());
         col27.setCellFactory(TextFieldTableCell.forTableColumn());
         col28.setCellFactory(TextFieldTableCell.forTableColumn());
         col29.setCellFactory(TextFieldTableCell.forTableColumn());
         col30.setCellFactory(TextFieldTableCell.forTableColumn());
         col32.setCellFactory(TextFieldTableCell.forTableColumn());
         col33.setCellFactory(TextFieldTableCell.forTableColumn());
         col34.setCellFactory(TextFieldTableCell.forTableColumn());
    }
    

   
public void HandleAllColumns() {
    

        col14.setOnEditCommit(event -> {
            
            Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setLicenseNo(event.getNewValue());
             updateTable(car);
   
});
        
        col15.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setChassisNo(event.getNewValue());
             updateTable(car);
   
});
        /*
        col16.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setPlateNo(event.getNewValue());
             updateTable(car);
});
*/
        
        col17.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setFuelType(event.getNewValue());
             updateTable(car);
});
        
        col18.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setEngineNo(event.getNewValue());
             updateTable(car);
});
        
        col19.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setPurchase(event.getNewValue());
             updateTable(car);
});
        
        col20.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setCarBrand(event.getNewValue());
             updateTable(car);
});
        
        col21.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setModel(event.getNewValue());
             updateTable(car);
});
        
        col22.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setManufYear(event.getNewValue());
             updateTable(car);
});
        
        col23.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setNoOfDoors(event.getNewValue());
             updateTable(car);
             
   
});
        
        col24.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setLicCategory(event.getNewValue());
             updateTable(car);
             
   
});
        
        col25.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setPrevAccidents(event.getNewValue());
             updateTable(car);
             
   
});
        
        col26.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setWeight(event.getNewValue());
             updateTable(car);
             
   
});
        
        col27.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setPower(event.getNewValue());
             updateTable(car);
             
   
});
        
        col28.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setColor(event.getNewValue());
             updateTable(car);
             
   
});
        
        col29.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setAlarm(event.getNewValue());
             updateTable(car);
             
   
});
        
        col30.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setTurbo(event.getNewValue());
             updateTable(car);
             
   
});

        col32.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setInsuranceCost(event.getNewValue());
             updateTable(car);
             
   
});
        
        col33.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setDOSI(event.getNewValue());
             updateTable(car);
             
   
});
        
        col34.setOnEditCommit(event -> {
             Car_Spec x= event.getRowValue();
             Car_Spec car=Cars.get( Cars.indexOf(x));
             car.setDOEI(event.getNewValue());
             updateTable(car);
             
   
});
             
    }

    //Define the button cell
    private class ButtonCell extends TableCell<Disposer.Record, Boolean> {
        Button cellButton;

        String ac;
        ButtonCell(String ac){
            this.ac=ac;
              cellButton = new Button(ac);
        	//Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    
                    if(ac.compareTo("Delete")==0){
                        // get Selected Item
                	Car_Spec currentPerson = (Car_Spec) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                	HomePageController.connection.DeleteInsurance(currentPerson.getInsurance());
                       for(int i=0;i<Cars.size();i++)
                        {
                            if(Cars.get(i).getPlateNo().equals(currentPerson.getPlateNo()))
                             {
                                 Cars.remove(Cars.get(i));
                                   break;
                              }
                	
                    }
                   
                    
                }
                
            }});
        }
                    

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if(!empty){
        setGraphic(cellButton);
        }
        else{
        setGraphic(null);
             }
    }
    }

}
