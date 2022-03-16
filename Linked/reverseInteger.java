/**
Reverse digits of an integer.
Example1: x = 123, return 321
 */
public class reverseInteger 
{    
    
    public int mysolution (int x)
    {
        long result = 0;//set long to handle overflow
        
        while(x!= 0)
        {
            int end = x%10;
            result = result*10 + end;
            x = x/10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)// handle overflow
            {
                return 0;
            }
        }
        return (int)result;
    }//solution end
}