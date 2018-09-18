/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.project;

import java.util.Random;

public class Random_Refrence_Generator {
public  String generate(){
    return generator();
}    

public String generateSSN(){
    
    return null;
}


public  String generator(){
    // Generate Random Numbers for L1L2-B1B2B3-V1V2
        double L1 = Math.random()*(10);
        double L2 = Math.random()*(10);

        double B1 = Math.random()*(10);
        double B2 = Math.random()*(10);
        double B3 = Math.random()*(10);

        double V1 = Math.random()*(10);
        double V2 = Math.random()*(10);

// Check that L1L2 > 0  
        if((int)L1 == 0 && (int)L2 == 0) {
            L2++;
        }
// Check that L1B2B3 >= 100         
        if((int)B1 == 0) {
            B1++;
        }
// Check that V1V2 > 0          
        if((int)V1 == 0 && (int)V2 == 0) {
            V2++;
        }
// Compute check digit with hashOp method       
        double C = (hashOp((int)L1) +L2 + hashOp((int)B1) +B2 + hashOp((int)B3) +V1 + hashOp((int)V2))%10;

// Convert the generated numbers to String      
       String laendercode     = (int)L1+""+(int)L2;
       String bandnr          = (int)B1+""+(int)B2+""+(int)B3;
       String verlagsnr       = (int)V1+""+(int)V2;
       String checksum        = (int)C+"";

// Generate random chars
       Random r = new Random();
       char c1 = (char)(r.nextInt(26) + 'A');
       char c2 = (char)(r.nextInt(26) + 'A');
       char c3 = (char)(r.nextInt(26) + 'A');

        return c1+ "-" + c2 + laendercode + "-" + bandnr + "-" + verlagsnr + "-" +c3 +checksum;
    }

public int hashOp(int i)
{
    // used to determine C
    int doubled = 2 * i;
    if ( doubled >= 10 ) {
        doubled = doubled - 9;
    }
    return doubled;
}
}

