package database.project;



import DataBaseFun.Staff;
import com.sun.prism.impl.Disposer;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;


public class StaffTableViewController implements Initializable {

    @FXML
    private TableView<Person_Staff> StaffTableView;
    @FXML
    private TableColumn<Person_Staff, String> col1;
    @FXML
    private TableColumn<Person_Staff, String> col2;
    @FXML
    private TableColumn<Person_Staff, String> col3;
    @FXML
    private TableColumn<Person_Staff, String> col4;
    @FXML
    private TableColumn<Person_Staff, String> col5;
    
    @FXML
    private TableColumn<Person_Staff, String> col6;
    @FXML
    private TableColumn<Person_Staff, String> col7;
    
    @FXML
    private TableColumn<Person_Staff, String> col8;
    @FXML
    private TableColumn<Person_Staff, String> col10;
    
    @FXML
    private TableColumn<Person_Staff, String> col11;
    @FXML
    private TableColumn<Person_Staff, String> col12;


    ObservableList <Person_Staff> persons=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setCellValueFacotory for all columns
        
       StaffTableView.setEditable(true);
         ArrayList<Staff> ins=HomePageController.connection.getStaffForAdmin(HomePageController.account.getSsn());
        //SetCellValueFactory for all columns
        if(persons!=null)
        for(int i=0;i<ins.size();i++)
        {
            persons.add(new Person_Staff(ins.get(i)));
        }
        if(persons==null)
            System.out.println("zaid");
        
          //Insert  delete Button
        TableColumn col_del = new TableColumn<>("Delete");
        StaffTableView.getColumns().add(col_del);
        
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
        
        HandleAllColumns();
        
        setCellValueFactoryForAllCloumns();
      //  setCellValueFactoryForAllCloumns();
        StaffTableView.setItems(persons);
        setCellFactoryForAllColumns();
        
       
 

    }    
    public void setCellValueFactoryForAllCloumns(){
               col1.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getSSN();
        });
        
        col2.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getFName();
        });
                
        col3.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getMName();
        });
        
        col4.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getLName();
        });
        
        col5.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getAddress();
        });
        
        col6.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getHomePhone();
        });
        
        col7.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getCellPhone();
        });
        
        col8.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getEmail();
        });

        col10.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getGender();
        });
        
        col11.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getSalary();
        });
        
        col12.setCellValueFactory((TableColumn.CellDataFeatures<Person_Staff, String> param) -> {
            return param.getValue().getDepartment();
        }); 
        
        
              
        
     
    }
    
    
    public void setCellFactoryForAllColumns() {
        //make the table fields editable
         
         col2.setCellFactory(TextFieldTableCell.forTableColumn());
         col3.setCellFactory(TextFieldTableCell.forTableColumn());
         col4.setCellFactory(TextFieldTableCell.forTableColumn());
         col5.setCellFactory(TextFieldTableCell.forTableColumn());
         col6.setCellFactory(TextFieldTableCell.forTableColumn());
         col7.setCellFactory(TextFieldTableCell.forTableColumn());
         col8.setCellFactory(TextFieldTableCell.forTableColumn());
         col10.setCellFactory(TextFieldTableCell.forTableColumn());
         col11.setCellFactory(TextFieldTableCell.forTableColumn());
         col12.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }
    public void addNewStaff(Person_Staff p){
     persons.add(p);
    StaffTableView.setItems(persons);
}    
    
private void updateTable(Person_Staff p){
       StaffTableView.setItems(persons);
    Staff staff=p.getStaff();
    HomePageController.connection.UpdateStaff(staff);
    //////////////هون الكود يلي رح تعدل فيه على الداتا بيس  
    ////////الاوبجكت يلي رح تستعملو انت custmor
}

  public void HandleAllColumns() {
        col2.setOnEditCommit(event -> {
            
            Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setFName(event.getNewValue());
             updateTable(person);
   
});
        
        col3.setOnEditCommit(event -> {
             Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setMName(event.getNewValue());
             updateTable(person);
   
});
        
        col4.setOnEditCommit(event -> {
             Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setLName(event.getNewValue());
             updateTable(person);
});
        
        col5.setOnEditCommit(event -> {
             Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setAddress(event.getNewValue());
             updateTable(person);
});
        
        col6.setOnEditCommit(event -> {
             Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setHomePhone(event.getNewValue());
             updateTable(person);
});
        
        col7.setOnEditCommit(event -> {
             Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setCellPhone(event.getNewValue());
             updateTable(person);
});
        
        col8.setOnEditCommit(event -> {
             Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setEmail(event.getNewValue());
             updateTable(person);
});
        

        
        col10.setOnEditCommit(event -> {
             Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setGender(event.getNewValue());
             updateTable(person);
});
        
                col11.setOnEditCommit(event -> {
             Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setSalary(event.getNewValue());
             updateTable(person);
});
                
                        col12.setOnEditCommit(event -> {
             Person_Staff x= event.getRowValue();
             Person_Staff person=persons.get( persons.indexOf(x));
             person.setDepartmentNo(event.getNewValue());
             updateTable(person);
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
                	Person_Staff currentPerson = (Person_Staff) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                        HomePageController.connection.DeleteStaff(currentPerson.getStaff());
                       for(int i=0;i<persons.size();i++)
                        {
                            if(persons.get(i).getSSN().equals(currentPerson.getSSN()))
                             {
                                 persons.remove(persons.get(i));
                                   break;
                              }
                	
                    }
                	persons.remove(currentPerson);
                    }
                    
                    else {
                       SceneManager sm=new SceneManager();
                        try {
                            sm.LoadSceneDecorated("CarSpecTableView.fxml", 1f,false);
                        } catch (Exception ex) {
                           Logger.getLogger(CustmorTableViewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            });
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
