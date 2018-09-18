
package DataBaseFun;
import static java.lang.Character.UnicodeBlock.forName;
import java.sql.*;
import java.math.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.*;
import oracle.jdbc.pool.*;
import oracle.sql.*;



public class ConnectionDB 
{
    
    private Connection connection;
    private OracleDataSource oracledata;
    private String Url;
    private String User;
    private String Password;
    
    
    public ConnectionDB(String user,String password,String url)
    {
        try
        {
        Url=url;
        User=user;
        Password=password;
        oracledata=new OracleDataSource();
        oracledata.setURL(Url);
        oracledata.setUser(User);
        oracledata.setPassword(Password);
        }
        catch(SQLException f)
        {
            System.out.println("Error[M785]:[OracleDataSource]");
        }
    }
    
    
    public ConnectionDB(String user,String password)
    {
        try
        {
        Url="jdbc:oracle:thin:@//localhost:1521/orcl";
        User=user;
        Password=password;
        oracledata=new OracleDataSource();
        oracledata.setURL(Url);
        oracledata.setUser(User);
        oracledata.setPassword(Password);
        }
        catch(Exception f)
        {
            System.out.println("Error[M785]:[OracleDataSource]");
        }
    }
    
    
      public ConnectionDB()
    {
        try
        {
        Url="jdbc:oracle:thin:@//localhost:1521/orcl";
        User="system";
        Password="12345";
        oracledata=new OracleDataSource();
        oracledata.setURL(Url);
        oracledata.setUser(User);
        oracledata.setPassword(Password);
        }
        catch(Exception f)
        {
            System.out.println("Error[M785]:[OracleDataSource]");
        }
    }
    
    
    public void startConnection()
    {
        try
        {
            connection=oracledata.getConnection();
            
        }
        catch(Exception g)
        {
            System.out.println("Error[M755]:[Connection DataBace ]");
        }
    }
    
    
    
    public void endConnection()
    {
        
        try 
        {
            connection.close();
        } 
        catch (SQLException ex) 
        {
           System.out.println("Error[M756]:[Connection Close]");
        }
    }
    
    public ResultSet get(String st)
    {
        try 
        {
            startConnection();
            Statement sta=connection.createStatement();
            ResultSet r = sta.executeQuery(st);
            endConnection();
            return r;
        } 
        catch (SQLException ex)
        {
           endConnection();
                  System.out.println("Error[M632]:[Connection Not Work OR Statement Error]");
                  return null;
            
            
        }
    }
    
    public ArrayList<Staff> getAllStaff()
    {
        try 
        {
            startConnection();
            ArrayList<Staff> staff=new ArrayList<Staff>();
            Statement sta=connection.createStatement();
            ResultSet r = sta.executeQuery("select * from EMPLOYEE,ADMINISTRATOR_S,Staff where (Employee.ESSN=Staff.SSNFORSTAFF) and (Staff.depnoworkon) in (select Depnomag from ADMINISTRATOR_S ) and (Staff.depnoworkon=ADMINISTRATOR_S.Depnomag)");
            while(r.next())
            staff.add(new Staff(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getString(10),r.getString(11),r.getInt(12),r.getString(13),r.getString(14)));
            endConnection();
            return staff;
        } 
        catch (Exception ex)
        {endConnection();
             System.out.println("Error[M858]:[Connection Not Work]");
        }
        return null;
    }
    
    
     public ArrayList<Admin> getAllAdmin()
     {
       try 
        {
            startConnection();
            ArrayList<Admin> admin=new ArrayList<Admin>();
            Statement sta=connection.createStatement();
            ResultSet r = sta.executeQuery("SELECT * FROM ADMINISTRATOR_S,EMPLOYEE where ADMINISTRATOR_S.SSNFORADMIN=EMPLOYEE.ESSN");
            while(r.next())
            admin.add(new Admin(r.getString(1),r.getString(2),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getString(10),r.getString(11),r.getString(12),r.getString(13),r.getInt(14)));
            endConnection();
            return admin;
        } 
        catch (Exception ex)
        {
            endConnection();
             System.out.println("Error[M858]:[Connection Not Work]");
        }
        return null;  
     }
    
    
      public ArrayList<Staff> getStaffForAdmin(String ssn)
    {
        try 
        {
            startConnection();
            ArrayList<Staff> staff=new ArrayList<Staff>();
            Statement sta=connection.createStatement();
            ResultSet r = sta.executeQuery("SELECT * FROM EMPLOYEE,staff where (staff.DEPNOWORKON in (SELECT ADMINISTRATOR_S.DEPNOMAG from ADMINISTRATOR_S WHERE ADMINISTRATOR_S.SSNFORADMIN='" +
ssn +
"')) and (staff.SSNFORSTAFF=EMPLOYEE.ESSN)");
            while(r.next())
            staff.add(new Staff(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getString(10),r.getString(11),r.getInt(12),ssn,r.getString(14)));
            endConnection();
            return staff;
        } 
        catch (Exception ex)
        {
            endConnection();
             System.out.println("Error[M858]:[Connection Not Work]");
        }
        return null;
    }
     
     public Account getAccount(String ssn,String pass)
     {
         try 
        {
            Admin admin=null;
            Staff staff=null;
            startConnection();
            Statement sta=connection.createStatement();
            ResultSet r = sta.executeQuery("SELECT * FROM ADMINISTRATOR_S,employee where ('"+ssn+"'=ADMINISTRATOR_S.SSNFORADMIN and employee.essn='"+ssn+"')"); 
             if(r.next())
             {
                 
                 admin=new Admin(r.getString(1),r.getString(2),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getString(10),r.getString(11),r.getString(12),r.getString(13),r.getInt(14));
                Account account=new Account(admin);
                System.out.println(account.getObject());
                Admin ad=(Admin) account.getObject();
                System.out.println(ad.getPassword()+"***");
                 if(!account.isPassword(pass))
                     account=null;
             
                 
                 endConnection();
            return account;
             }
            else
            {
             sta=connection.createStatement();
             
            r = sta.executeQuery("select * from EMPLOYEE,ADMINISTRATOR_S,Staff where (Employee.ESSN=Staff.SSNFORSTAFF)and Staff.SSNFORSTAFF='"+ssn+"'  and (Staff.depnoworkon) in (select Depnomag from ADMINISTRATOR_S ) and (Staff.depnoworkon=ADMINISTRATOR_S.Depnomag)"); 
            if(r.next())
            {
            staff=new Staff(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getString(10),r.getString(11),r.getInt(12),r.getString(13),r.getString(14));
            Account account=new Account(staff);
                if(!account.isPassword(pass))
                     account=null;
                endConnection();
            return account;
            }
            }
            endConnection();
            return null;
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
             System.out.println("Error[M858]:[Connection Not Work]");
        }
         return null;
     }
     
     
     public ArrayList<Customer> GetAllCustomer()
     {
          try 
        {
            startConnection();
            ArrayList<Customer> customer=new ArrayList<Customer>();
            Statement sta=connection.createStatement();
            ResultSet r = sta.executeQuery("select * from CUSTOMER");
            while(r.next())
            customer.add(new Customer(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getString(10),r.getString(11),r.getString(12)));
            endConnection();
            return customer;
        }  
        catch (Exception ex)
        {
           // endConnection();
             System.out.println("Error[KJ5]:[Connection Not Work]");
        }
        return null;
         
         
     }
     
     
     public ArrayList<Customer> GetAllCustomerForStaff(String ssnStaff)
     {
          try 
        {
            startConnection();
            ArrayList<Customer> customer=new ArrayList<Customer>();
            Statement sta=connection.createStatement();
            ResultSet r = sta.executeQuery("select * from CUSTOMER,Staff where Staff.SSNFORSTAFF=CUSTOMER.SSNOFSTAFF and Staff.SSNFORSTAFF='"+ssnStaff+"'");
            while(r.next())
            customer.add(new Customer(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getString(10),r.getString(11),r.getString(12)));
            endConnection();
            return customer;
        } 
        catch (Exception ex)
        {
            endConnection();
             System.out.println("Error[M858]:[Connection Not Work]");
        }
        return null;
         
         
     }
     
     
     /*
     public ArrayList<Customer> SearchCustomer(String text)
     {
        try 
        {
            startConnection();
            ArrayList<Customer> customer=new ArrayList<Customer>();
            String s[]= text.split(" ");
            for(int i=0;i<s.length;i++)
            {
            Statement sta=connection.createStatement();
            ResultSet r = sta.executeQuery("select * from customer where customer.fnamec like '%"+s[i]+"%'" +
                    " UNION " +
                    "select * from customer where customer.mnamec like '%"+s[i]+"%'" +
                    " UNION " +
                    "select * from customer where customer.lnamec like '%"+s[i]+"%'");
            while(r.next())
            {
                Customer c1=new Customer(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getString(10),r.getDate(11),r.getString(12));
           if(!customer.contains(c1))
               customer.add(c1);
            }
            }
              endConnection();
            return customer;
        } 
        catch (Exception ex)
        {
            endConnection();
             System.out.println("Error[M858]:[Connection Not Work]");
        }
        return null;
         
         
     }
     */
     
     
     public ArrayList<Insurance> getInsuranceForCustomer(String text)
     {
         try 
        {
            startConnection();
            ArrayList<Insurance> ins=new ArrayList<Insurance>();
               Statement sta=connection.createStatement();
            ResultSet r = sta.executeQuery("select * FROM INSURANCE,CUSTOMER where INSURANCE.REFRENCEKEYCUST=customer.REFRENCEKEY and customer.REFRENCEKEY='"+text+"'" );
            while(r.next())
            ins.add(new Insurance(r.getString(1),r.getString(2),r.getInt(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getString(10),r.getString(11),r.getString(12),r.getInt(13),r.getInt(14),r.getString(15),r.getString(16),r.getInt(17),r.getInt(18),r.getString(19),r.getString(20),r.getString(21)));
            endConnection();
            return ins;
        } 
        catch (Exception ex)
        {
            endConnection();
             System.out.println("Error[M858]:[Connection Not Work]");
        }
        return null;
         
         
     }
     
     
     public boolean UpdateStaff(Staff s)
     {
         try
         {
            startConnection();
           
            Statement sta=connection.createStatement();
          
           
           String q="UPDATE   EMPLOYEE set EMAILE = '"+s.getEmail()+"' , fnamee='"+s.getFName()+"',snamee='"+s.getSName()+"',mnamee='"+s.getMName()+"',lnamee='"+s.getLName()+"',Sexe='"+s.getSex()+"',Citye='"+s.getCity()+"',cellphonee='"+s.getCellPhone()+"',homephonee='"+s.getHomePhone()+"',PASSWOEDE='"+s.getPassword()+"',SALARYE="+s.getSalary()+"  where Essn='"+s.getSsn()+"'";
           sta.executeUpdate(q);
           q="UPDATE staff set DEPNOWORKON='"+s.getDeparmentWorkOn()+"'"+" where SSNFORSTAFF='"+s.getSsn()+"'";
           sta.executeUpdate(q);
            endConnection();
            return true;
         }
         catch(Exception g)
         {
             System.out.println("error update");
             endConnection();
             return false;
         }
         
     }
     
     public boolean  DeleteCustomer(Customer c)
     {
         try
         {
            startConnection();
           
            Statement sta=connection.createStatement();
            String q="DELETE  FROM INSURANCE where REFRENCEKEYCUST ='"+c.getRefKey()+"'";
            sta.execute(q);
             Statement sta1=connection.createStatement();
             q="DELETE  FROM customer where REFRENCEKEY = '"+c.getRefKey()+"'";
            sta.execute(q);
            endConnection();
            return true;
         }
         catch(Exception g)
         {
             System.out.println("error update");
             endConnection();
             return false;
         }
     }
     
     
     private void updateCustomer(String oldssn,String newssn)
     {
         try
         { 
            startConnection();
            Statement sta=connection.createStatement();
            String q="UPDATE CUSTOMER set ssnofstaff='"+newssn+"' where ssnofstaff='"+oldssn+"'";
            
            sta.executeUpdate(q);
            endConnection();
         }
         
         catch(Exception gg)
         {
         }
     }
     
     
     public boolean  DeleteStaff(Staff staff)
     {
         try
         {
            updateCustomer(staff.getSsn(),"XXX-XXX");
            startConnection();
            String q;
            Statement sta=connection.createStatement();
             q="DELETE FROM staff  WHERE SSNFORSTAFF = '"+staff.getSsn()+"'";
            sta.execute(q);
            q="DELETE FROM Employee  WHERE Employee.essn = '"+staff.getSsn()+"'";
               sta.execute(q);
            endConnection();
            staff=null;
            System.gc();
            return true;
         }
         catch(Exception g)
         {
             System.out.println("error update");
             endConnection();
             return false;
         }
         
     }
 
     public boolean AddStaff(Staff staff,Admin admin)
     {
         try
         {
            startConnection();
            String q;
            Statement sta=connection.createStatement();
             q="INSERT INTO EMPLOYEE VALUES ('"+staff.getSsn()+"','"+staff.getEmail()+"','"+staff.getFName()+"','"+staff.getSName()+"','"+staff.getMName()+"','"+staff.getLName()+"','"+staff.getSex()+"','"+staff.getCity()+"','"+staff.getCellPhone()+"','"+staff.getHomePhone()+"','"+staff.getPassword()+"',"+staff.getSalary()+")";
            sta.execute(q);
            q="INSERT INTO Staff VALUES ('"+staff.getSsn()+"','"+admin.getDeparmentMag()+"')";
               sta.execute(q);
            endConnection();
            return true;
         }
         catch(Exception g)
         {
             System.out.println("error insert");
             endConnection();
             return false;
         }
     }
     
     
      public boolean AddInsurance(Insurance insu) throws SQLException
     {
         
            startConnection();
            String q;
            Statement sta=connection.createStatement();
            q="INSERT INTO INSURANCE   VALUES ('"+insu.getDOSI()+"', '"+insu.getDOEI()+"', "+insu.getInsCost()+", '"+insu.getRefKey()+"', '"+insu.getChassisNumber()+"', '"+insu.getEnginId()+"', '"+insu.getPlateNumber()+"', '"+insu.getFuelType()+"', '"+insu.getLicenseNumber()+"', '"+insu.getPurchase()+"', '"+insu.getCarBrand()+"', '"+insu.getModelCar()+"', "+insu.getManufYear()+", "+insu.getNumberOfDoors()+", '"+insu.getLicCategory()+"', '"+insu.getPrevAccedents()+"', "+insu.getWeight()+", "+insu.getPower()+", '"+insu.getFTurbo()+"', '"+insu.getFAlarm()+"', '"+insu.getColor()+"')";                                                                                               //(DOSI, DOEI, INSURANCECOST, REFRENCEKE                                      YCUST, CHASSISNO, ENGINID, PLATENO, FUELTYPE, LICENSENO, PURCHASE,                                                             CARBRAND,                   MODELCAR,                                MANUFYEAR, NOOFDOORS, LICCATEGORY, PREVACCEDENTE, WEIGHT,                                                  POWERD, F_TURBO, F_ALARM, MANUFACTURINGDATE, BRAND, COLOR)   
            System.out.println(q);
            sta.execute(q);
            endConnection();
            return true;
     }
 
       public boolean AddCustomer(Customer k) throws SQLException
     {
        
            startConnection();
            String q;
            Statement sta=connection.createStatement();
             q="INSERT INTO CUSTOMER VALUES ('"+k.getID()+"', '"+k.getRefKey()+"', '"+k.getFname()+"', '"+k.getMname()+"', '"+k.getLname()+"', '"+k.getAddress()+"', '"+k.getCellPhone()+"', '"+k.getHomePhone()+"', '"+k.getEmail()+"', '"+k.getSex()+"', '"+k.getBD()+"', '"+k.getSsnForStaff()+"')" ;  
             System.out.println(q);
             sta.execute(q);
            endConnection();
            return true;
     
       
     }
      
      public boolean isRefKey(String h)
      { 
          try 
        {

            startConnection();

            Statement sta=connection.createStatement();

            ResultSet r = sta.executeQuery("select * from CUSTOMER where REFRENCEKEY='"+h+"'");

            while(r.next())
            {

                endConnection();
                return true;
            }
           endConnection();

        } 
        catch (Exception ex)
        {
            endConnection();
             System.out.println("Error[M858]:[Connection Not Work]");
        }
          
          return false;
      }

    public void UpdateCustomer(Customer custmor) 
    {
        try
         { 
            startConnection();
            Statement sta=connection.createStatement();
            String q="UPDATE CUSTOMER set "
           + "fnamec = '"+custmor.getFname()+"'"
          +",mnamec = '"+custmor.getMname()+"'"
          +  ",lnamec = '"+custmor.getLname()+"',"
           + "ADDRESS = '"+custmor.getAddress()+"'"
           + ",CELLPHONEC = '"+custmor.getCellPhone()+"'"
           + ",HOMEPHONEC ='"+custmor.getHomePhone()+"',"
           +" EMAILC = '"+custmor.getEmail()+"'"
           + ",SEXC = '"+custmor.getSex()+"'  "
            +"where REFRENCEKEY='"+custmor.getRefKey()+"'  " ;
            sta.executeUpdate(q);
            endConnection();
         }
         
         catch(Exception gg)
         {
             System.out.println("gf---------------------------------------55vfdvfdvfdvfdv-fdvfdvfdvfdvfdvfdvfdvfdvfdvfdvfdvfdv");
         }
        
        
        
    }


 public boolean  DeleteInsurance(Insurance insurance)
     {
         try
         {

             
            startConnection();
            Statement sta=connection.createStatement();
             String q="DELETE  FROM INSURANCE where PLATENO ='"+insurance.getPlateNumber()+"'";
            sta.execute(q);
            endConnection();
            return true;
         }
         catch(Exception g)
         {
             System.out.println("error update");
             endConnection();
             return false;
         }
         
     }
 
 
 public void updateInsurance(Insurance insurance)
     {
         try
         { 
            startConnection();
            Statement sta=connection.createStatement();
            String q=
          " UPDATE INSURANCE set"
          +  " INSURANCECOST="+insurance.getInsCost()
          + ", CHASSISNO ='"+insurance.getChassisNumber()+"'"
           + ", ENGINID='"+insurance.getEnginId()+"'"
           + ",FUELTYPE='"+insurance.getFuelType()+"'"
           + ",LICENSENO='"+insurance.getLicenseNumber()+"'"
           + ",PURCHASE='"+insurance.getPurchase()+"'"
           + ",CARBRAND='"+insurance.getCarBrand()+"'"
           + ",MODELCAR='"+insurance.getModelCar()+"'"
          + " ,MANUFYEAR="+insurance.getManufYear()
          + " ,NOOFDOORS="+insurance.getNumberOfDoors()
          +  ",LICCATEGORY='"+insurance.getLicCategory()+"'"
           + ",PREVACCEDENTE='"+insurance.getPrevAccedents()+"'"
            +",WEIGHT="+insurance.getWeight()
          + " ,POWERD="+insurance.getPower()
           + ",F_TURBO='"+insurance.getFTurbo()+"'"
           + ",F_ALARM='"+insurance.getFAlarm()+"'"
            +",COLOR='"+insurance.getColor()+"' "
           + "where PLATENO='"+insurance.getPlateNumber()+"'";
                    System.out.println(q);
            sta.executeUpdate(q);
            endConnection();
         }
         
         catch(Exception gg)
         {
         }
     }

    public Connection getCon() {
    return  connection;
    
    }
////-----------------------------------------------------------------------------------------------------------
    public boolean addCustomerAndInsurance(Customer customer, Insurance insurance) 
    {
        
        System.out.println("zaid:::::::::::"+FindCustomer(customer));
        if(FindCustomer(customer))
        {
            
            
              
            try
            {
                startConnection();
                String ref=getCustomerRef(customer);///get RefKey for customer
                insurance.setRefKey(ref);
                //System.out.println("::::::::::[zaid]::::::::::"+insurance.getRefKey());
                AddInsurance(insurance);
                endConnection();
                return true;
            }
            catch (SQLException ex)
            {
                endConnection();
              //  System.out.println("erorrrrrrrrrrrrrrr444");
                return false;
                //Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            

             boolean flag=false;
                    
                    try 
                    {
                      //  System.out.println("::::[Ref in database]:"+getCustomerRef(customer));
                        AddCustomer(customer);
                        flag=true;
                        AddInsurance(insurance);
                       // System.out.println("okkkkkkkkkkkk niceeeee");
                         endConnection();
                        // System.out.println("okkkkkkkkkkkk niceeeee");
                        return true;
                    } 
                    catch (Exception ex)
                    {
                        if(flag==true)
                        DeleteCustomer(customer);
                         endConnection();
                        return false;
                        
                    }
        }
        

        
        
        
    }

    private boolean FindCustomer(Customer customer) 
    {
        try
        {
              startConnection();
            Statement sta=connection.createStatement();
            String q="select * from customer where IDNUMBERC='"+customer.getID()+"'";
              ResultSet r =sta.executeQuery(q);
              while(r.next())
              {
                  endConnection();
                  return true;
              }
            return false;
        }
        catch(Exception jkk)
        {
            return false;
        }
            
   }

    private String getCustomerRef(Customer customer)
    {
        try
        {
            startConnection();
            Statement sta=connection.createStatement();
            String q="select REFRENCEKEY from customer where IDNUMBERC ='"+customer.getID()+"'";
            System.out.println(""+q);
            ResultSet r =sta.executeQuery(q);
          //  System.out.println("wow not hear");
            while(r.next())
            {
              //  System.out.println("wow not in whielecwe");
                // endConnection();
             return r.getString(1);
            }
             endConnection();
            return null;
           
        }
        catch(SQLException jkk)
        {
            System.out.println("46545456rerrior");
            return null;
        }
        
    }

   
 
 
 
 
}
