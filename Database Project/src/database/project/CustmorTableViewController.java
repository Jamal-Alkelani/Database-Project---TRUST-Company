
package database.project;

import com.teknikindustries.bulksms.SMS;
import DataBaseFun.Customer;
import Email.EmailMessage;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer.Record;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javax.swing.JOptionPane;


public class CustmorTableViewController implements Initializable {

    @FXML
    private TableView <Person_Custmor> CustmorTableView;
    @FXML
    private TableColumn<Person_Custmor, String> col1;
    @FXML
    private TableColumn<Person_Custmor, String> col2;
    @FXML
    private TableColumn<Person_Custmor, String> col3;
    @FXML
    private TableColumn<Person_Custmor, String> col4;
    @FXML
    private TableColumn<Person_Custmor, String> col5;
    
    @FXML
    private TableColumn<Person_Custmor, String> col6;
    @FXML
    private TableColumn<Person_Custmor, String> col7;
    
    @FXML
    private TableColumn<Person_Custmor, String> col8;
    @FXML
    private TableColumn<Person_Custmor, String> col9;
    @FXML
    private TableColumn<Person_Custmor, String> col10;
    
    @FXML
    private TableColumn<Person_Custmor, String> col11;
    @FXML
    private TableColumn<Person_Custmor, String> col13;
    
    public static String ref;

    ObservableList <Person_Custmor> persons=FXCollections.observableArrayList();
    
 
    
    @FXML
    private JFXTextField SearchFor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        CustmorTableView.setEditable(true);

        ArrayList <Customer> custmer= HomePageController.connection.GetAllCustomer();
    
        System.out.println("fsdfsf");
        for(int i=0;i<custmer.size();i++)
        {
          addNewCustmor(new Person_Custmor(custmer.get(i))); 
        }
        
        
      
    
        
        
        //SetCellValueFactory for all columns
        setCellValueFactoryForAllCloumns();
        
        //setCellFactory for all cloumns
        setCellFactoryForAllColumns();
        
        

       
        
        ////////////////Filter //////////////////
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Person_Custmor> filteredData = new FilteredList<>(persons, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        SearchFor.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                
                // compare all the data
                String lowerCaseFilter = newValue.toLowerCase();

                
                if (person.getReferenceKey().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if(person.getFName().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getMName().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getLName().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getAddress().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getHomePhone().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getCellPhone().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getEmail().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getBirthdate().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getGender().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getID().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } else if(person.getSsn().toString().toLowerCase().contains(lowerCaseFilter)){
                    return true; 
                } 
                
                return false; // Does not match.
            });
            
                    // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Person_Custmor> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(CustmorTableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        CustmorTableView.setItems(sortedData);
        });

       
        // Add columns event hanlding for all
        HandleAllColumns();
        
        
               
        
        

}

    
    public void setCellValueFactoryForAllCloumns(){
        col1.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getReferenceKey();
        });
      /* OR
        col1.setCellValueFactory(cellData -> cellData.getValue().getReferenceKey());
        */
        
        col2.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getFName();
        });
                
        col3.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getMName();
        });
        
        col4.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getLName();
        });
        
        col5.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getAddress();
        });
        
        col6.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getHomePhone();
        });
        
        col7.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getCellPhone();
        });
        
        col8.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getEmail();
        });
        
        col9.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getBirthdate();
        });
        
        col10.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getGender();
        });
        

        col11.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getSsn();
        });
        
        col13.setCellValueFactory((TableColumn.CellDataFeatures<Person_Custmor, String> param) -> {
            return param.getValue().getID();
        });
        
        
        
        //Insert  show cars Button
        TableColumn col_ShowCars = new TableColumn<>("Show Cars");
        CustmorTableView.getColumns().add(col_ShowCars);
        
        col_ShowCars.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_ShowCars.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell("Show Cars");
            }
        
        });
        
        
        //Insert  delete Button
        TableColumn col_del = new TableColumn<>("Delete");
        TableColumn col_SendMessage = new TableColumn<>("Send Message");
        TableColumn col_SendEmail = new TableColumn<>("Send Email");
        
        col_del.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_del.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell("Delete");
            }
        
        });
        
        col_SendMessage.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_SendMessage.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell("Send Message");
            }
        
        });
        
           col_SendEmail.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_SendEmail.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell("Send Email");
            }
        
        });
        CustmorTableView.getColumns().add(col_del);
        CustmorTableView.getColumns().add(col_SendMessage);
        CustmorTableView.getColumns().add(col_SendEmail);
       

    }

    
    public void addNewCustmor(Person_Custmor p){
     persons.add(p);
     CustmorTableView.setItems(persons);
}    
    
private void updateTable(Person_Custmor p){
    CustmorTableView.setItems(persons);
    Customer custmor=p.getCustmor();
    HomePageController.connection.UpdateCustomer(custmor);
    //////////////هون الكود يلي رح تعدل فيه على الداتا بيس  
    ////////الاوبجكت يلي رح تستعملو انت custmor
    
}

    public void setCellFactoryForAllColumns() {
        //make the table fields editable
         //col1.setCellFactory(TextFieldTableCell.forTableColumn());
         col2.setCellFactory(TextFieldTableCell.forTableColumn());
         col3.setCellFactory(TextFieldTableCell.forTableColumn());
         col4.setCellFactory(TextFieldTableCell.forTableColumn());
         col5.setCellFactory(TextFieldTableCell.forTableColumn());
         col6.setCellFactory(TextFieldTableCell.forTableColumn());
         col7.setCellFactory(TextFieldTableCell.forTableColumn());
         col8.setCellFactory(TextFieldTableCell.forTableColumn());
         col9.setCellFactory(TextFieldTableCell.forTableColumn());
         col10.setCellFactory(TextFieldTableCell.forTableColumn());
        // col11.setCellFactory(TextFieldTableCell.forTableColumn());
         //col13.setCellFactory(TextFieldTableCell.forTableColumn());
         
         
        
    }

    public void HandleAllColumns() {
        col2.setOnEditCommit(event -> {
            
            Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setFName(event.getNewValue());
             updateTable(person);
   
});
        
        col3.setOnEditCommit(event -> {
             Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setMName(event.getNewValue());
             updateTable(person);
   
});
        
        col4.setOnEditCommit(event -> {
             Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setLName(event.getNewValue());
             updateTable(person);
});
        
        col5.setOnEditCommit(event -> {
             Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setAddress(event.getNewValue());
             updateTable(person);
});
        
        col6.setOnEditCommit(event -> {
             Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setHomePhone(event.getNewValue());
             updateTable(person);
});
        
        col7.setOnEditCommit(event -> {
             Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setCellPhone(event.getNewValue());
             updateTable(person);
});
        
        col8.setOnEditCommit(event -> {
             Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setEmail(event.getNewValue());
             updateTable(person);
});
        
        col9.setOnEditCommit(event -> {
             Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setBirthdate(event.getNewValue());
             updateTable(person);
});
        
        col10.setOnEditCommit(event -> {
             Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setGender(event.getNewValue());
             updateTable(person);
});
        /*
        col13.setOnEditCommit(event -> {
             Person_Custmor x= event.getRowValue();
             Person_Custmor person=persons.get( persons.indexOf(x));
             person.setID(event.getNewValue());
             updateTable(person);
          
   
});
          */         
                
    }
    
    
    //Define the button cell
    private class ButtonCell extends TableCell<Record, Boolean> {
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
                	
                       Person_Custmor currentPerson = (Person_Custmor) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                        HomePageController.connection.DeleteCustomer(currentPerson.getCustmor());
                       for(int i=0;i<persons.size();i++)
                        {
                            if(persons.get(i).getID().equals(currentPerson.getID()))
                             {
                                 persons.remove(persons.get(i));
                                   break;
                              }
                        
                        }
                        
                	
                    }
                    else if(ac.compareTo("Send Message")==0){
                        Person_Custmor currentPerson = (Person_Custmor) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                        String number="97"+currentPerson.getCellPhone().getValue();
                            SMS s=new SMS();
                        String message= JOptionPane.showInputDialog("Enter Message");
                        if(message!=null)
                        s.SendSMS("Jamal_Alkelani", "jojo20155", message, number, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
   
                    }
                    
                    else if(ac.compareTo("Send Email")==0){
                        Person_Custmor currentPerson = (Person_Custmor) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                        String number=currentPerson.getEmail().getValue();
                        String mes= JOptionPane.showInputDialog("Enter Message");
                        if(mes!=null)
                        EmailMessage.SendMessage(number, "J&Z",mes);
                    }
                    else {
                        Person_Custmor currentPerson = (Person_Custmor) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                        ref=currentPerson.getReferenceKey().getValue();
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
