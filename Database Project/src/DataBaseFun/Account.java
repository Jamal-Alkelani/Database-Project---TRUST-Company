
package DataBaseFun;


public class Account
{
   private String Type="n";
   private Staff staff;
   private Admin admin;
   
   
   public Account(Staff s)
   {
             staff=s;
             Type="s";
   }        
           
    public Account(Admin a)
   {
             admin=a;
             Type="a";
   }           
  
   public String getType()
   {
       return Type;
   }
   
   public String getSsn()
   {
       if(Type.equals("s"))
       return staff.getSsn();
       else 
            return admin.getSsn();
       
   }
   
   public Object getObject()
   {
       if(Type.equals("s"))
       return staff;
       else 
            return admin;
   }
   
   public boolean isPassword(String s)
   {
       
       if(Type.equals("s"))
       {
           if((staff.getPassword()).equals(s))
               return true;
       }
       if(Type.equals("a"))
       {
         if(admin.getPassword().equals(s))
             return true;
       }
       return false;
   }
   
   
    
}
