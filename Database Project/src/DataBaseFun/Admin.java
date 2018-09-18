
package DataBaseFun;

import java.util.ArrayList;


public class Admin 
{
    private ArrayList<Staff> staff=null;
    private String Ssn;
    private String Email;
    private String FName; 
    private String SName; 

    private String MName; 
    private String LName; 
    private String Sex;
    private String City;
    private String CellPhone;
    private String HomePhone;
    private String Password;
    private int Salary;
    public String DeparmentMag;
    
    public void setStaff(ArrayList<Staff> s)
    {
        staff=s;
    }
    
    public ArrayList<Staff> GetStaff()
    {
        return staff;
    }
    
    public Staff searchStaff(String ssn)
    {
        for(Staff s:staff)
        {
            if(s.getSsn()==ssn)
                return s;
        }
        return null;
    }


    public Admin(String ssn,String deparmentmag,String email,String fname,String sname,String mname,String lname,String sex,String city,String cellphone,String homephone,String password,int salary)
    {
      Ssn=ssn;
      Email=email;
      FName=fname; 
      SName=sname; 
      MName=mname; 
      LName=lname; 
      Sex=sex;
      City=city;
      CellPhone=cellphone;
      HomePhone=homephone;
      Password=password;
      Salary=salary;
      DeparmentMag=deparmentmag;
    }
     
     
    
    @Override 
    public String toString()
    {
        return (Ssn+"    "+Email+"     "+FName+"    "+SName+"    "+MName+"    "+LName+"    "+Sex+"    "+City+"    "+CellPhone+"     "+HomePhone+"      "+Password+"     "+Salary+"    "+"     "+DeparmentMag);
    }

    public void setSsn(String Ssn) {
        
        this.Ssn = Ssn;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setCellPhone(String CellPhone) {
        this.CellPhone = CellPhone;
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public void setDeparmentMag(String DeparmentMag) {
        this.DeparmentMag = DeparmentMag;
    }
    public String getSsn()
    {
       return Ssn;
    }
    
     public String getPassword()
    {
       return Password;
    }
     public String getEmail() {
        return Email;
    }

    public String getFName() {
        return FName;
    }

    public String getSName() {
        return SName;
    }

    public String getMName() {
        return MName;
    }

    public String getLName() {
        return LName;
    }

    public String getSex() {
        return Sex;
    }

    public String getCity() {
        return City;
    }

    public String getCellPhone() {
        return CellPhone;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public int getSalary() {
        return Salary;
    }

    public String getDeparmentMag() {
        return DeparmentMag;
    }
}
