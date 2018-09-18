
package database.project;



import DataBaseFun.Customer;
import com.jfoenix.controls.JFXButton;
import java.sql.Date;
import java.util.ArrayList;
//import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Person_Custmor {

    //UNIUQE KEY
    private SimpleStringProperty ReferenceKey;
    //NAME
    private SimpleStringProperty FName;
    private SimpleStringProperty MName;
    private SimpleStringProperty LName;
    //Contacting Information
    private SimpleStringProperty Address;
    private SimpleStringProperty HomePhone;
    private SimpleStringProperty CellPhone;
    private SimpleStringProperty Email;
    //private Info
    private SimpleStringProperty Birthdate;
    private SimpleStringProperty Gender;
    private SimpleStringProperty ssn;
    private SimpleStringProperty ID;

    
    private Customer custmor;
    
  

    public Person_Custmor(String ID, String ReferenceKey, String FName,String MName, String LName, String Address,
            String CellPhone, String HomePhone, String Email, String Gender, String Birthdate,String ssn) {
        
        
        
        this.ReferenceKey = new SimpleStringProperty (ReferenceKey);
        this.FName = new SimpleStringProperty (FName);
        this.MName =new SimpleStringProperty ( MName);
        this.LName = new SimpleStringProperty (LName);
        this.Address = new SimpleStringProperty (Address);
        this.HomePhone = new SimpleStringProperty (HomePhone);
        this.CellPhone = new SimpleStringProperty (CellPhone);
        this.Email =new SimpleStringProperty ( Email);
        this.Birthdate = new SimpleStringProperty (Birthdate);
        this.Gender = new SimpleStringProperty (Gender);
        this.ssn =new SimpleStringProperty ( ssn);
        this.ID = new SimpleStringProperty (ID);

        
        
    }

    
    public Person_Custmor(Customer custmor) {
        
        
        
        this.ReferenceKey = new SimpleStringProperty (custmor.getRefKey());
        this.FName = new SimpleStringProperty (custmor.getFname());
        this.MName =new SimpleStringProperty ( custmor.getMname());
        this.LName = new SimpleStringProperty (custmor.getLname());
        this.Address = new SimpleStringProperty (custmor.getAddress());
        this.HomePhone = new SimpleStringProperty (custmor.getHomePhone());
        this.CellPhone = new SimpleStringProperty (custmor.getCellPhone());
        this.Email =new SimpleStringProperty ( custmor.getEmail());
        this.Birthdate = new SimpleStringProperty (custmor.getBD());
        this.Gender = new SimpleStringProperty (custmor.getSex());
        this.ssn =new SimpleStringProperty ( custmor.getSsnForStaff());
        this.ID = new SimpleStringProperty (custmor.getID());
        this.custmor=custmor;

        
        
    }
    
   public void setReferenceKey(String ReferenceKey) {
        this.ReferenceKey =new SimpleStringProperty ( ReferenceKey);
    }

    public void setFName(String FName) {
        this.FName =new SimpleStringProperty ( FName);
    }

    public void setMName(String MName) {
        this.MName =new SimpleStringProperty ( MName);
    }

    public void setLName(String LName) {
        this.LName = new SimpleStringProperty (LName);
    }

    public void setAddress(String Address) {
        this.Address =new SimpleStringProperty ( Address);
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = new SimpleStringProperty (HomePhone);
    }

    public void setCellPhone(String CellPhone) {
        this.CellPhone = new SimpleStringProperty (CellPhone);
    }

    public void setEmail(String Email) {
        this.Email =new SimpleStringProperty ( Email);
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = new SimpleStringProperty (Birthdate);
    }

    public void setGender(String Gender) {
        this.Gender = new SimpleStringProperty (Gender);
    }

    public void setSsn(String ssn) {
        this.ssn =new SimpleStringProperty ( ssn);
    }

    public void setID(String ID) {
        this.ID =new SimpleStringProperty ( ID);
    }

public Customer getCustmor(){
    //System.out.println(ssn.getValue()+"-----------------------------------------------");
    Customer n=new Customer(this.getID().getValue(),this.getReferenceKey().getValue(),this.getFName().getValue(),this.getMName().getValue(),this.getLName().getValue(),this.getAddress().getValue()
           ,this.getCellPhone().getValue(),this.getHomePhone().getValue(),this.getEmail().getValue(),this.getGender().getValue(),Birthdate.getValue(),this.getSsn().getValue());
           
    return n;
            }

    
    //Getters
    public SimpleStringProperty getReferenceKey() {
        return ReferenceKey;
    }

    public SimpleStringProperty getFName() {
        return FName;
    }

    public SimpleStringProperty getMName() {
        return MName;
    }

    public SimpleStringProperty getLName() {
        return LName;
    }

    public SimpleStringProperty getAddress() {
        return Address;
    }

    public SimpleStringProperty getHomePhone() {
        return HomePhone;
    }

    public SimpleStringProperty getCellPhone() {
        return CellPhone;
    }

    public SimpleStringProperty getEmail() {
        return Email;
    }

    public SimpleStringProperty getBirthdate() {
        return Birthdate;
    }

    public SimpleStringProperty getGender() {
        return Gender;
    }

    public SimpleStringProperty getSsn() {
        return ssn;
    }

    public SimpleStringProperty getID() {
        return ID;
    }

    

}
