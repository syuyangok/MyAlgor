/**
Determine whether an integer is a palindrome. 
Do this without extra space.
1 Determine by see if reverse int == origianl
2 Find the length. the comapre the first and the last digit. If not match, break;
 */
import java.util.*;

public class palNumber 
{    
    public boolean mysolution1(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
     rev = rev*10 + x%10;
     x = x/10;
    }
    return (x==rev || x==rev/10);//x keep smaller, then compare small x with rev.
}
    private static boolean mysolution (int x)
    {
        if (x<0)
        {
            return false;
        }
        
        // first determine the lengh of int
        int len =0;
        
        
        int lx = x;
        while(lx/10 != 0)
        {
            len++;
            lx= lx/10;
             
        }
        len = len+1;
        System.out.println(len);
        
        boolean pal = true;
        int half = len/2;
        int smallR =0;
        
        for (int i = 1; i <= half; i++ )//run half time
        {
           smallR = x%10;
           System.out.println("smallR is: " + smallR);
           int base = (int)Math.pow(10, (len-1));       
            
           int big = x/base;
           System.out.println("big is: " + big);
           
           if (smallR != big)
           {
               pal = false;
               break;
           }
           x = x%base;
           x = x/10;
           len--;
           len--;
        }
        return pal;
    }//solution end

    public static void main(String args[])
    {
        System.out.println(mysolution(12301));
    }
}