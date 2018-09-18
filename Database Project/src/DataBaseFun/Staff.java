
package DataBaseFun;

import java.util.ArrayList;


public class Staff 
{
    private String Ssn;
    private String Email="";
    private String FName=""; 
    private String SName=""; 
    private String MName=""; 
    private String LName=""; 
    private String Sex="";
    private String City="";
    private String CellPhone="";
    private String HomePhone="";
    private String Password="";
    private int Salary=0;
    public String DeparmentWorkOn="";
    public String SsnSuper="";
    
    
    public Staff(String g)
    {
        Ssn=g;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Staff(String ssn,String email,String fname,String sname,String mname,String lname,String sex,String city,String cellphone,String homephone,String password,int salary,String ssnsuper,String deparmentworkon)
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
      DeparmentWorkOn=deparmentworkon;
      SsnSuper=ssnsuper;
    }
    
    @Override 
    public String toString()
    {
        return (Ssn+"    "+Email+"     "+FName+"    "+SName+"    "+MName+"    "+LName+"    "+Sex+"    "+City+"    "+CellPhone+"     "+HomePhone+"      "+Password+"     "+Salary+"    "+SsnSuper+"     "+DeparmentWorkOn);
    }

    public String getSsn()
    {
       return Ssn;
    }
           
    
   
    public String getEmail()
    {
       return Email;
    }
    
       public void setEmail(String h)
    {
        Email=h;
    }
            
            
            
    public String getPassword()
    {
       return Password;
    }
    
       public void setPassword(String h)
    {
        Password=h;
    }
    
    public String getCity()
    {
       return City;
    }
    
       public void setCity(String h)
    {
        City=h;
    }
    
    public String getFName()
    {
     return FName;
    }
      public void setFName(String h)
    {
        FName=h;
    }
    
    
    
    
    public String getSName()
    {
     return SName;
    }
    public void setSName(String h)
    {
        SName=h;
    } 
    
    
    public String getMName()
    {
     return MName;
    }
    public void setMName(String h)
    {
        MName=h;
    }
    
    
    public String getLName()
    {
     return LName;
    }
       public void setLName(String h)
    {
        LName=h;
    }
    
    public String getSex()
    {
     return Sex;
    }
      public void setSex(String h)
    {
        Sex=h;
    }
    
    public String getCellPhone()
    {
        return CellPhone;
    }
       public void setCellPhone(String h)
    {
        CellPhone=h;
    }
    
    
    public String getHomePhone()
    {
        return HomePhone;
    }
         
     public void setHomePhone(String h)
    {
        HomePhone=h;
    }
    
    public int getSalary()
    {
        return Salary;
    }
    public void setSalary(int s)
    {
        Salary=s;
    }
    
    public String getDeparmentWorkOn()
    {
        return DeparmentWorkOn;
    }
    
    
    public void setDeparmentWorkOn(String d)
    {
        DeparmentWorkOn=d;
    }
    
    
    
      public String getSsnSuper()
    {
        return DeparmentWorkOn;
    }
      
    
            }
