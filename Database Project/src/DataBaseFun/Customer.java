
package DataBaseFun;

import java.util.Date;



public class Customer
{
    
    
    
   private String Id;
   private String RefKey;
   private String Fname;
   private String Mname;
   private String Lname;
   private String Address;
   private String CellPhone; 
   private String HomePhone;     
   private String Email;
   private String Sex;       
   private String SsnForStaff;       
   private String BD;
   
   
   public Customer()
   {
       
   }
   public Customer(String id,String refkey,String fn
           ,String mn,String ln,String address
           ,String cell,String home,String email
           ,String sex,String bd,String ssn)
   {
       Id=id;
       RefKey=refkey;
       Fname=fn;
       Mname=mn;
       Lname=ln;   
       Address=address;
       CellPhone=cell;
       HomePhone=home;
       Email=email;
       Sex=sex;
       BD=bd;
       SsnForStaff=ssn;   
   }
   
   
   
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCellPhone() {
        return CellPhone;
    }

    public void setCellPhone(String CellPhone) {
        this.CellPhone = CellPhone;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
    }

   
   
   
   
 
   
   public void setSsnForStaff(String g)
   {
       SsnForStaff=g;
   }
   
   public String getSsnForStaff()
   {
       return SsnForStaff;
   }
   public String getID()
   {
       return Id;
   }
   
   public String getRefKey()
   {
       return RefKey;
   }
   
   public String getFname()
   {
       return Fname;
   }
   
  
   
    public String getMname()
   {
       return Mname;
   }    
    
   public String getLname()
   {
       return Lname;
   } 
    
    public String getName()
   {
       return (Fname+" "+Mname+" "+Lname);
   } 
    
    
    public String getAddress()
   {
       return Address;
   } 
    
  
    
    

 
   
    public String getEmail()
    {
        return Email;
    }
    public String getSex()
    {
        return Sex;
    }
    
 
    
    public String getBD()
    {
        return BD;
    }
    
    
    
    
   
    
    
    
}
