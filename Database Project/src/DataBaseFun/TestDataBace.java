/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseFun;

import java.util.ArrayList;
import java.sql.Date;


/**
 *
 * @author ASUS
 */
public class TestDataBace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Frame().setVisible(true);
        
        /*/
       ArrayList<Customer> customer;
       ConnectionDB con=new ConnectionDB();
       customer=con.SearchCustomer("zaid m hab");
        for(int i=0;i<customer.size();i++)
              System.out.println(customer.get(i).getBD());
        con.AddInsurance(new Insurance(new Date(555555),new Date(5599555),"5455",new Date(587555),"mmmmm"));
       System.out.println(con.isRefKey("8252"));
        /*
        ArrayList<Staff> staff=new ArrayList<Staff>();
        ArrayList<Admin> admin=new ArrayList<Admin>();
        ConnectionDB con=new ConnectionDB();
        admin=con.getAllAdmin();
      // Staff staff=new Staff("989");
        con.AddStaff(new Staff("ADgh-869"),admin.get(3));
        
        
        /*
        admin=con.getAllAdmin();
        staff=admin.get(0).GetStaff();
       
        for(int i=0;i<admin.size();i++)
        {
            admin.get(i).addStaff(con.getStaffForAdmin(admin.get(i).getSsn()));
            staff= admin.get(i).GetStaff();
            if(staff!=null)
            for(int t=0;t<staff.size();t++)
            {
            System.out.println(staff.get(t));
            }
            System.out.println("/n/n/n/n");
        }
        
        
        
        for(int i=0;i<admin.size();i++)
        {
             staff=admin.get(i).GetStaff();
             if(staff!=null)             
             for(int y=0;y<staff.size();y++)
             {
                 staff.get(y).setCity("ghhh");
                 if(con.UpdateStaff(staff.get(y)))
                     System.out.println("Update Sacsses for ssn Sfatt:"+staff.get(y).getSsn());
                     
             }
        }
        
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
         admin=con.getAllAdmin();
        staff=admin.get(0).GetStaff();
       
        for(int i=0;i<admin.size();i++)
        {
            admin.get(i).addStaff(con.getStaffForAdmin(admin.get(i).getSsn()));
            staff= admin.get(i).GetStaff();
            if(staff!=null)
            for(int t=0;t<staff.size();t++)
            {
            System.out.println(staff.get(t));
            }
            System.out.println("/n/n/n/n");
        }
        */
        
     
        
      /*   ConnectionDB con=new ConnectionDB();
        Account acc=con.getAccount("969", "6599999");
        Staff staff;
        Admin admin;
        if(acc==null)
        {
             System.out.println("Ssn or password enter is not av");
            return;
        }
        if(acc.getType().equals("a"))
        {
           admin=(Admin)acc.getObject();
             System.out.println(admin);
            return;
        }
        if(acc.getType().equals("s"))
        {
           staff=(Staff)acc.getObject();
             System.out.println(staff);
            return;
        }
        else
        {
            System.out.println("Account Not Avl2000");
            return;
        }*/

     
     
    }
    
}
