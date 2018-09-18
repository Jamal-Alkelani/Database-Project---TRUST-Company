
package database.project;

import DataBaseFun.Staff;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Person_Staff {
    
    //UNIUQE KEY
    private SimpleStringProperty SSN;
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
    private SimpleStringProperty superssn;
    private SimpleStringProperty Gender;
    private SimpleStringProperty DepartmentNo;
    private SimpleStringProperty Salary; 
    private SimpleStringProperty Password;
    //private Staff staff;
    
    //Constructor
    public Person_Staff(String SSN,String Email, String FName, String MName
            , String LName,String Gender, String Address, String CellPhone, String HomePhone
            ,String Password, String Salary,String superssn,  String DepartmentNo
            ) {
        
        this.SSN = new SimpleStringProperty(SSN);
        this.FName = new SimpleStringProperty(FName);
        this.MName = new SimpleStringProperty(MName);
        this.LName =new SimpleStringProperty( LName);
        this.Address = new SimpleStringProperty(Address);
        this.HomePhone =new SimpleStringProperty(HomePhone);
        this.CellPhone =new SimpleStringProperty( CellPhone);
        this.Email = new SimpleStringProperty(Email);
        this.superssn = new SimpleStringProperty(superssn);
        this.Gender = new SimpleStringProperty(Gender);
        this.DepartmentNo =new SimpleStringProperty( DepartmentNo);
        this.Salary = new SimpleStringProperty(Salary);
        this.Password = new SimpleStringProperty(Password);
    }
            
    
        
    public Person_Staff(Staff staff) {
        
        
        
        this.SSN = new SimpleStringProperty (staff.getSsn());
        this.FName = new SimpleStringProperty (staff.getFName());
        this.MName =new SimpleStringProperty ( staff.getMName());
        this.LName = new SimpleStringProperty (staff.getLName());
        this.Address = new SimpleStringProperty (staff.getCity());
        this.HomePhone = new SimpleStringProperty (staff.getHomePhone());
        this.CellPhone = new SimpleStringProperty (staff.getCellPhone());
        this.Email =new SimpleStringProperty ( staff.getEmail());
        this.Salary = new SimpleStringProperty (staff.getSalary()+"");
        this.Gender = new SimpleStringProperty (staff.getSex());
        this.DepartmentNo =new SimpleStringProperty ( staff.getDeparmentWorkOn());
        this.Password = new SimpleStringProperty (staff.getPassword());
        this.superssn = new SimpleStringProperty(staff.getSsnSuper());

        
        
    }
    

public Staff getStaff(){
    return new Staff(this.getSSN().getValue(),this.getEmail().getValue(),this.getFName().getValue(),this.getMName().getValue(),
            this.getLName().getValue(),"",this.getGender().getValue(),
    this.getAddress().getValue(),this.getCellPhone().getValue(),this.getHomePhone().getValue(),this.getPassword().getValue(),
    Integer.parseInt(this.getSalary().getValue()),this.getsuperssn().getValue(),this.getDepartment().getValue());
}

    
    //Getters
    public SimpleStringProperty getSSN() {
        return SSN;
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

    public SimpleStringProperty getsuperssn() {
        return superssn;
    }

    public SimpleStringProperty getGender() {
        return Gender;
    }

    public SimpleStringProperty getMarried() {
        return DepartmentNo;
    }
    
    public SimpleStringProperty getDepartment() {
        return Salary;
    }

    public SimpleStringProperty getPassword() {
        return Password;
    }
    
    public SimpleStringProperty getSalary() {
        return Salary;
    }

    public void setSSN(String SSN) {
        this.SSN = new SimpleStringProperty(SSN);
    }

    public void setFName(String FName) {
        this.FName = new SimpleStringProperty(FName);
    }

    public void setMName(String MName) {
        this.MName =new SimpleStringProperty( MName);
    }

    public void setLName(String LName) {
        this.LName = new SimpleStringProperty(LName);
    }

    public void setAddress(String Address) {
        this.Address = new SimpleStringProperty(Address);
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = new SimpleStringProperty(HomePhone);
    }

    public void setCellPhone(String CellPhone) {
        this.CellPhone = new SimpleStringProperty(CellPhone);
    }

    public void setEmail(String Email) {
        this.Email =new SimpleStringProperty( Email);
    }

    public void setSuperssn(String superssn) {
        this.superssn = new SimpleStringProperty(superssn);
    }

    public void setGender(String Gender) {
        this.Gender =new SimpleStringProperty( Gender);
    }

    public void setDepartmentNo(String DepartmentNo) {
        this.DepartmentNo =new SimpleStringProperty( DepartmentNo);
    }

    public void setSalary(String Salary) {
        this.Salary =new SimpleStringProperty( Salary);
    }

    public void setPassword(String Password) {
        this.Password = new SimpleStringProperty(Password);
    }
    
    

}
